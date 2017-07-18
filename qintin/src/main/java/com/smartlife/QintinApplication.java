package com.smartlife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smartlife.repositories")
public class QintinApplication {

	public static void main(String[] args) {
		SpringApplication.run(QintinApplication.class, args);
	}
}
