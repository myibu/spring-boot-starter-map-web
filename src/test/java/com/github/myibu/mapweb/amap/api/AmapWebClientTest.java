package com.github.myibu.mapweb.amap.api;

import com.github.myibu.mapweb.amap.client.AmapWebClient;
import com.github.myibu.mapweb.common.api.MapWebApi;
import com.github.myibu.mapweb.common.entity.GeocodeAddress;
import com.github.myibu.mapweb.common.entity.GpsLocation;
import com.github.myibu.mapweb.common.entity.PIOAddress;
import com.github.myibu.mapweb.common.response.MapResponseParser;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "default")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmapWebClientTest {
    @Autowired
    private AmapWebClient amapWebClient;

    @Test
    public void testAddress2Gps() {
        GpsLocation location = amapWebClient.address2Gps("北京市朝阳区阜通东大街6号");
        System.out.println(location);
    }

    @Test
    public void testGps2Address() {
        GeocodeAddress location = amapWebClient.gps2Address(new GpsLocation(39.990464, 116.481488));
        System.out.println(location);
    }

    @Test
    public void testSearchPoiListByKeyword() {
        List<PIOAddress> poiAddresses = amapWebClient.searchPoiListByKeyword("北京大学");
        System.out.println(poiAddresses);
    }

    @Test
    public void testExecute() {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("address", "北京市朝阳区阜通东大街6号");
        Object poiAddresses = amapWebClient.execute(new MapWebApi() {
            @Override
            public String getUrl() {
                return "/v3/geocode/geo";
            }

            @Override
            public MapResponseParser getResponseParser() {
                return null;
            }
        }, uriVariables);

        System.out.println(poiAddresses);
    }
}
