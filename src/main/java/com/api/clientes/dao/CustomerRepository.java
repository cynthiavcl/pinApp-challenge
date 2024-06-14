package com.api.clientes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.clientes.model.Customer;


public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
