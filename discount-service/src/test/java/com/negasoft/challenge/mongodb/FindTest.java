package com.negasoft.challenge.mongodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.negasoft.challenge.mongodb.Product;
import org.negasoft.challenge.mongodb.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataMongoTest
@EnableMongoRepositories("org.negasoft.challenge.mongodb")
class FindTest {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@BeforeAll
	void dataSetup() {
		  try {
	            for (Object line : FileUtils.readLines(new File("src/test/resources/mongodata/repo-products-1.dat"),Charset.defaultCharset())) {
	                mongoTemplate.save(line, "products");
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Could not import file: " + "src/test/resources/mongodata/repo-products-1.dat", e);
	        }
		
	}
	@Test
    void findByIdpTest() {
		Product val = productRepository.findByIdp(181);
		assertEquals(181,val.getIdp());
		assertEquals("brand 181",val.getBrand());
		assertEquals("description 181",val.getDescription());
		assertEquals( "www.lider.cl/catalogo/images/181.svg",val.getImage());
		assertEquals(700181,val.getPrice());
		assertEquals(0,val.getNewPrice());
		assertEquals(false,val.getIsDiscount());
		assertNotNull(productRepository.findByIdp(181));
    }
	@Test
	void findContaining() {
		List<Product> list = productRepository.findByDescriptionContainingIgnoreCaseOrBrandContainingIgnoreCase("bra","bra");
		assertEquals(3,list.size());
	}
	
}
