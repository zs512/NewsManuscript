package com.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

public class DepartmentManage {
	/* new department
	 * 
	 */
	public void addDepartment(ComDepartment department){
		try{
			if(department == null) throw new Exception("Department's name's length must be less than 32 chars");
			department.setStatus(0);
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
