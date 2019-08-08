package com.formaciondbi.spring.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formaciondbi.spring.app.item.models.Item;
import com.formaciondbi.spring.app.item.models.Producto;

@FeignClient(name="servivio-producto",url="localhost:8061")
public interface ProductoClienteRest {
	@GetMapping("/listar")
	public List<Producto> listar();
	@GetMapping("/ver/{id}")
	private Producto detalli(@PathVariable Long id)
}
