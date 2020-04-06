package com.gofluent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.models.Item;
import com.gofluent.repositories.ItemsRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	public Item addItem(Item newItem) {
		return itemsRepository.save(newItem);
	}
	
	public void deleteItem(Item item) {
		itemsRepository.delete(item);
	}
	
	public List<Item> findAll() {
        return itemsRepository.findAll();
    }
	
	public double totalSumItems(int customerId) {
		return itemsRepository.sumItems(customerId);
	}
	
}
