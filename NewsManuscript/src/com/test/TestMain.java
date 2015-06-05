package com.test;

import com.dao.ComDepartmentDAO;
import com.dao.ComUserDAO;
import com.domain.ComUser;
import com.manage.DepartmentManage;
import com.manage.EmployeeManage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.ComDepartment;

import java.sql.Timestamp;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComUserDAO comUserDAO = (ComUserDAO)aContext.getBean("ComUserDAO");
		ComUser comUser = new ComUser();
		ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)aContext.getBean("ComDepartmentDAO");
		ComDepartment comDepartment = new ComDepartment();
		comDepartment = comDepartmentDAO.findById("2ce4e7854d9d5a59014d9d5a5f6a0000");

		comDepartmentDAO.delete(comDepartment);

//		comUser.setLoginPassword("rqx");
//		comUser.setComDepartment(comDepartment);
//		comUser.setName("rqx");
//		comUser.setStatus(0);
//		comUser.setLoginName("rqx");
//		comUserDAO.save(comUser);
//
//		Timestamp t1 = new Timestamp(2015, 6, 4, 8, 58, 2, 1);
//		Timestamp t2 = new Timestamp(2015, 6, 4, 8, 58, 1, 1);
//		System.out.println(t1);
//		System.out.println(t1.compareTo(t2));
//		System.out.println(t2.compareTo(t1));
	}

}
