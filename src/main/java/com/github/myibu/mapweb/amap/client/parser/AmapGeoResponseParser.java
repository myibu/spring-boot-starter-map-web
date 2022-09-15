package com.github.myibu.mapweb.amap.client.parser;

import com.github.myibu.mapweb.common.entity.GpsLocation;
import com.github.myibu.mapweb.common.response.MapResponse;
import com.github.myibu.mapweb.common.response.MapResponseParser;
import org.json.JSONArray;

public class AmapGeoResponseParser implements MapResponseParser {
    @Override
    public Object parse(MapResponse response) {
        String location = ((JSONArray)response.getData().get("geocodes")).getJSONObject(0).getString("location");
        return new GpsLocation(Double.parseDouble(location.split(",")[1]), Double.parseDouble(location.split(",")[0]));
    }
}