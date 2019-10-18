//package com.fo.up.config;
//
//import org.springframework.context.annotation.Bean;
//
//public class CacheManneg {
//
//	 @Bean
//	    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//	        return new RedisCacheManager(
//	                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
//	                this.getRedisCacheConfigurationWithTtl(30*60), // 默认策略，未配置的 key 会使用这个
//	                this.getRedisCacheConfigurationMap() // 指定 key 策略
//	        );
//	    }
//
//	    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
//	        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
//	        //SsoCache和BasicDataCache进行过期时间配置
//	        redisCacheConfigurationMap.put("SsoCache", this.getRedisCacheConfigurationWithTtl(24*60*60));
//	        redisCacheConfigurationMap.put("BasicDataCache", this.getRedisCacheConfigurationWithTtl(30*60));
//	        return redisCacheConfigurationMap;
//	    }
//
//	    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
//	        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//	        ObjectMapper om = new ObjectMapper();
//	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//	        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//	        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//	        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
//	                RedisSerializationContext
//	                        .SerializationPair
//	                        .fromSerializer(jackson2JsonRedisSerializer)
//	        ).entryTtl(Duration.ofSeconds(seconds));
//
//	        return redisCacheConfiguration;
//	    }
//
//	    @Bean
//	    public KeyGenerator wiselyKeyGenerator() {
//	        return new KeyGenerator() {
//	            @Override
//	            public Object generate(Object target, Method method, Object... params) {
//	                StringBuilder sb = new StringBuilder();
//	                sb.append(target.getClass().getName());
//	                sb.append("." + method.getName());
//	                if(params==null||params.length==0||params[0]==null){
//	                    return null;
//	                }
//	                String join = String.join("&", Arrays.stream(params).map(Object::toString).collect(Collectors.toList()));
//	                String format = String.format("%s{%s}", sb.toString(), join);
//	                //log.info("缓存key：" + format);
//	                return format;
//	            }
//	        };
//	    }
//
//
//}
