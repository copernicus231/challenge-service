package org.negasoft.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * App for graphql that expose on web at 
 *\/graphql end point
 * @author copernicus
 *
 */
@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {	
		SpringApplication.run(GraphqlApplication.class, args);
	}
}
