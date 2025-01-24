package com.ciptadana.bareksaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BareksaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BareksaApiApplication.class, args);
	}

}
