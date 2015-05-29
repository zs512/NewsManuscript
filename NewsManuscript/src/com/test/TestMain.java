package com.test;

import com.service.DepartmentManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		ComDepartment comDepartment = new ComDepartment();
		comDepartment.setDepartmentId("2ce4e7854d9d5a59014d9d5a5f6a0000");
		comDepartment.setDepartmentName("abcd");

		DepartmentManage departmentManage = new DepartmentManage();
		departmentManage.updDepartment(comDepartment);
	}

}
