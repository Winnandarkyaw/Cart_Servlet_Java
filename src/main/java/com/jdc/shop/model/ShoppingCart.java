package com.jdc.shop.model;

import java.io.Serializable;
import java.util.List;

import com.jdc.shop.model.entity.Product;
import com.jdc.shop.model.entity.SaleItem;

public interface ShoppingCart extends Serializable {
	void add(Product product);

	int size();

	void clear();

	int itemCount();

	int total();

	int subTotal();
    List<SaleItem>items();
	public static ShoppingCart generate() {
		return new ShoppingCartImpl();
	}
}
