package com.formaciondbi.spring.app.item.models.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formaciondbi.spring.app.item.clientes.ProductoClienteRest;
import com.formaciondbi.spring.app.item.models.Item;
@Service("servicesFeign")
@Primary
public class ItemServicesFeign implements ItemServices {
	
	@Autowired
	private ProductoClienteRest cleinteFeign;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return cleinteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(cleinteFeign.detalli(id) ,cantidad);
	}

}
