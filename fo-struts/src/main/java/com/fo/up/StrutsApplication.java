package com.fo.up;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author bryce scanBasePackages= {"com.fo.common"} scan common module
 *         configurations
 */
@SpringBootApplication(scanBasePackages = { "com.fo.up", "com.fo.common" })
public class StrutsApplication {

    public static void main(String[] args) {
        if (System.getProperty("spring.config.location") != null) {
            System.setProperty("spring.config.name", "fo-struts" + File.separator + "application");
        }
        SpringApplication.run(StrutsApplication.class, args);
    }

}