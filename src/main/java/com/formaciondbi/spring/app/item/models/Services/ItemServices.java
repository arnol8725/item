package com.formaciondbi.spring.app.item.models.Services;

import java.util.List;

import com.formaciondbi.spring.app.item.models.Item;

public interface ItemServices {
	
	public List<Item> findAll();
	
	public Item findById(Long id,Integer cantidad);

}
