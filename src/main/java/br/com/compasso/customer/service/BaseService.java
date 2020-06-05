package br.com.compasso.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.compasso.customer.entity.CustomerEntity;
import br.com.compasso.customer.exception.NotFoundException;
import br.com.compasso.customer.repository.CustomerRepositoy;
import br.com.compasso.customer.util.ErrorMessage;

public abstract class BaseService {
	
	@Autowired
	public CustomerRepositoy customerRepositoy;
	
	@Autowired
	public ModelMapper modelMapper;
	
	public CustomerEntity findCustomerById(Integer id) {
		return customerRepositoy.findCustomerByid(id).orElseThrow(
			    () -> new NotFoundException(ErrorMessage.DATABASE_NOT_FOUND.getDescription()));
	}
}
