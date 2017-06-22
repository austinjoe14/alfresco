package com.jwt.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jwt.struts.form.LoginForm;
import com.jwt.struts.form.UserForm;

public class UserDAO {
	private Connection connection = null;
	private DataSource dataSource = null;

	public Connection DBOperation() throws SQLException {

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("database");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public boolean loginData(String userName, String passWord) throws SQLException {
		try {
			DBOperation();
			LoginForm form = new LoginForm();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from login  where username=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				form.setUserId(resultSet.getString("user_id"));
				form.setUsername(resultSet.getString("username"));
				form.setPassword(resultSet.getString("password"));
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("SQL statement is not executed!" + ex);
		}
		connection.close();
		return false;
	}

	public void insertData(String firstName, String lastName, String userName, String password, String email,
			String phone) throws Exception {
		try {

			try {
				DBOperation();
				Statement st = connection.createStatement();
				int value = st
						.executeUpdate("INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,PHONE) "
								+ "VALUES('" + firstName + "','" + lastName + "','" + userName + "','" + password
								+ "','" + email + "','" + phone + "')");
				System.out.println("1 row affected" + value);
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserForm getData(String username) throws SQLException {

		try {
			DBOperation();
			UserForm form = new UserForm();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from USER_DETAILS where username =?");
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				form.setUserId(resultSet.getString("user_id"));
				form.setUserName(resultSet.getString("username"));
				form.setPassword(resultSet.getString("password"));
				form.setFirstName(resultSet.getString("first_name"));
				form.setLastName(resultSet.getString("last_name"));
				form.setEmail(resultSet.getString("email"));
				form.setPhone(resultSet.getString("phone"));
			}
			connection.close();
			return form;
		} catch (SQLException ex) {
			connection.close();
			System.out.println("SQL statement is not executed!" + ex);
			return null;
		}

	}
}
