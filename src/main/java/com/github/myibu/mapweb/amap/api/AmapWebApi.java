package com.github.myibu.mapweb.amap.api;

import com.github.myibu.mapweb.amap.client.parser.AmapGeoResponseParser;
import com.github.myibu.mapweb.amap.client.parser.AmapKeywordPoiResponseParser;
import com.github.myibu.mapweb.amap.client.parser.AmapReGeoResponseParser;
import com.github.myibu.mapweb.common.api.MapWebApi;
import com.github.myibu.mapweb.common.response.MapResponseParser;

/**
 * 高德地图WebAPI路径接口
 * @author hdh
 * Created on 2022/7/29
 */
public enum AmapWebApi implements MapWebApi {
    /**
     * 地理编码
     */
    GEOCODE_GEO("/v3/geocode/geo", new AmapGeoResponseParser()),

    /**
     * 逆地理编码
     */
    GEOCODE_RGEO("/v3/geocode/regeo", new AmapReGeoResponseParser()),

    /**
     * 步行路径规划
     */
    DIRECTION_WALKING("/v3/direction/walking"),

    /**
     * 公交路径规划
     */
    DIRECTION_TRANSIT("/v3/direction/transit/integrated"),

    /**
     * 驾车路径规划
     */
    DIRECTION_DRIVING("/v3/direction/driving"),

    /**
     * 骑行路径规划
     */
    DIRECTION_BICYCLING("/v4/direction/bicycling"),

    /**
     * 未来路径规划
     */
    ETD_DRIVING("/v4/etd/driving"),

    /**
     * 行政区域查询
     */
    CONFIG_DISTRICT("/v3/config/district"),

    /**
     * 关键字搜索
     */
    PLACE_TEXT("/v3/place/text", new AmapKeywordPoiResponseParser()),

    /**
     * 周边搜索
     */
    PLACE_AROUND("/v3/place/around"),

    /**
     * 多边形搜索
     */
    PLACE_POLYGON("/v3/place/polygon"),

    /**
     * ID查询
     */
    PLACE_DETAIL("/v3/place/detail"),

    /**
     * AOI边界查询
     */
    AOI_POLYLINE("/v5/aoi/polyline"),

    /**
     * IP定位
     */
    IP("/v3/ip"),

    /**
     * 静态地图
     */
    STATIC_MAP("/v3/staticmap"),

    /**
     * 坐标转换
     */
    COORDINATE_CONVERT("/v3/assistant/coordinate/convert"),

    /**
     * 天气查询
     */
    WEATHER_INFO("/v3/weather/weatherInfo"),

    /**
     * 输入提示
     */
    INPUT_TIPS("/v3/assistant/inputtips"),

    /**
     * 矩形区域交通态势
     */
    TRAFFIC_STATUS_RECTANGLE("/v3/traffic/status/rectangle"),

    /**
     * 圆形区域交通态势
     */
    TRAFFIC_STATUS_CIRCLE("/v3/traffic/status/circle"),

    /**
     * 指定线路交通态势
     */
    TRAFFIC_STATUS_ROAD("/v3/traffic/status/road"),

    /**
     * 轨迹纠偏
     */
    GRASPROAD_DRIVING("/v4/grasproad/driving"),
    ;

    AmapWebApi(String url) {
        this(url, null);
    }

    AmapWebApi(String url, MapResponseParser responseParser) {
        this.url = url;
        this.responseParser = responseParser;
    }

    private final String url;
    private final MapResponseParser responseParser;

    @Override
    public String getUrl() {
        return url;
    }

    public MapResponseParser getResponseParser() {
        return responseParser;
    }
}
