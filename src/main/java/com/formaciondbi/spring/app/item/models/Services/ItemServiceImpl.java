package com.formaciondbi.spring.app.item.models.Services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formaciondbi.spring.app.item.models.Item;
import com.formaciondbi.spring.app.item.models.Producto;

@Service("itemServices")
public class ItemServiceImpl implements  ItemServices{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		//servivio-producto
		//List<Producto> productos  = Arrays.asList( clienteRest.getForObject("http://localhost:8061/listar", Producto[].class));
		List<Producto> productos  = Arrays.asList( clienteRest.getForObject("http://servivio-producto/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String,String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id", id.toString());
		
		//Producto producto = clienteRest.getForObject("http://localhost:8061/ver/{id}", Producto.class,pathVariables);
		Producto producto = clienteRest.getForObject("http://servivio-producto/ver/{id}", Producto.class,pathVariables);
		return new Item(producto,cantidad);
	}

}
