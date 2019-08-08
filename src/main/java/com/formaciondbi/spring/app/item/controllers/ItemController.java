package com.formaciondbi.spring.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.spring.app.item.models.Item;
import com.formaciondbi.spring.app.item.models.Services.ItemServices;

@RestController
public class ItemController {
	
		@Autowired
		private ItemServices itemServices;
	
	@GetMapping("/listar")
	public List<Item> lsitar(){
		return itemServices.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad){
		return itemServices.findById(id, cantidad);
	}
	
}
