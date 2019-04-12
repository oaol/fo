# fo all project

## 组织结构

```lua

fo
├── fo-common -- common
└── fo-up -- user permission

```


## 配置分离

> run project

1. 添加环境变量 -Dspring.config.location='/Users/bryce/codes/ls/java/fo/fo-config/fo-up/'

> 单元测试

1. 默认读取 xx/fo/fo-config/fo-up

## tomcat 部署

1. 部署 war 包
1. tomcat bin 目录下新建 setenv.sh 文件，添加配置文件路径环境变量  

```shell

#!/bin/sh

JAVA_OPTS="$JAVA_OPTS -Dspring.config.location=xxx/fo-config/ -Xms256m -Xmx1024m"

```

## editorconfig

see .editconfig file

eclipse need install plugins

## schedule

1. shiro
2. druid
3. redis
4. WebSocket
5. cache
   1. 缓存穿透
   2. 缓存雪崩
   3. 缓存击穿

## noted

> 1. response status use http status, return the real result


# 参考

*[WebSocket](http://www.ruanyifeng.com/blog/2017/05/websocket.html), by 阮一峰
* [springboot集成shiro](http://blog.csdn.net/catoop/article/details/50520958 
), by catoop
* [shuzheng 权限管理](https://gitee.com/shuzheng/zheng/tree/master/zheng-upms), by shuzheng
* [单点登录原理](http://shuzheng5201314.iteye.com/blog/2343910), by shuzheng
* [基于资源的权限管理](http://globeeip.iteye.com/blog/1236167), by globeeip