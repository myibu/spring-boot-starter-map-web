package com.github.myibu.mapweb;

/**
 * 地图服务商
 * @author hdh
 * Created on 2022/7/30
 */
public enum MapServiceProvider {
    AMAP("https://lbs.amap.com/api/webservice/gettingstarted", "高德Web服务API");

    private final String wikiHost;
    private final String desc;

    MapServiceProvider(String wikiHost, String desc) {
        this.wikiHost = wikiHost;
        this.desc = desc;
    }
}
