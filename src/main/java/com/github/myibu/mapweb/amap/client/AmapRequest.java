package com.github.myibu.mapweb.amap.client;

import com.github.myibu.mapweb.common.api.MapWebApi;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 高德地图WebAPI请求
 * @author hdh
 * Created on 2022/7/30
 */
public class AmapRequest {
    private URI uri;

    public AmapRequest() {
    }

    public AmapRequest(String host, MapWebApi apiUrl, Map<String, String> uriVariables, Map<String, String> extraParams, String appKey) {
        if (uriVariables == null) {
            uriVariables = new HashMap<>(1);
        }
        if (extraParams != null) {
            uriVariables.putAll(extraParams);
        }
        uriVariables.put("key", appKey);
        uriVariables.put("output", "JSON");
        StringBuilder queryParams = new StringBuilder();
        for (Map.Entry<?,?> entry : uriVariables.entrySet()) {
            if (entry.getValue() == null) continue;
            if (queryParams.length() > 0) {
                queryParams.append("&");
            }
            queryParams.append(String.format("%s=%s",
                    URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8),
                    URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8)));
        }
        this.uri = URI.create(host + apiUrl.getUrl() + "?" + queryParams);
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public static final class Builder {
        private String host;
        private MapWebApi apiUrl;
        private Map<String, String> uriVariables;
        private Map<String, String> extraParams;
        private String appKey;

        public AmapRequest build() {
            return new AmapRequest(host, apiUrl, uriVariables, extraParams, appKey);
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }
        public Builder apiUrl(MapWebApi apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public Builder uriVariables(Map<String, String> uriVariables) {
            this.uriVariables = uriVariables;
            return this;
        }

        public Builder extraParams(Map<String, String> extraParams) {
            this.extraParams = extraParams;
            return this;
        }

        public Builder appKey(String appKey) {
            this.appKey = appKey;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
