package com.java.prizy.pricer.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {
	private NamedParameterJdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	public BaseDao() {
	}

	public BaseDao(DataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate classicJdbcTemplate = new JdbcTemplate(this.dataSource);
		this.jdbcTemplate = new NamedParameterJdbcTemplate(classicJdbcTemplate);
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

}
