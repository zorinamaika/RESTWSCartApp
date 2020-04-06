package com.gofluent.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gofluent.models.Basket;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {

	@SuppressWarnings("unchecked")
	Basket save(Basket entity);
}
