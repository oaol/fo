package com.fo.common.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "fo.common")
@Data
public class ProjectNameConfig {
    private String projectName;
}
