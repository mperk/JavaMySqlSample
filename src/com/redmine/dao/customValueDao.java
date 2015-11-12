package com.redmine.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.redmine.model.customValue;
import com.redmine.util.redmineUtil;

public class customValueDao {
	private Connection connection;

	public customValueDao() {
		connection = redmineUtil.getConnection();
	}

	public void addCustomValue(customValue cv) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into custom_values(customized_type,customized_id,custom_field_id,value) values (?, ?, ?, ? )");
			preparedStatement.setString(1, cv.getCustomized_type());
			preparedStatement.setInt(2, cv.getCustomized_id());
			preparedStatement.setInt(3, cv.getCustom_field_id());
			preparedStatement.setString(4, cv.getValue());
			// preparedStatement.setDate(3, new
			// java.sql.Date(cv.getDob().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomValue(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from custom_values where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCustomValue(customValue cv) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update custom_values set customized_type=?, customized_id=?, custom_field_id=?, value=?"
							+ "where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, cv.getCustomized_type());
			preparedStatement.setInt(2, cv.getCustomized_id());
			preparedStatement.setInt(3, cv.getCustom_field_id());
			preparedStatement.setString(4, cv.getValue());
			preparedStatement.setInt(5, cv.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<customValue> getAllCustomValue() {
		List<customValue> cvs = new ArrayList<customValue>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from custom_values");
			while (rs.next()) {
				customValue cv = new customValue();
				cv.setId(rs.getInt("id"));
				cv.setCustomized_type(rs.getString("customized_type"));
				cv.setCustomized_id(rs.getInt("customized_id"));
				cv.setCustom_field_id(rs.getInt("custom_field_id"));
				cv.setValue(rs.getString("value"));
				cvs.add(cv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cvs;
	}

	public customValue getCustomValueById(int id) {
		customValue cv = new customValue();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from custom_values where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				cv.setId(rs.getInt("id"));
				cv.setCustomized_type(rs.getString("customized_type"));
				cv.setCustomized_id(rs.getInt("customized_id"));
				cv.setCustom_field_id(rs.getInt("custom_field_id"));
				cv.setValue(rs.getString("value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cv;
	}
}
