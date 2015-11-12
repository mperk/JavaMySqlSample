package com.redmine;

import java.sql.SQLException;

import com.redmine.dao.customValueDao;
import com.redmine.model.customValue;
import com.redmine.util.redmineUtil;

public class MysqlApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customValueDao cvDao = new customValueDao();
		
		
		//Add new a custom value
//		customValue cv = new customValue();
//		cv.setCustomized_type("Contact");
//		cv.setCustomized_id(374);
//		cv.setCustom_field_id(166);
//		cv.setValue("Fýrat");
//		cvDao.addCustomValue(cv);
		
		
		//Update custom value
//		customValue cv = cvDao.getCustomValueById(1919788);
//		cv.setValue("Fýrat Ýlkokul");
//		cv.setId(1919788);
//		cvDao.updateCustomValue(cv);
		
		
		//Delete custom value
//		cvDao.deleteCustomValue(1919788);
		
		
		// Get custom value by id
		System.out.println(cvDao.getCustomValueById(11854));
		
		
		// get all custom values
//		for(customValue iter : cvDao.getAllCustomValue()){
//			System.out.println(iter);
//		}
		System.out.println("Success");
		
		try {
			redmineUtil.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
