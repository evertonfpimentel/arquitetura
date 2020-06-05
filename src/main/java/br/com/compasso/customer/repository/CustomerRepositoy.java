package br.com.compasso.customer.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepositoy extends PagingAndSortingRepository<CustomerEntity, Integer>  {
	
	Optional<CustomerEntity> findCustomerByid(Integer id);
	
	Page<CustomerEntity> findAll(Pageable pageable);
}
