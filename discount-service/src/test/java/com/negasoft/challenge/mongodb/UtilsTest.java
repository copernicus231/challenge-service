package com.negasoft.challenge.mongodb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.negasoft.challenge.mongodb.Product;
import org.negasoft.challenge.util.Utils;

class UtilsTest {
	List<Product> products;
	List<Integer> pricesDiscount;
	@BeforeEach
	public void initProducts() {
		products = new ArrayList<>();
		List<Integer> prices = Arrays.asList(100,201,305,410,550);
		pricesDiscount = Arrays.asList(50,100,152,205,275);
		for(int i = 0; i < 5 ; i++) {
			Product p = new Product();
			p.setBrand("xax");
			p.setDescription("bab");
			p.setIdp(1);
			p.setPrice(prices.get(i));
			products.add(p);
		}
		
		
	}
	
	@Test
	void discountApplyTest() {
		List<Product> result = Utils.applyDiscount(products);
		assertEquals(5,result.size());
		for (Product product : result) {
			assertNotNull(product.getNewPrice());
			assertTrue(product.getIsDiscount());
		}
	}
	
	@Test
	void discountResultTest() {
		List<Product> result = Utils.applyDiscount(products);
		int count = 0;
		for (Product product : result) {
			assertEquals(pricesDiscount.get(count++), product.getNewPrice());
		}
	}
	
	@Test
	void palindromeTest() {
		assertFalse(Utils.isPalindrome("abb"));
		assertTrue(Utils.isPalindrome("abba"));
		assertTrue(Utils.isPalindrome("AbBa"));
		assertTrue(Utils.isPalindrome("181"));
		assertTrue(Utils.isPalindrome("11"));
		assertFalse(Utils.isPalindrome("195"));
	}
	
	
}
