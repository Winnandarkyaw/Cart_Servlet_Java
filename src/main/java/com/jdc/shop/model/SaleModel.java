package com.jdc.shop.model;

import java.util.List;

import com.jdc.shop.model.entity.SaleItem;
import com.jdc.shop.model.entity.Voucher;

public interface SaleModel {
	static SaleModel model() {
		return new SaleModelImpl();
	}

	List<Voucher> getSaleHistory();

	int create(String customer, List<SaleItem> sales);

	Voucher findById(int id);

}
