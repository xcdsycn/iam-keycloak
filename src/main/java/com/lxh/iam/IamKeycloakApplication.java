package com.lxh.iam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxh.iam.mapper")
public class IamKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamKeycloakApplication.class, args);
	}

}
