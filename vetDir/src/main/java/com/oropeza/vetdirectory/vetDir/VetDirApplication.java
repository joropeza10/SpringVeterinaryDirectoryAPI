package com.oropeza.vetdirectory.vetDir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oropeza.vetdirectory")
@EntityScan(basePackages = "com.oropeza.vetdirectory")
public class VetDirApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetDirApplication.class, args);
	}

}
