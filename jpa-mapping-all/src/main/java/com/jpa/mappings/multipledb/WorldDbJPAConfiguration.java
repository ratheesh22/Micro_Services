package com.jpa.mappings.multipledb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com/jpa/mappings/world",
        entityManagerFactoryRef = "entityManagerFactoryWorld",
        transactionManagerRef = "platformTransactionManagerWorld"
)
@EnableTransactionManagement

public class WorldDbJPAConfiguration {





    @Bean("entityManagerFactoryWorld")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWorld
            (EntityManagerFactoryBuilder entityManagerFactoryBuilder
                    ,@Qualifier("dataSourceWorld") DataSource dataSource){

        return  entityManagerFactoryBuilder.dataSource(dataSource)
                .packages("com/jpa/mappings/world")
                .build();
    }

    @Bean("platformTransactionManagerWorld")
    public PlatformTransactionManager platformTransactionManagerWorld(@Qualifier("entityManagerFactoryWorld") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){

        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }

}
