package com.api.clientes.utils;

import com.api.clientes.dto.CustomerDTO;
import com.api.clientes.model.Customer;

public class Utils {
	public static Customer convertToEntity(CustomerDTO customerDTO) {
		Customer customerConverted = new Customer();
		customerConverted.setAge(customerDTO.getAge());
		customerConverted.setBirth(customerDTO.getBirth());
		customerConverted.setSurname(customerDTO.getSurname());
		customerConverted.setName(customerDTO.getName());
		return customerConverted;
	}
}
