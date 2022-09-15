package com.github.myibu.mapweb.common;

import com.github.myibu.mapweb.common.api.MapWebApiError;

/**
 * 注释
 *
 * @author hdh
 * Created on 2022/7/29
 */
public class MapWebClientException extends RuntimeException implements MapWebApiError {
    private final String errorCode;
    private final String errorMsg;
    private final String errorDesc;

    public MapWebClientException(MapWebApiError error) {
        this.errorCode = error.getErrorCode();
        this.errorMsg = error.getErrorMsg();
        this.errorDesc = error.getErrorDesc();
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }

    @Override
    public String getMessage() {
        return errorCode + ":" + errorMsg + ":" + errorDesc;
    }

    @Override
    public String toString() {
        return "MapWebClientException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                '}';
    }
}
