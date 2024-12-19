package com.jpa.mappings;

import com.jpa.mappings.multipledb.WorldDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class JpaMappingAllApplication  {

		@Autowired
		private WorldDataSourceProperties worldDataSourceProperties;

		@Autowired
		private DataSourceProperties dataSourceProperties;

		@Autowired
		@Qualifier("dataSourcePropertiesWorld")
		private DataSourceProperties dataSourcePropertiesWorld;



	public static void main(String[] args) {
		SpringApplication.run(JpaMappingAllApplication.class, args);

	}

	@Bean
	public  ApplicationRunner applicationRunner(){
		return applicationRunner->{
			System.out.println(worldDataSourceProperties);
			System.out.println(dataSourceProperties.getUrl());
			System.out.println(dataSourcePropertiesWorld.getUrl());




		};
	}

}
