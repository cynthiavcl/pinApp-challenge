package com.api.clientes.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.api.clientes.dao.CustomerRepository;
import com.api.clientes.exception.CustomerCreateException;
import com.api.clientes.model.Customer;
import com.api.clientes.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer crearCliente(Customer customer) {
		Customer newCustomer = new Customer();
		Period age= Period.between(customer.getBirth(), LocalDate.now());
		customer.setAge(age.getYears());
		try {
			newCustomer = customerRepository.save(customer);
			logger.info("customer with id " + newCustomer.getId() + "created");
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data integrity violation for customer");
		} catch (DataAccessException e) {
			throw new CustomerCreateException("Data Access Exception", customer.getId());
		} catch (Exception e) {
			throw new CustomerCreateException("Customer was not created with id ", customer.getId());
		}
		return newCustomer;
	}

	@Override
	public String kpideclientes() {
		List<Customer> customers = customerRepository.findAll();
		Double average = customers.stream().mapToInt(Customer::getAge).average().orElse(0.0);
		Double summation = customers.stream().mapToDouble(customer -> Math.pow(customer.getAge() - average, 2)).sum();
		Double standardDeviation = Math.sqrt(summation / customers.size());
		logger.info("kpideclientesn");
		logger.info("average : " + average.toString());
		logger.info("standardDeviation : " + standardDeviation.toString());
		String result=new String();
		result = "average: " + average +  "; standard Deviation: " +standardDeviation;		
		return result;
	}

	
	@Override
	public String listclientes() {
		List<Customer> customers = customerRepository.findAll();
		String stream= customers.stream().map(customer -> "id: " + customer.getId() + ", name: " + customer.getName() + ", surname: " + customer.getSurname()+ ", birth: " + customer.getBirth()+ ", age: " 
		+ customer.getAge() +", fecha probable de muerte: " + (customer.getBirth().plusYears(100)))
				.collect(Collectors.joining("\n"));
		logger.info("**Listado de clientes**");
		logger.info(stream);
		return stream;
	}
}
