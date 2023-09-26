package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.model.Product;
import com.ex.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/register")
	public String showReg() {
		return "ProductRegister";
	}
	
	//On click submit button
	/*
	 * Read Form Data as ModelAttribute
	 * save in database using service.save(p)
	 * return message to UI (ProductRegisterPage)
	 */
	
	@PostMapping("/save")
	public String saveProd(
			@ModelAttribute Product product, Model model
			) {
		Integer id=service.saveProduct(product);
		model.addAttribute("message","SAVED WITH ID : "+id);
		return "ProductRegister";
	}
	
	@GetMapping("/all")
	public String getAll(Model model) {
		List<Product> list=service.getAllProduct();
		model.addAttribute("list",list);
		return "ProductData";
	}
	
	//Delete data by ID
	@GetMapping("/delete")
	public String remove(
			@RequestParam Integer id,
			Model model
			) {
		service.deleteProduct(id);
		//Display latest Data
		List<Product> list=service.getAllProduct();
		model.addAttribute("list",list);
		
		//Send message to UI
		model.addAttribute("message","Product '"+id+"' Deleted");
		return "ProductData"; 
		//return "redirect:all";
	}
	
	//Show edit page
	@GetMapping("/edit")
	public String showEdit(
			@RequestParam Integer id, //read input
			Model model
			) {
		//Call service to get one object
		Product product=service.getOneProduct(id);
		//Send data to Form For Edit
		model.addAttribute("product",product);
		return "ProductEdit";
	}
	
	//On click update button
	@PostMapping("/update")
	public String update(
			@ModelAttribute Product product, Model model
			) {
		service.updateProduct(product);
		//Display latest data
		List<Product> list=service.getAllProduct();
		model.addAttribute("list",list);
		
		//send message to UI
		model.addAttribute("message","Product '"+product.getProdId()+"' Update");
		
		//return "reditect:all";
		return "ProductData";
	}

}
