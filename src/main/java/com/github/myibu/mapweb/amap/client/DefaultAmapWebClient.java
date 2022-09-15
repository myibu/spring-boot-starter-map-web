package com.github.myibu.mapweb.amap.client;

import com.github.myibu.mapweb.common.MapWebClientException;
import com.github.myibu.mapweb.amap.api.AmapWebApi;
import com.github.myibu.mapweb.amap.api.AmapWebApiError;
import com.github.myibu.mapweb.amap.config.AmapClientProperties;
import com.github.myibu.mapweb.common.entity.GeocodeAddress;
import com.github.myibu.mapweb.common.entity.PIOAddress;
import com.github.myibu.mapweb.common.api.CommonMapWebApiError;
import com.github.myibu.mapweb.common.api.MapWebApi;
import com.github.myibu.mapweb.common.entity.GpsLocation;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.github.myibu.mapweb.amap.api.AmapWebApiError.*;

/**
 * 高德地图WebAPI缺省实现
 * @author hdh
 * Created on 2022/7/29
 */
public class DefaultAmapWebClient implements AmapWebClient {
    private final RestTemplate restTemplate;
    private final AmapClientProperties clientProperties;

    public DefaultAmapWebClient(RestTemplate restTemplate, AmapClientProperties properties) {
        this.restTemplate = restTemplate;
        this.clientProperties = properties;
    }

    @Override
    public GpsLocation address2Gps(String address, Map<String, String> extraParams) throws MapWebClientException {
        if (!StringUtils.hasText(address)) {
            throw new MapWebClientException(CommonMapWebApiError.REQUIRED_PARAMETER_MISSED);
        }
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("address", address);
        return (GpsLocation) doExecuteAndGet(AmapWebApi.GEOCODE_GEO, uriVariables, extraParams);
    }

    @Override
    public GeocodeAddress gps2Address(GpsLocation gpsLocation, Map<String, String> extraParams) throws MapWebClientException {
        if (null == gpsLocation) {
            throw new MapWebClientException(CommonMapWebApiError.REQUIRED_PARAMETER_MISSED);
        }
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("location", gpsLocation.toLngLat());
        GeocodeAddress geocodeAddress = (GeocodeAddress) doExecuteAndGet(AmapWebApi.GEOCODE_RGEO, uriVariables, extraParams);
        if (geocodeAddress != null && geocodeAddress.getLocation() == null) {
            geocodeAddress.setLocation(new GpsLocation(gpsLocation.getLat(), gpsLocation.getLng()));
        }
        return geocodeAddress;
    }

    @Override
    public List<PIOAddress> searchPoiListByKeyword(String keywords, Map<String, String> extraParams) throws MapWebClientException {
        if (!StringUtils.hasText(keywords)
                && (extraParams == null || !StringUtils.hasText(extraParams.getOrDefault("types", null)))) {
            throw new MapWebClientException(CommonMapWebApiError.REQUIRED_PARAMETER_MISSED);
        }
        Map<String, String> uriVariables = new HashMap<>();
        if (StringUtils.hasText(keywords)) {
            uriVariables.put("keywords", keywords);
        }
        return (List<PIOAddress>) doExecuteAndGet(AmapWebApi.PLACE_TEXT, uriVariables, extraParams);
    }

    @Override
    public Object execute(MapWebApi mapWebApi, Map<String, String> uriVariables, Map<String, String> extraParams) {
        if (uriVariables == null) {
            uriVariables = new HashMap<>();
        }
        return doExecuteAndGet(mapWebApi, uriVariables, extraParams);
    }

    private Object doExecuteAndGet(MapWebApi apiUrl, Map<String, String> uriVariables, Map<String, String> extraParams) throws MapWebClientException {
        AmapRequest amapRequest = AmapRequest.builder().host(clientProperties.getHost()).appKey(clientProperties.getAppKey()).apiUrl(apiUrl).uriVariables(uriVariables).extraParams(extraParams).build();
        ResponseEntity<AmapResponse> response = restTemplate.getForEntity(amapRequest.getUri(), AmapResponse.class);
        AmapResponse amapResponse = response.getBody();
        if (amapResponse == null) {
            throw new MapWebClientException(AmapWebApiError.UNKNOWN_ERROR);
        }
        if (!OK.getErrorCode().equals(amapResponse.getInfoCode())) {
            throw new MapWebClientException(AmapWebApiError.indexByCode(amapResponse.getInfoCode()));
        }
        if (apiUrl.getResponseParser() != null) {
            return apiUrl.getResponseParser().parse(amapResponse);
        }
        return amapResponse;
    }
}
