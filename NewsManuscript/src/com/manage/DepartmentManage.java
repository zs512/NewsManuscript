package com.manage;


import com.exceptions.departmentManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ComDepartmentDAO;
import com.domain.ComDepartment;

import java.util.List;

public class DepartmentManage extends Manage{

	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)applicationContext.getBean("ComDepartmentDAO");

	private boolean checkNameIsExistent(String departmentName){
		List<ComDepartment> comDepartmentList = comDepartmentDAO.findByDepartmentName(departmentName);
		return (comDepartmentList != null && comDepartmentList.size() > 0);
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

	private void checkBeforeAdd(ComDepartment department) throws DepartmentCheckBeforeAddException{

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
			else if(!checkSizeIsLegal(department.getDepartmentName(), 1, 32))
				throw new DepartmentNameSizeException("size of department's name is not in (0, 32]");
			else if(checkNameIsExistent(department.getDepartmentName()))
				throw new DepartmentNameException("name of department is existent");

			/*
			 * check department's parentDepartment
			 */
			if(department.getParentDepartment() != null){
				if(!checkDepartmentIsExistent(department.getParentDepartment()))
					throw new NullPointerException("parent-department is not existence");
			}

		}catch(DepartmentNameSizeException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeAddException();
		}catch(DepartmentNameException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeAddException();
		}

	}

	private void checkBeforeDel(ComDepartment department) throws DepartmentCheckBeforeDelException{
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
				throw new DepartmentDelNotExistentException("department is not existent");

			/*
			 *check sub-department
			 */
			if(checkHasSubDepartment(department.getDepartmentId()))
				throw new DepartmentDelSubdepartmentExistentException("department has some sub-departments");

		}catch(DepartmentDelNotExistentException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeDelException();
		}catch(DepartmentDelSubdepartmentExistentException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeDelException();
		}
	}

	private void checkBeforeUpd(ComDepartment department) throws DepartmentCheckBeforeUpdException{
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

			ComDepartment comDepartment = comDepartmentDAO.findById(department.getDepartmentId());

			/*
			 *check department's name
			 */
			if(department.getDepartmentName() == null)
				throw new NullPointerException("department's name is null");
			else{
				if(!comDepartment.getDepartmentName().equals(department.getDepartmentName())){
					if(!checkSizeIsLegal(department.getDepartmentName(), 1, 32))
						throw new DepartmentNameSizeException("size of department's name is not in (0, 32]");
					if(checkNameIsExistent(department.getDepartmentName()))
						throw new DepartmentNameException("name of department is existent");
				}
			}

			/*
			 * check department's parentDepartment
			 */
			if(department.getParentDepartment() != null){
				if(!checkDepartmentIsExistent(department.getParentDepartment()))
					throw new NullPointerException("parent-department is not existent");
			}
		}catch(DepartmentUpdNotExistentException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeUpdException();
		}catch(DepartmentNameSizeException e){
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeUpdException();
		}catch(DepartmentNameException e) {
			System.out.println(e.toString());
			throw new DepartmentCheckBeforeUpdException();
		}
	}

	public void addDepartment(ComDepartment department){

		try {

			checkBeforeAdd(department);

			department.setStatus(0);
			comDepartmentDAO.save(department);
		}catch(DepartmentCheckBeforeAddException e){
			System.out.println(e.toString());
		}

	}

	public void delDepartment(ComDepartment department){
		try{

			checkBeforeDel(department);

			department = comDepartmentDAO.findById(department.getDepartmentId());
			department.setStatus(1);
			comDepartmentDAO.attachDirty(department);

		}catch(DepartmentCheckBeforeDelException e){
			System.out.println(e.toString());
		}
	}

	public void updDepartment(ComDepartment department){
		try{

			checkBeforeUpd(department);

			department.setStatus(0);
			comDepartmentDAO.attachDirty(department);

		}catch(DepartmentCheckBeforeUpdException e){
			System.out.println(e.toString());
		}
	}

}
