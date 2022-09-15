package com.github.myibu.mapweb.common.api;

import com.github.myibu.mapweb.common.response.MapResponseParser;

/**
 * 地图api路径接口
 * @author hdh
 * Created on 2022/7/29
 */
public interface MapWebApi {
    String getUrl();
    MapResponseParser getResponseParser();
}
