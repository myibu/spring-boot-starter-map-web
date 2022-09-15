package com.github.myibu.mapweb.common.api;

/**
 * 地图api错误码
 * @author hdh
 * Created on 2022/7/29
 */
public interface MapWebApiError {
    String getErrorCode();
    String getErrorMsg();
    String getErrorDesc();
}
