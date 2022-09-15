package com.github.myibu.mapweb.amap.converter;

import com.github.myibu.mapweb.amap.client.AmapResponse;
import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 高德WebAPI响应转换器
 * @author hdh
 * Created on 2022/7/30
 */
public class AmapHttpMessageConverter extends AbstractHttpMessageConverter<AmapResponse> {

    public AmapHttpMessageConverter() {
        super(MediaType.APPLICATION_JSON, new MediaType("application", "*+json"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz == AmapResponse.class;
    }

    @Override
    protected AmapResponse readInternal(Class<? extends AmapResponse> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        long contentLength = inputMessage.getHeaders().getContentLength();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(contentLength >= 0 ? (int) contentLength : StreamUtils.BUFFER_SIZE);
        StreamUtils.copy(inputMessage.getBody(), bos);
        JSONObject rawResponse = new JSONObject(bos.toString(StandardCharsets.UTF_8));
        AmapResponse amapResponse = new AmapResponse(rawResponse.optInt("status"),
                rawResponse.optInt("count", 0),
                rawResponse.optString("infocode"),
                rawResponse.optString("info"));
        for (String param: rawResponse.keySet()) {
            if (!AmapResponse.COMMON_PARAMS.contains(param)) {
                amapResponse.getData().put(param, rawResponse.get(param));
            }
        }
        return amapResponse;
    }

    @Override
    protected void writeInternal(AmapResponse amapResponse, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        StreamUtils.copy(new JSONObject(amapResponse).toString().getBytes(StandardCharsets.UTF_8), outputMessage.getBody());
    }
}
