package com.ex.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Product;
import com.ex.repo.ProductRepository;
import com.ex.service.IProductService;

@Service //calculation operation sorting transaction management
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	@Transactional
	public Integer saveProduct(Product p) {
		//Calculation
		var cost=p.getProdCost();
		
		var disc= cost * 12/100.0;
		var gst= cost * 8/100.0;
		
		p.setProdGst(gst);
		p.setProdDiscount(disc);
		return repo.save(p).getProdId();
	}
	
	@Override
	//@Transactional(readOnly = true)
	public List<Product> getAllProduct() {
		List<Product> list=repo.findAll();
		Collections.sort(list,
				//(o1,o2)->o2.getProdId()-o1.getProdId()); //DESC order on product Id
				//(o1,o2)->o2.getProdCode().compareTo(o1.getProdCode())); //DESC order on product Code
				(o1,o2)->o1.getProdCode().compareTo(o2.getProdCode())); //ASC order on Product Code
		return list;
	}
	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public Product getOneProduct(Integer id) {
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	@Override
	public void updateProduct(Product p) {
		//Calculation
				var cost=p.getProdCost();
				
				var disc= cost * 12/100.0;
				var gst= cost * 8/100.0;
				
				p.setProdGst(gst);
				p.setProdDiscount(disc);
		repo.save(p);
	}

}
