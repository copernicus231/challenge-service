package org.negasoft.challenge.util;

import java.util.List;

import org.negasoft.challenge.mongodb.Product;
/**
 * 
 * @author copernicus
 *
 */
public interface Utils {
	
	/**
	 * 
	 * @param products List of products that must be discount
	 * @return
	 */
	public static List<Product> ApplyDiscount(List<Product> products) {
		for(Product prod : products) {
			prod.setIsDiscount(true);
			prod.setNewPrice(prod.getPrice()/2);
		}
		return products;
	} 
	
	/**
	 * Check if a value is palindrome ignore case 
	 * @param search String to be check
	 * @return
	 */
	public static boolean isPalindrome(String search) {
	    String lowerCase = search.toLowerCase();
	    int length = lowerCase.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) {
	        char forwardChar = lowerCase.charAt(forward++);
	        char backwardChar = lowerCase.charAt(backward--);
	        if (forwardChar != backwardChar)
	            return false;
	    }
	    return true;
	}
	
}
