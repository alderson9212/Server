package com.fenoreste.saicoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.fenoreste.saicoop.util","com.fenoreste.saicoop.controller","com.fenoreste.saicoop.service"})
@EntityScan("com.fenoreste.saicoop.entity")
public class SaiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaiServerApplication.class, args);
	}

}
