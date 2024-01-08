package com.trash2cashbackend.trash2cashbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Trash2cashBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Trash2cashBackendApplication.class, args);
	}

}
