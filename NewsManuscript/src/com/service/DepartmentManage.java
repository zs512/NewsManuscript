package com.service;


import com.exceptions.departmentManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

import java.util.List;

public class DepartmentManage {
	/* new department
	 * 
	 */
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)applicationContext.getBean("ComDepartmentDAO");

	private boolean checkNameIsOnly(String departmentName){
		List<ComDepartment> comDepartmentList = comDepartmentDAO.findByDepartmentName(departmentName);
		return (comDepartmentList == null || comDepartmentList.size() <= 0);
	}

	private boolean checkNameSizeIsLegal(String departmentName){
		return departmentName.length() > 0 && departmentName.length() <= 32;
	}

	private boolean checkHasSubDepartment(String departmentId){
		List<ComDepartment> comDepartmentList = comDepartmentDAO.findByParentDepartment(departmentId);
		if(comDepartmentList != null)
			if(comDepartmentList.size() > 0)
				return true;
		return false;
	}

	private boolean checkDepartmentIsExistent(String departmentId){
		ComDepartment comDepartment = comDepartmentDAO.findById(departmentId);
		return (comDepartment != null && comDepartment.getDepartmentId() != null);
	}

	public void addDepartment(ComDepartment department){

		try{
			/*
			 * check the object department  
			 */
			if(department == null)
				throw new NullPointerException("department is null");
			
			/*
			 * check department's name
			 */
			if(department.getDepartmentName() == null)
				throw new NullPointerException("department's name is null");
			else if(!checkNameSizeIsLegal(department.getDepartmentName()))
				throw new DepartmentNameSizeException("size of department's name is not in (0, 32]");
			else if(!checkNameIsOnly(department.getDepartmentName()))
				throw new DepartmentNameException("name of department is existent");

			/*
			 * check department's parentDepartment
			 */
			if(department.getParentDepartment() != null){
				if(!checkDepartmentIsExistent(department.getParentDepartment()))
					throw new NullPointerException("parent-department is not existence");
			}


			department.setStatus(0);
			
			comDepartmentDAO.save(department);
			
		}catch(DepartmentNameSizeException e){
			System.out.println(e.toString());
		}catch(DepartmentNameException e){
			System.out.println(e.toString());
		}
	}
	
	public void delDepartment(ComDepartment department){
		try{
			/*
			 *check department
			 */
			if(department == null || department.getDepartmentId() == null)
				throw new NullPointerException("department is null");

			/*
			 *check department is existent or not
			 */
			ComDepartment comDepartment = comDepartmentDAO.findById(department.getDepartmentId());
			if(comDepartment == null || comDepartment.getDepartmentId() == null)
				throw new DepartmentDelNotExistentException("department is not existent");

			/*
			 *check sub-department
			 */
			if(checkHasSubDepartment(department.getDepartmentId()))
				throw new DepartmentDelSubdepartmentExistentException("department has some sub-departments");

			department.setStatus(1);
			comDepartmentDAO.attachDirty(department);

		}catch(DepartmentDelNotExistentException e){
			System.out.println(e.toString());
		}catch(DepartmentDelSubdepartmentExistentException e){
			System.out.println(e.toString());
		}
	}

	public void updDepartment(ComDepartment department){
		try{
			/*
			 *check department
			 */
			if(department == null || department.getDepartmentId() == null)
				throw new NullPointerException("department is null");

			/*
			 *check department is existent or not
			 */
			if(!checkDepartmentIsExistent(department.getDepartmentId()))
				throw new DepartmentUpdNotExistentException("department is not existent");

			/*
			 *check department's name
			 */
			if(department.getDepartmentName() == null)
				throw new NullPointerException("department's name is null");
			else if(!checkNameSizeIsLegal(department.getDepartmentName()))
				throw new DepartmentNameSizeException("size of department's name is not in (0, 32]");
			else if(!checkNameIsOnly(department.getDepartmentName()))
				throw new DepartmentNameException("name of department is existent");

			/*
			 * check department's parentDepartment
			 */
			if(department.getParentDepartment() != null){
				if(!checkDepartmentIsExistent(department.getParentDepartment()))
					throw new NullPointerException("parent-department is not existence");
			}

			department.setStatus(0);

			comDepartmentDAO.attachDirty(department);

		}catch(DepartmentUpdNotExistentException e){
			System.out.println(e.toString());
		}catch(DepartmentNameException e){
			System.out.println(e.toString());
		}catch(DepartmentNameSizeException e){
			System.out.println(e.toString());
		}
	}
}
