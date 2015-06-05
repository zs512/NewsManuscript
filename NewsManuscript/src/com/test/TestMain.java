package com.test;

import com.dao.ComDepartmentDAO;
import com.dao.ComUserDAO;
import com.domain.ComDepartment;
import com.domain.ComUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComUserDAO comUserDAO = (ComUserDAO)aContext.getBean("ComUserDAO");
		ComUser comUser = new ComUser();
		ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)aContext.getBean("ComDepartmentDAO");
		ComDepartment comDepartment = new ComDepartment();

		comDepartment = comDepartmentDAO.findById(null);

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
