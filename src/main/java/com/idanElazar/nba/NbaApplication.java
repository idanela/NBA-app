package com.idanElazar.nba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class NbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaApplication.class, args);
	}

}
