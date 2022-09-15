package com.github.myibu.mapweb;

import com.github.myibu.mapweb.common.MapWebClientException;
import com.github.myibu.mapweb.common.api.MapWebApi;
import com.github.myibu.mapweb.common.entity.GeocodeAddress;
import com.github.myibu.mapweb.common.entity.GpsLocation;
import com.github.myibu.mapweb.common.entity.PIOAddress;

import java.util.List;
import java.util.Map;

/**
 * 地图WebAPI客户端
 * @author hdh
 * Created on 2022/7/29
 */
public interface MapWebClient {
    default GpsLocation address2Gps(String address) throws MapWebClientException {
        return address2Gps(address, null);
    }

    GpsLocation address2Gps(String address, Map<String, String> extraParams) throws MapWebClientException;

    default GeocodeAddress gps2Address(GpsLocation gpsLocation) throws MapWebClientException {
        return gps2Address(gpsLocation, null);
    }

    GeocodeAddress gps2Address(GpsLocation gpsLocation, Map<String, String> extraParams) throws MapWebClientException;

    default List<PIOAddress> searchPoiListByKeyword(String keywords) throws MapWebClientException {
        return searchPoiListByKeyword(keywords, null);
    }

    List<PIOAddress> searchPoiListByKeyword(String keywords, Map<String, String> extraParams) throws MapWebClientException;

    default  Object execute(MapWebApi mapWebApi, Map<String, String> uriVariables) throws MapWebClientException {
        return execute(mapWebApi, uriVariables, null);
    }

    Object execute(MapWebApi mapWebApi, Map<String, String> uriVariables, Map<String, String> extraParams) throws MapWebClientException;
}
