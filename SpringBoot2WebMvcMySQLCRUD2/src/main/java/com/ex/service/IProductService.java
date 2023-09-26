package com.ex.service;

import java.util.List;

import com.ex.model.Product;

public interface IProductService {
	
	public Integer saveProduct(Product p);
	
	public List<Product> getAllProduct();
	
	public void deleteProduct(Integer id);
	
	public Product getOneProduct(Integer id);
	
	public void updateProduct(Product p);

}
