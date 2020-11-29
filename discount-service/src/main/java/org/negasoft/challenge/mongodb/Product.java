package org.negasoft.challenge.mongodb;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * Domain object tha represent database
 * collection + two app fields
 * @author copernicus
 *
 */
@Data
@Document(collection = "products")
public class Product {

	/**
	 * This field has a name different on code
	 * than database one for avoid doble query due
	 * a problem with spring-data for mongodb
	 * that generates a additional query on field _id
	 * Avoid Put id field that is not mongod-db real id
	 */
	@Field(name = "id")
	private Integer idp;
	private String brand;
	private String description;
	private String image;
	private Integer price;
	
	/**
	 * field to be use for populate new price
	 */
	@Transient
	private Integer newPrice = 0;
	/**
	 * field that is going to indicate if 
	 * discount was apply
	 */
	@Transient
	private Boolean isDiscount = false;
}
