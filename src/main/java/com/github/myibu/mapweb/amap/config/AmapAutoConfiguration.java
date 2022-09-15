package com.github.myibu.mapweb.amap.config;

import com.github.myibu.mapweb.amap.client.AmapWebClient;
import com.github.myibu.mapweb.amap.client.DefaultAmapWebClient;
import com.github.myibu.mapweb.amap.converter.AmapHttpMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * 高德地图WebAPI主动注入
 * @author hdh
 * Created on 2022/7/29
 */
@ConditionalOnProperty(name = "spring.mapweb.amap.enabled", matchIfMissing = true)
@EnableConfigurationProperties({AmapClientProperties.class})
public class AmapAutoConfiguration {
    @Bean("amapRestTemplate")
    @ConditionalOnMissingBean
    public RestTemplate amapRestTemplate() {
        return new RestTemplate(Arrays.asList(new AmapHttpMessageConverter()));
    }

    @Bean
    @ConditionalOnMissingBean
    public AmapWebClient amapWebClient(@Qualifier("amapRestTemplate") RestTemplate amapRestTemplate, AmapClientProperties properties) {
        return new DefaultAmapWebClient(amapRestTemplate, properties);
    }
}
