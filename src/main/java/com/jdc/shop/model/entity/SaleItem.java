package com.jdc.shop.model.entity;

import java.io.Serializable;

public class SaleItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private int count;

	public Product getProduct() {
		return product;
	}

	public int getUnitPrice() {
		return product.getPrice();
	}

	public int getTotal() {
		return count * getUnitPrice();
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addOne() {
       count++;
	}
}
