package com.github.myibu.mapweb.common.api;

/**
 * 公共地图api错误码
 * @author hdh
 * Created on 2022/7/30
 */
public enum CommonMapWebApiError implements MapWebApiError {
    REQUIRED_PARAMETER_MISSED("-1", "必要参数缺失"),
    ;
    private final String errorCode;
    private final String errorDesc;

    CommonMapWebApiError(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return name();
    }

    @Override
    public String getErrorDesc() {
        return errorDesc;
    }
}
