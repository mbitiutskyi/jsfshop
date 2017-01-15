package com.mbit.myshop.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.mbit.myshop.entities.Product;
import com.mbit.myshop.services.ProductService;

@Named
@RequestScoped
public class CatalogController {

	private List<Product> products;
	
	@EJB
	private ProductService productService;
	
	@PostConstruct
	private void init() {
		products = productService.getProducts();
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
