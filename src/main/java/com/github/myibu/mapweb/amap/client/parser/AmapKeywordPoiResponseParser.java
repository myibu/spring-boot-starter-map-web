package com.github.myibu.mapweb.amap.client.parser;

import com.github.myibu.mapweb.common.entity.GpsLocation;
import com.github.myibu.mapweb.common.entity.PIOAddress;
import com.github.myibu.mapweb.common.response.MapResponse;
import com.github.myibu.mapweb.common.response.MapResponseParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AmapKeywordPoiResponseParser implements MapResponseParser {
    @Override
    public Object parse(MapResponse response) {
        List<PIOAddress> poiAddressList = new ArrayList<>();
        JSONArray pois = (JSONArray)response.getData().get("pois");
        if (pois != null) {
            for(int i=0; i< pois.length(); i++) {
                JSONObject poi = pois.getJSONObject(i);
                PIOAddress poiAddress = new PIOAddress();
                poiAddress.setId(poi.optString("id"));
                poiAddress.setName(poi.optString("name"));
                poiAddress.setType(poi.optString("type"));
                poiAddress.setTypeCode(poi.optString("typecode"));
                poiAddress.setBizType(poi.optString("biz_type"));
                poiAddress.setAddress(poi.optString("address"));
                String location = poi.optString("location");
                poiAddress.setLocation(new GpsLocation(Double.parseDouble(location.split(",")[1]), Double.parseDouble(location.split(",")[0])));
                poiAddress.setTel(poi.optString("tel"));
                poiAddress.setProvinceName(poi.optString("pname"));
                poiAddress.setCityName(poi.optString("cityname"));
                poiAddress.setAdName(poi.optString("adname"));
                poiAddressList.add(poiAddress);
            }
        }
        return poiAddressList;
    }
}