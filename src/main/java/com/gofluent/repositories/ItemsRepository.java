package com.gofluent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gofluent.models.Item;

public interface ItemsRepository  extends CrudRepository<Item, Long>{
	
	 void delete(Item deleted); 

	 @SuppressWarnings("unchecked")
	 Item save(Item entity);
	 
	 List<Item> findAll();
	 
	 @Query(value = "SELECT sum(i.price) FROM Item i inner join i.basket where i.basket.customer.id = ?1")
	 double sumItems(int customerId);
}
