package com.fo.up;

import java.io.File;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.setProperty("spring.config.name", "fo-struts" + File.separator + "application");
        return application.sources(StrutsApplication.class);
    }

}
