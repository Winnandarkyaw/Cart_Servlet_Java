package com.jdc.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.jdc.shop.model.entity.Product;
import com.jdc.shop.model.entity.SaleItem;

class ShoppingCartImpl implements ShoppingCart {

	private static final long serialVersionUID = 1L;
	private List<SaleItem> items;

	public ShoppingCartImpl() {
		items = new ArrayList<SaleItem>();
	}

	@Override
	public void add(Product product) {
		var item = findItemByProduct(product);
		if (null == item) {
			item = new SaleItem();
			item.setProduct(product);
			items.add(item);
		}
		item.addOne();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		items.clear();
	}

	@Override
	public int subTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int itemCount() {
		int count = 0;
		for (SaleItem item : items) {
			count += item.getCount();
		}
		return count;
	}

	@Override
	public int total() {
		int total = 0;
		for (SaleItem item : items) {
			total += item.getTotal();
		}
		return total;
	}

	private SaleItem findItemByProduct(Product product) {
		for (SaleItem item : items) {
			if (item.getProduct().getId() == product.getId()) {
				return item;
			}
		}
		return null;
	}
}
