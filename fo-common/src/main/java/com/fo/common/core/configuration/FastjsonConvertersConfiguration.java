package com.fo.common.core.configuration;

import java.util.List;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fo.common.core.util.CollectionUtils;

/**
 * use fastjson parse response
 * @author yangchengjie
 * @date 2018-05-05
 * 
 *
 */
@Configuration
public class FastjsonConvertersConfiguration {
    @Bean
    public HttpMessageConverters fastjsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 配置不生效 TODO
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
                );

//        WriteNullListAsEmpty  ：List字段如果为null,输出为[],而非null
//        WriteNullStringAsEmpty ： 字符类型字段如果为null,输出为"",而非null
//        DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
//        WriteNullBooleanAsFalse：Boolean字段如果为null,输出为false,而非null
//        WriteMapNullValue：是否输出值为null的字段,默认为false。
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = CollectionUtils.newArrayList();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }

}