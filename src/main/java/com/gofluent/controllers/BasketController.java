package com.gofluent.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.dto.ItemDTO;
import com.gofluent.models.Basket;
import com.gofluent.models.Item;
import com.gofluent.services.BasketService;
import com.gofluent.services.ItemService;

@CrossOrigin
@RestController
public class BasketController {
	
	@Autowired
	BasketService basketService;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/health")
    public String health() {
        return "Service is up";
    }

    @PostMapping(path="/basket",produces = "application/json")
    public int createBasket(@RequestBody Basket basket) {
    	return basketService.addBasket(basket).getId();
    }
    
    @PostMapping(path="/basket/{id}/items",produces = "application/json")
    public void addItemToBasket(@PathVariable int id,@RequestBody ItemDTO itemDTO) {
    	Item item = new Item();
    	item.setName(itemDTO.getName());
    	item.setPrice(itemDTO.getPrice());
    	item.setBasket(new Basket(id));
   
    	itemService.addItem(item);
    }
    
    @DeleteMapping(path="/basket/{id}/items/{itemId}",produces = "application/json")
    public void removeItemInBasket(@PathVariable int id, @PathVariable int itemId) {
    	Item item = new Item();
    	item.setId(itemId);
    	item.setBasket(new Basket(id));
    	
    	itemService.deleteItem(item);
    }
    
    @GetMapping(path="/basket/{id}/items",produces = "application/json")
    public List<Item> listItemsInBasket(@PathVariable int id) {
    	List<Item> items = new ArrayList<>();
    	itemService.findAll().forEach(items::add);
    	
    	return items;
    }
    
    @GetMapping(path="/basket/totalPrice",produces = "application/json")
    public double totalPriceBasket(@RequestParam int customerId) {
    	return itemService.totalSumItems(customerId);
    }

}
