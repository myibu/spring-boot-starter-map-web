package com.github.myibu.mapweb.amap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 注释
 *
 * @author hdh
 * Created on 2022/7/29
 */
@ConfigurationProperties(AmapClientProperties.PREFIX)
public class AmapClientProperties {
    public static final String PREFIX = "spring.mapweb.amap";

    private Boolean enabled;
    private String host;
    private String appKey;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        return "AmapClientProperties{" +
                "enabled=" + enabled +
                ", host='" + host + '\'' +
                ", appKey='" + appKey + '\'' +
                '}';
    }
}
