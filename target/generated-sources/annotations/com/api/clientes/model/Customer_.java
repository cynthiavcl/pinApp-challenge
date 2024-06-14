package com.api.clientes.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Customer.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Customer_ {

	
	/**
	 * @see com.api.clientes.model.Customer#surname
	 **/
	public static volatile SingularAttribute<Customer, String> surname;
	
	/**
	 * @see com.api.clientes.model.Customer#name
	 **/
	public static volatile SingularAttribute<Customer, String> name;
	
	/**
	 * @see com.api.clientes.model.Customer#birth
	 **/
	public static volatile SingularAttribute<Customer, LocalDate> birth;
	
	/**
	 * @see com.api.clientes.model.Customer#id
	 **/
	public static volatile SingularAttribute<Customer, Long> id;
	
	/**
	 * @see com.api.clientes.model.Customer
	 **/
	public static volatile EntityType<Customer> class_;
	
	/**
	 * @see com.api.clientes.model.Customer#age
	 **/
	public static volatile SingularAttribute<Customer, Integer> age;

	public static final String SURNAME = "surname";
	public static final String NAME = "name";
	public static final String BIRTH = "birth";
	public static final String ID = "id";
	public static final String AGE = "age";

}

