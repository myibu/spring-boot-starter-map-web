package com.github.myibu.mapweb.common.entity;

import java.io.Serializable;

/**
 * 经纬度位置
 * @author hdh
 * Created on 2022/7/29
 */
public class GpsLocation implements Serializable {
    /**
     * 纬度38.76623
     */
    private Double lat;
    /**
     * 经度116.43213
     */
    private Double lng;

    public GpsLocation() {
        this(0.0, 0.0);
    }
    
    public GpsLocation(Integer lat, Integer lng) {
        this.lat = lat.doubleValue();
        this.lng = lng.doubleValue();
    }

    public GpsLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String toString() {
        return lat + ","+ lng;
    }

    public String toLngLat() {
        return lng + ","+ lat;
    }

    public String toLatLng() {
        return lat + ","+ lng;
    }
}