package com.github.myibu.mapweb.common.entity;

/**
 * POI地址
 * @author hdh
 * Created on 2022/7/30
 */
public class PIOAddress {
    /**
     * 唯一ID
     */
    String id;
    /**
     * 名称
     */
    String name;
    /**
     * 兴趣点类型
     */
    String type;
    /**
     * 兴趣点类型编码
     */
    String typeCode;
    /**
     * 行业类型
     */
    String bizType;
    /**
     * 地址
     */
    String address;
    /**
     * 经纬度
     */
    GpsLocation location;
    /**
     * POI的电话
     */
    String tel;
    /**
     * POI所在省份名称
     */
    String provinceName;
    /**
     * 城市名
     */
    String cityName;
    /**
     * 区域名称
     */
    String adName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GpsLocation getLocation() {
        return location;
    }

    public void setLocation(GpsLocation location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    @Override
    public String toString() {
        return "PIOAddress{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", bizType='" + bizType + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                ", tel='" + tel + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", adName='" + adName + '\'' +
                '}';
    }
}
