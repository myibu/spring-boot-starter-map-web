package com.github.myibu.mapweb.amap.api;

import com.github.myibu.mapweb.common.api.MapWebApiError;

/**
 * 高德地图WebAPI错误码
 * @author hdh
 * Created on 2022/7/29
 */
public enum AmapWebApiError implements MapWebApiError {
    OK("10000", "请求正常"),
    INVALID_USER_KEY("10001", "key不正确或过期"),
    SERVICE_NOT_AVAILABLE("10002", "没有权限使用相应的服务或者请求接口的路径拼写错误"),
    DAILY_QUERY_OVER_LIMIT("10003", "访问已超出日访问量"),
    ACCESS_TOO_FREQUENT("10004", "单位时间内访问过于频繁"),
    INVALID_USER_IP("10005", "IP白名单出错，发送请求的服务器IP不在IP白名单内"),
    INVALID_USER_DOMAIN("10006", "绑定域名无效"),
    INVALID_USER_SIGNATURE("10007", "数字签名未通过验证"),
    INVALID_USER_SCODE("10008", "MD5安全码未通过验证"),
    USERKEY_PLAT_NOMATCH("10009", "请求key与绑定平台不符"),
    IP_QUERY_OVER_LIMIT("10010", "IP访问超限"),
    NOT_SUPPORT_HTTPS("10011", "服务不支持https请求"),
    INSUFFICIENT_PRIVILEGES("10012", "权限不足，服务请求被拒绝"),
    USER_KEY_RECYCLED("10013", "Key被删除"),
    QPS_HAS_EXCEEDED_THE_LIMIT("10014", "云图服务QPS超限"),
    GATEWAY_TIMEOUT("10015", "受单机QPS限流限制"),
    SERVER_IS_BUSY("10016", "服务器负载过高"),
    RESOURCE_UNAVAILABLE("10017", "所请求的资源不可用"),
    CQPS_HAS_EXCEEDED_THE_LIMIT("10019", "使用的某个服务总QPS超限"),
    CKQPS_HAS_EXCEEDED_THE_LIMIT("10020", "某个Key使用某个服务接口QPS超出限制"),
    CUQPS_HAS_EXCEEDED_THE_LIMIT("10021", "账号使用某个服务接口QPS超出限制"),
    INVALID_REQUEST("10026", "账号处于被封禁状态"),
    ABROAD_DAILY_QUERY_OVER_LIMIT("10029", "某个Key的QPS超出限制"),
    NO_EFFECTIVE_INTERFACE("10041", "请求的接口权限过期"),
    USER_DAILY_QUERY_OVER_LIMIT("10044", "账号维度日调用量超出限制"),
    USER_ABROAD_DAILY_QUERY_OVER_LIMIT("10045", "账号维度海外服务日调用量超出限制"),
    INVALID_PARAMS("20000", "请求参数非法"),
    MISSING_REQUIRED_PARAMS("20001", "缺少必填参数"),
    ILLEGAL_REQUEST("20002", "请求协议非法"),
    UNKNOWN_ERROR("20003", "其他未知错误"),
    INSUFFICIENT_ABROAD_PRIVILEGES("20011", "查询坐标或规划点（包括起点、终点、途经点）在海外，但没有海外地图权限"),
    ILLEGAL_CONTENT("20012", "查询信息存在非法内容"),
    OUT_OF_SERVICE("20800", "规划点（包括起点、终点、途经点）不在中国陆地范围内"),
    NO_ROADS_NEARBY("20801", "划点（起点、终点、途经点）附近搜不到路"),
    ROUTE_FAIL("20802", "路线计算失败，通常是由于道路连通关系导致"),
    OVER_DIRECTION_RANGE("20803", "起点终点距离过长。"),
    ENGINE_RESPONSE_DATA_ERROR("300**", "服务响应失败。"),
    QUOTA_PLAN_RUN_OUT("40000", "余额耗尽"),
    GEOFENCE_MAX_COUNT_REACHED("40001", "围栏个数达到上限"),
    SERVICE_EXPIRED("40002", "购买服务到期"),
    ABROAD_QUOTA_PLAN_RUN_OUT("40003", "海外服务余额耗尽"),

    UNKNOWN_INFO_CODE("500000", "未知的infoCode");
    ;
    private final String errorCode;
    private final String errorDesc;

    AmapWebApiError(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public static AmapWebApiError indexByCode(String errorCode) {
        for (AmapWebApiError error: values()) {
            if (error.errorCode.equals(errorCode)) {
                return error;
            }
        }
        return UNKNOWN_INFO_CODE;
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
