package org.negasoft.challenge.mongodb;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface ProductRepository extends Repository<Product,Integer> {

	Product findByIdp(Integer value);
	List<Product> findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase(String value,String value2);
	
}
