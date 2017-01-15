package com.mbit.myshop.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mbit.myshop.dao.ProductDao;
import com.mbit.myshop.entities.Product;
import com.mbit.myshop.services.ProductService;

@Stateless
public class ProductServiceImpl implements ProductService {

	@EJB
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void removeProduct(Product product) {
		productDao.removeProduct(product);
	}

}
