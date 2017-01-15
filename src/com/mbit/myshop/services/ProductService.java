package com.mbit.myshop.services;

import java.util.List;
import com.mbit.myshop.entities.Product;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int id);

    void updateProduct(Product product);

    void addProduct(Product product);

    void removeProduct(Product product);
}
