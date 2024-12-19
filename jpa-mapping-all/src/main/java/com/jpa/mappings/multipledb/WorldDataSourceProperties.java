package com.jpa.mappings.multipledb;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.datasource.world")
@Component
@ToString
@Getter
@Setter
public class WorldDataSourceProperties {


    private String url;
    private String username;
    private String password;
}
