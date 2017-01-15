package com.mbit.myshop.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mbit.myshop.dao.ProductDao;
import com.mbit.myshop.entities.Product;

@Stateless
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext(name = "MyShop")
	private EntityManager entityManager;
	
	@Override
	public List<Product> getProducts() {
		return entityManager.createQuery("from Product", Product.class).getResultList();
	}

	@Override
	public Product getProductById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}

	@Override
	public void removeProduct(Product product) {
		entityManager.remove(product);
	}

}
