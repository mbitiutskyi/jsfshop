package com.mbit.myshop.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "cart")
@SessionScoped
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = -5170652221609133004L;

	private List<CartItem> items;
	private int numberOfItems;
	private BigDecimal totalPrice;

	public ShoppingCart() {
		items = new ArrayList<>();
		numberOfItems = 0;
		totalPrice = new BigDecimal("0.00");
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public int getTotalQuantity() {
		return numberOfItems;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.numberOfItems = totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addItem(Product product) {
		if (product == null)
			return;
		for (CartItem cartItem : items) {
			if (cartItem.getProduct().getId() == product.getId()) {
				cartItem.increaseQuantity();
				cartItem.updateTotalPrice();
				updateTotals();
				return;
			}
		}
		CartItem newItem = new CartItem(product, 1, product.getPrice());
		items.add(newItem);
		updateTotals();
	}

	public void removeItemByProductId(int id) {
		Iterator<CartItem> iterator = items.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getProduct().getId() == id) {
				iterator.remove();
				break;
			}
		}
		updateTotals();
	}

	public void clearItems() {
		this.items.clear();
		updateTotals();
	}

	private void updateTotals() {
		numberOfItems = 0;
		totalPrice = new BigDecimal("0.00");
		for (CartItem cartItem : items) {
			numberOfItems += cartItem.getQuantity();
			totalPrice = totalPrice.add(cartItem.getItemPrice());
		}
	}
}
