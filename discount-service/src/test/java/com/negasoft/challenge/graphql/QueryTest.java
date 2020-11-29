package com.negasoft.challenge.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.negasoft.challenge.mongodb.Product;
import org.negasoft.challenge.mongodb.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

/**
 * Test for end point disable due a problem
 * with junit5 TODO check this test
 * @author copernicus
 *
 */
@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@GraphQLTest
class QueryTest {

	 @Autowired
	 private GraphQLTestTemplate graphQLTestTemplate;
	@MockBean
	private ProductRepository mockRepository;

	  @BeforeAll
	  void init() {
	       
	        Product person = new Product();
	        person.setIdp(181);
	        person.setPrice(100);
	        person.setBrand("brand 181");
	        person.setDescription("brand 181");
	        person.setImage("www.181.com/181.svg");

	        when(mockRepository.findByIdp(181)).thenReturn(person); 

	    }
	  
	@Test
	void getProductsBaseTest() throws Exception {
		GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/query.graphql");
        assertNotNull(response);
        assertThat((response.isOk())).isTrue();
	}
}
