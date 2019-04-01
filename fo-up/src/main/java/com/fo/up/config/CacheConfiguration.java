package com.fo.up.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

//    @Bean
//    public CacheManager cacheManager() {
//        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder() 
////                .withCache("preConfigured",
////                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10))) 
//                .build(); 
//        return cacheManager;
//    }

}
