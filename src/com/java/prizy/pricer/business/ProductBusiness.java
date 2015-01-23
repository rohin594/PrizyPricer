package com.java.prizy.pricer.business;

import java.util.List;

import com.java.prizy.pricer.domain.Product;

public interface ProductBusiness {
	/**
	 * this method saves the product in the database if that product barcode is
	 * present in the master product table
	 * 
	 * @param product
	 */
	boolean saveProduct(Product product);

	/**
	 * this method is to get list of all the products
	 * 
	 * @return
	 */
	List<Product> getProductsList();

	Product getProductDetails(String barCode);
}
