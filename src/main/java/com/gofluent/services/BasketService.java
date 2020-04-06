package com.gofluent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.models.Basket;
import com.gofluent.repositories.BasketRepository;

@Service
public class BasketService {

	@Autowired
	private BasketRepository basketRepository;
	
	public Basket addBasket(Basket newBasket) {
		return basketRepository.save(newBasket);
	}
	
	
}
