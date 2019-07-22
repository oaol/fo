package com.fo.up.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件 demo
 * 
 * @author bryce
 *
 */
@Component
@ConfigurationProperties("up")
public class TestProperties {

    private String test;
    private Base base = new Base();

    public static class Base {
        private String pro1;
        private int pro2;

        public String getPro1() {
            return pro1;
        }

        public void setPro1(String pro1) {
            this.pro1 = pro1;
        }

        public int getPro2() {
            return pro2;
        }

        public void setPro2(int pro2) {
            this.pro2 = pro2;
        }
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

}
