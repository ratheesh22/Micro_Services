package com.jpa.mappings.multipledb;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultipleDbConfig {


    @ConfigurationProperties(prefix = "spring.datasource.world")
    @Bean("dataSourcePropertiesWorld")
    public DataSourceProperties dataSourcePropertiesWorld(){
        return  new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSourceProperties dataSourceProperties(){
        return  new DataSourceProperties();
    }

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
    @Bean("dataSourceWorld")
    public DataSource dataSourceWorld(@Qualifier("dataSourcePropertiesWorld") DataSourceProperties dataSourcePropertiesWorld){
        return dataSourcePropertiesWorld.initializeDataSourceBuilder().build();
    }



}
