package com.github.myibu.mapweb.common.entity;

/**
 * 地址信息
 * @author hdh
 * Created on 2022/7/29
 */
public class GeocodeAddress {
    /**
     * 经纬度坐标
     */
    private GpsLocation location;
    /**
     * 国家
     */
    private String formattedAddress;
    /**
     * 国家
     */
    private String country;
    /**
     * 地址所在的省份名
     */
    private String province;
    /**
     * 地址所在的城市名
     */
    private String city;
    /**
     * 区县名
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 街道
     */
    private String streetNumber;
    /**
     * 区域编码
     */
    private String adcode;

    public GpsLocation getLocation() {
        return location;
    }

    public void setLocation(GpsLocation location) {
        this.location = location;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    @Override
    public String toString() {
        return "GeocodeAddress{" +
                "location=" + location +
                ", formattedAddress='" + formattedAddress + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", adcode='" + adcode + '\'' +
                '}';
    }
}
