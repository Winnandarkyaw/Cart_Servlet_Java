package com.jdc.shop.model;

import java.io.Serializable;

import com.jdc.shop.model.entity.Product;

public interface ShoppingCart extends Serializable {
	void add(Product product);

	int size();

	void clear();

	int itemCount();

	int total();

	int subTotal();

	public static ShoppingCart generate() {
		return new ShoppingCartImpl();
	}
}
