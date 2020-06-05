package br.com.compasso.customer.service;

import org.springframework.stereotype.Service;

import br.com.compasso.customer.dto.CustomerDTO;
import br.com.compasso.customer.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService extends BaseService {

	public CustomerEntity save(CustomerDTO customerDto) {
		log.debug("CustomerService - save - params: {}", customerDto);
		CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
		customerRepositoy.save(customerEntity);
		log.info("CustomerService - save - success. cpf: {} and id: {}", customerDto.getCpf(), customerEntity.getId());
		return customerEntity;
	}

	public CustomerEntity getCustomer(Integer id) {
		log.debug("CustomerService - getCustomer - id: {}", id);
		return findCustomerById(id);
	}

	public void delete(Integer id) {
		log.info("CustomerService - delete - id: {}", id);
		CustomerEntity customerEntity = findCustomerById(id);
		customerRepositoy.delete(customerEntity);
		log.info("CustomerService - delete - success. id: {}", id, customerEntity.getName());
	}

	public CustomerEntity update(Integer id, CustomerDTO customerDto) {
		log.info("CustomerService - update - id: {}", id);
		CustomerEntity customerEntity = findCustomerById(id);
		modelMapper.map(customerDto, CustomerEntity.class);
		customerRepositoy.save(customerEntity);
		log.debug("CustomerService - update - success. id: {}", id, customerEntity.getName());
		return customerEntity;
	}
}
