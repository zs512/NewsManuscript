package com.test;

import com.manage.DepartmentManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.ComDepartment;

import java.sql.Timestamp;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		ComDepartment comDepartment = new ComDepartment();
//		comDepartment.setDepartmentName("abcd");
//
//		DepartmentManage departmentManage = new DepartmentManage();
//		departmentManage.addDepartment(comDepartment);

		Timestamp t1 = new Timestamp(2015, 6, 4, 8, 58, 2, 1);
		Timestamp t2 = new Timestamp(2015, 6, 4, 8, 58, 1, 1);
		System.out.println(t1);
		System.out.println(t1.compareTo(t2));
		System.out.println(t2.compareTo(t1));
	}

}
