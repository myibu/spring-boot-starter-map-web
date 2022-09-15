package com.github.myibu.mapweb.common.response;

/**
 * 地图WebAPI响应解析器
 * @author hdh
 * Created on 2022/7/30
 */
public interface MapResponseParser {
    Object parse(MapResponse response);
}
