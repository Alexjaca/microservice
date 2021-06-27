package com.formacionbdi.springboot.app.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;
import com.formacionbdi.springboot.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ItemController {
	
	@Autowired
	@Qualifier ("serviceFeign")
	private ItemService itemService;
	

	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle (@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	//Metodo alternativo para evitar errores e4n cascada con hystrix
	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		producto.setName("Producto prueba para no tener error");
		producto.setPrice(Double.parseDouble("15000"));
		producto.setId(id);
		item.setCantidad(cantidad);
		item.setProducto(producto);
		return item;
	}

}
