package com.cognizant.config_client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimitsServiceProperiesConfiguration {
    private int minimum;
    private int maximum;
    private String profileName;
}
