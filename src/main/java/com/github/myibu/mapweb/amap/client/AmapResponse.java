package com.github.myibu.mapweb.amap.client;

import com.github.myibu.mapweb.common.response.MapResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 高德地图WebAPI响应
 * @author hdh
 * Created on 2022/7/29
 */
public class AmapResponse implements MapResponse {
    public final static List<String> COMMON_PARAMS = List.of("status", "count", "infocode", "info");

    public AmapResponse(Integer status, Integer count, String infoCode, String info) {
        this.status = status;
        this.count = count;
        this.infoCode = infoCode;
        this.info = info;
    }

    public AmapResponse() {
    }

    private Integer status;
    private Integer count;
    private String infoCode;
    private String info;
    private Map<String, Object> data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getInfoCode() {
        return infoCode;
    }

    public void setInfoCode(String infoCode) {
        this.infoCode = infoCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        if (data == null) {
            data = new HashMap<>(0);
        }
        return data;
    }
}
