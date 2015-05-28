package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService tsService = (TestService)aContext.getBean("testService");
		System.out.println(tsService.getName());
//		ComDepartment comDepartment = new ComDepartment();
//		comDepartment.setDepartmentName("abc");
//		comDepartment.setStatus(0);
//		ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)aContext.getBean("ComDepartmentDAO");
//		comDepartmentDAO.save(comDepartment);
	}

}
