package com.mbit.myshop.services;

import com.mbit.myshop.entities.ShoppingCart;

public interface CartService {

    ShoppingCart getCart();

    void addProductById(int id);

    void clearCart();

    void removeItemByProductId(int id);

}
