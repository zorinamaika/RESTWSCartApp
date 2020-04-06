package com.gofluent.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gofluent.models.Customer;

public interface CustomerRespository  extends CrudRepository<Customer, Long> {

}
