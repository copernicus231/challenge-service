package org.negasoft.challenge.graphql;

import java.util.Collections;
import java.util.List;

import org.negasoft.challenge.mongodb.Product;
import org.negasoft.challenge.mongodb.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.negasoft.challenge.util.Utils;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	ProductRepository repo;
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<Product> getProducts(String search) {
		//Clean search for accept alphanumeric only
		search = search.replaceAll("[^a-zA-Z0-9\\s+]", "");
		
		//exact product Id match priority 
		if(search.matches("[0-9]+")) {
			Product prod = repo.findByIdp(Integer.parseInt(search));
			if(prod != null) {
				List<Product> result = Collections.singletonList(prod);
				return Utils.isPalindrome(search) ? Utils.ApplyDiscount(result) : result;
			}
		}
		
		//if search has not 3 characters at less 
		if (search.isEmpty() || search.length() < 3) {
			return Collections.emptyList();
		}
		
		//Query products
		List<Product> result = repo.findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase(search,search);
		return Utils.isPalindrome(search) ? Utils.ApplyDiscount(result) : result;
	}	
}


