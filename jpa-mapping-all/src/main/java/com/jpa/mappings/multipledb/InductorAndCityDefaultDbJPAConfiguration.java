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
        basePackages = "com/jpa/mappings/instructorAndCity",
        entityManagerFactoryRef = "entityManagerFactoryRef",
        transactionManagerRef = "platformTransactionManager"

)
@EnableTransactionManagement
public class InductorAndCityDefaultDbJPAConfiguration {



    @Bean("entityManagerFactoryRef")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRef
            (EntityManagerFactoryBuilder entityManagerFactoryBuilder
            ,@Qualifier("dataSource") DataSource dataSource){

        return  entityManagerFactoryBuilder.dataSource(dataSource)
                .packages("com/jpa/mappings/instructorAndCity")
                .build();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(@Qualifier("entityManagerFactoryRef") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){

        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }

}
