package org.negasoft.challenge.mongodb;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "products")
public class Product {
	@Field(name = "id")
	private Integer idp;
	private String brand;
	private String description;
	private String image;
	private Integer price;
	@Transient
	private Integer newPrice = 0;
	@Transient
	private Boolean isDiscount = false;
}
