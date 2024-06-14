package com.api.clientes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientes.dto.CustomerDTO;
import com.api.clientes.exception.CustomerCreateException;
import com.api.clientes.model.Customer;
import com.api.clientes.service.CustomerService;
import com.api.clientes.utils.Utils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author vocal
 *
 */

//Documentation http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping(path = "/customers")
@Tag(name = "Customer Controller")
public class CustomerController {
	
	final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@Operation(summary = "Crear clientes")
	@PostMapping(path = "/creacliente", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> creacliente(@RequestBody CustomerDTO customerDTO) {
		logger.info("Crea cliente");
		Customer customer = customerService.crearCliente(Utils.convertToEntity(customerDTO));

		if (customer == null) {
			throw new CustomerCreateException("Customer not created");
		}
		logger.info("customer created:" + "id" + customer.getId());
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Promedio edad entre los clientes, Desviacion standard entre las edades de todos los clientes")
	@GetMapping(path = "/kpideclientes", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> kpideclientes() {
		logger.info("kpideclientes");
		String result=customerService.kpideclientes();
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	//Se considera que las personas viven 100 años
	@Operation(summary = "Lista de personas con todos los datos, Fecha probable de muerte de cada una")
	@GetMapping(path = "/listclientes", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> listclientes() {
		logger.info("listclientes");
		String result=customerService.listclientes();
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
