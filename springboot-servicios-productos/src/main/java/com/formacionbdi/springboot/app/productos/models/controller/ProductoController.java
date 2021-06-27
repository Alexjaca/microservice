package com.formacionbdi.springboot.app.productos.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productService.findAll().stream().map(producto -> {
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));  Usando Enviroment para enviar el puerto
			producto.setPort(port); // usando restemplate con @Value para enviar el puerto
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id){
		Producto producto = productService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); Usando Enviroment para enviar el puerto
		producto.setPort(port);   // usando restemplate con @Value para enviar el puerto
		
		/*try {
			Thread.sleep(2000L);  // durmiendo el proceso 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		return producto;

	}

}
