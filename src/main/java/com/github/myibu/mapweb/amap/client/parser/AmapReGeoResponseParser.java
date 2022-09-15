package com.github.myibu.mapweb.amap.client.parser;

import com.github.myibu.mapweb.common.entity.GeocodeAddress;
import com.github.myibu.mapweb.common.response.MapResponse;
import com.github.myibu.mapweb.common.response.MapResponseParser;
import org.json.JSONObject;

public class AmapReGeoResponseParser implements MapResponseParser {
    @Override
    public Object parse(MapResponse response) {
        GeocodeAddress geocodeAddress = new GeocodeAddress();
        JSONObject regeoCode = (JSONObject)response.getData().get("regeocode");
        geocodeAddress.setFormattedAddress(regeoCode.getString("formatted_address"));
        JSONObject addressComponent = regeoCode.getJSONObject("addressComponent");
        geocodeAddress.setCountry(addressComponent.optString("country"));
        geocodeAddress.setProvince(addressComponent.optString("province"));
        Object city = addressComponent.opt("city");
        geocodeAddress.setCity((city instanceof String) ? (String) city : addressComponent.optString("province"));
        geocodeAddress.setDistrict(addressComponent.optString("district"));
        if (null != addressComponent.optJSONObject("streetNumber")) {
            geocodeAddress.setStreet(addressComponent.optJSONObject("streetNumber").optString("street"));
            geocodeAddress.setStreetNumber(addressComponent.optJSONObject("streetNumber").optString("number"));
        }
        geocodeAddress.setAdcode(regeoCode.getJSONObject("addressComponent").optString("adcode"));
        return geocodeAddress;
    }
}