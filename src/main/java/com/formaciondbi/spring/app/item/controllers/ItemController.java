package com.formaciondbi.spring.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.spring.app.item.models.Item;
import com.formaciondbi.spring.app.item.models.Services.ItemServices;
import com.formaciondbi.spring.app.item.models.Services.ItemServicesFeign;

@RestController
public class ItemController {
	
		@Autowired
		@Qualifier("itemServices")
		private ItemServices itemServices;
		@Autowired
		@Qualifier("servicesFeign")
		private ItemServicesFeign itemServicesFeign;
		
	
		@GetMapping("/listar2")
		public List<Item> lsitar2(){
			//return itemServices.findAll();
			return itemServices.findAll();
		}
	
	@GetMapping("/listar")
	public List<Item> lsitar(){
		//return itemServices.findAll();
		return itemServicesFeign.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id,@PathVariable Integer cantidad){
		//return itemServices.findById(id, cantidad);
		return itemServicesFeign.findById(id, cantidad);
	}
	
}
