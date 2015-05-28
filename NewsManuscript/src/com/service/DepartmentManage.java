package com.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

public class DepartmentManage {
	/* new department
	 * 
	 */
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)applicationContext.getBean("ComDepartmentDAO");
	public void addDepartment(ComDepartment department){

		try{
			/*
			 * check the object department  
			 */
			if(department == null) throw new Exception("department is null");
			
			/*
			 * check department's name
			 */
			if(department.getDepartmentName() == null){ 
				throw new Exception("department's name is null");
			}else {
				if(department.getDepartmentName().length() <= 0 || department.getDepartmentName().length() > 32)
					throw new Exception("size of depatment's name is not in (0, 32]");
			}
			
			/*
			 * check department's parentDepartmen
			 */
			if(department.getParentDepartment() != null){
				ComDepartment comDepartmentParent = comDepartmentDAO.findById(department.getParentDepartment());
				if(comDepartmentParent == null){
					throw new Exception("parent department is not existence");
				}
			}
			department.setStatus(0);
			
			comDepartmentDAO.save(department);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void delDepartment(ComDepartment department){
		
			
	}
}
