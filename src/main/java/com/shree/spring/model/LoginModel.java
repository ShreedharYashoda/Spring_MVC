package com.shree.spring.model;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginModel {

	private JdbcTemplate jdbcTemplate;

	public LoginModel(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String validate(String uname, String pass) {
		try {
			return (String) jdbcTemplate.queryForObject(
					"select type from userdetails where username =\'" + uname + "\' and password=\'" + pass + "\'",
					String.class);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
