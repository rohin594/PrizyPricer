package com.java.prizy.pricer.business.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.prizy.pricer.business.ProductBusiness;
import com.java.prizy.pricer.dao.ProductDao;
import com.java.prizy.pricer.domain.Product;

public class ProductBusinessImpl implements ProductBusiness {

	private ProductDao productDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public boolean saveProduct(Product product) {
		boolean update = false;
		int count = productDao.getProduct(product.getBarCode());
		if (count > 0) {
			update = true;
			productDao.saveProduct(product);
		}
		return update;
	}

	@Override
	public List<Product> getProductsList() {
		List<Product> products = productDao.findAllProducts();
		return products;
	}

	@Override
	public Product getProductDetails(String barCode) {
		Product product = productDao.findProductDetails(barCode);
		return product;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
