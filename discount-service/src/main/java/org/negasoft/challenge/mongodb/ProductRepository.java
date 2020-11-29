package org.negasoft.challenge.mongodb;

import java.util.List;

import org.springframework.data.repository.Repository;

/**
 * Repository that connects our mongodb objects to app
 * @author copernicus
 *
 */
public interface ProductRepository extends Repository<Product,Integer> {

	/**
	 * query for find exact match
	 * @param value
	 * @return exact match for product or null
	 */
	Product findByIdp(Integer value);
	
	/**
	 * find all products that match in brand or description ignorecase
	 * that two paramaters allow to search by different condition on each of the values
	 * @param value description string to be search
	 * @param value2 brand string to be search
	 * @return List with all match products
	 */
	List<Product> findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase(String value,String value2);
	
}
