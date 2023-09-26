package com.ex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Integer prodId;
	
	private String prodCode;
	private Double prodCost;
	private String prodType;
	private String prodNote;
	
	private Double prodDiscount;
	private Double prodGst;

}
