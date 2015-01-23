package com.java.prizy.pricer.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.java.prizy.pricer.dao.BaseDao;
import com.java.prizy.pricer.dao.ProductDao;
import com.java.prizy.pricer.domain.Product;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveProduct(Product product) {
		StringBuilder sqlQuery = new StringBuilder(
				"INSERT INTO T_PRODUCT_DETAILS (CODE, STORE_NAME, PRICE, NOTES) values ");
		sqlQuery.append("(:code, :storeName, :price, :notes)");

		Map<String, Object> sqlParamsMap = new HashMap<String, Object>();
		sqlParamsMap.put("code", product.getBarCode());
		sqlParamsMap.put("storeName", product.getStoreName());
		sqlParamsMap.put("price", product.getPrice());
		sqlParamsMap.put("notes", product.getNotes());
		baseDao.getJdbcTemplate().update(sqlQuery.toString(), sqlParamsMap);
	}

	@Override
	public int getProduct(String barCode) {
		StringBuilder sqlQuery = new StringBuilder(
				"SELECT COUNT(*) FROM T_PRODUCT WHERE BAR_CODE = :barCode");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("barCode", barCode);

		int count = baseDao.getJdbcTemplate().queryForInt(sqlQuery.toString(),
				paramsMap);

		return count;
	}

	@Override
	public List<Product> findAllProducts() {
		StringBuilder sqlQuery = new StringBuilder(
				"SELECT NAME, BAR_CODE FROM T_PRODUCT LIMIT :start , :end");

		/*
		 * Map<String, Object> paramsMap = new HashMap<String, Object>(); if
		 * (start < 0) { start = 0; } paramsMap.put("start", start); int count =
		 * countRows(); if (end < count) { end = count; } paramsMap.put("end",
		 * end);
		 */

		List<Product> products = baseDao.getJdbcTemplate().query(
				sqlQuery.toString(), new HashMap<String, Object>(),
				new RowMapper<Product>() {
					@Override
					public Product mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Product product = new Product();
						product.setBarCode(rs.getString("BAR_CODE"));
						product.setName(rs.getString("NAME"));
						return product;
					}
				});
		return products;
	}

	/*private int countRows() {
		StringBuilder sqlQuery = new StringBuilder(
				"SELECT COUNT(*) FROM T_PRODUCT");

		int count = baseDao.getJdbcTemplate().queryForInt(sqlQuery.toString(),
				new HashMap<String, Object>());

		return count;
	}*/

	@Override
	public Product findProductDetails(String barCode) {
		StringBuilder sqlQuery = new StringBuilder(
				"SELECT p.NAME, p.BAR_CODE, p.DESCRIPTION, MAX(PRICE) as HIGHEST_PRICE, MIN(PRICE) as LOWEST_PRICE, AVG(PRICE) as AVERAGE_PRICE FROM T_PRODUCT p, T_PRODUCT_DETAILS pd ");
		sqlQuery.append("WHERE p.BAR_CODE = pd.CODE AND p.BAR_CODE = :barCode GROUP BY p.BAR_CODE");

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("barCode", barCode);

		List<Product> products = baseDao.getJdbcTemplate().query(
				sqlQuery.toString(), paramsMap, new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Product product = new Product();
						product.setBarCode(rs.getString("BAR_CODE"));
						product.setName(rs.getString("NAME"));
						product.setDescription(rs.getString("DESCRIPTION"));
						product.setHighestPrice(rs.getDouble("HIGHEST_PRICE"));
						product.setLowestPrice(rs.getDouble("LOWEST_PRICE"));
						product.setAveragePrice(rs.getDouble("AVERAGE_PRICE"));
						return product;
					}
				});

		Product product = null;
		if (products != null && !products.isEmpty()) {
			product = products.get(0);
		}
		return product;
	}
}
