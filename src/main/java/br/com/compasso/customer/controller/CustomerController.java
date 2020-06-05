package br.com.compasso.customer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.customer.dto.CustomerDTO;
import br.com.compasso.customer.entity.CustomerEntity;
import br.com.compasso.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping(value = { "/v1/customer" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> saveCustomer(@Valid @RequestBody CustomerDTO customerDto) {
		log.info("CustomerController - save - start. cpf: {}", customerDto.getCpf());
		CustomerEntity customerEntity = customerService.save(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerEntity);
	}
	
	@GetMapping(value = { "/v1/customer" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable Integer id) {
		log.debug("CustomerController - getCustomer - start. id: {}", id);
		CustomerEntity customerEntity = customerService.getCustomer(id);
		return ResponseEntity.ok(customerEntity);
	}
	
	@DeleteMapping(value = { "/v1/customer/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
		log.info("CustomerController - deleteCustomer - start. id: {}", id);
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = { "/v1//customer/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Integer id, @Valid @RequestBody CustomerDTO customerDto) {
		log.info("CustomerController - udpateCustomer - start. cpf: {}", customerDto.getCpf());
		CustomerEntity customerEntity = customerService.update(id, customerDto);
		return ResponseEntity.status(HttpStatus.OK).body(customerEntity);
	}
}
