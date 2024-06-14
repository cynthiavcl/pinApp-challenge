package com.api.clientes.service;

import com.api.clientes.model.Customer;



public interface CustomerService {
	
	Customer crearCliente(Customer customer);
	
	String kpideclientes();
	
	String listclientes();
	
}
