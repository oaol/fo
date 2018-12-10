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

