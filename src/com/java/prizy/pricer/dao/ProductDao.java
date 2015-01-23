package com.java.prizy.pricer.dao;

import java.util.List;

import com.java.prizy.pricer.domain.Product;

public interface ProductDao {

	void saveProduct(Product product);

	List<Product> findAllProducts();

	int getProduct(String barCode);

	Product findProductDetails(String barCode);
}
