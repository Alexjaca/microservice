package com.formacionbdi.springboot.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.formacionbdi.springboot.app.commons.usuarios.models.entity"}) // spring boot reconoce el package donde se ubican las entity
@SpringBootApplication
public class SpringbootServiciosUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiciosUsuariosApplication.class, args);
	}

}
