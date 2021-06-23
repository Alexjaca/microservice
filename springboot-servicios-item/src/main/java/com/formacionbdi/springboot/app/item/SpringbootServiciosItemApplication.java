package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
//@RibbonClient(name ="servicio-productos")
@EnableFeignClients
@SpringBootApplication
public class SpringbootServiciosItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosItemApplication.class, args);
	}

}
