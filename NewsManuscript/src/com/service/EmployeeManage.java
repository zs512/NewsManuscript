package com.service;

import com.dao.ComDepartmentDAO;
import com.dao.ComUserDAO;
import com.domain.ComDepartment;
import com.domain.ComUser;
import com.exceptions.userManage.*;
import com.tools.MD5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class EmployeeManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");
    ComDepartmentDAO comDepartmentDAO = (ComDepartmentDAO)applicationContext.getBean("ComDepartmentDAO");

    private boolean checkLoginNameIsOnly(String userLoginName){
        List<ComUser> comUserList = comUserDAO.findByLoginName(userLoginName);
        return (comUserList == null || comUserList.size() <= 0);
    }

    private boolean checkDepartmentIsExistent(String departmentId){
        ComDepartment comDepartment = comDepartmentDAO.findById(departmentId);
        return (comDepartment != null && comDepartment.getDepartmentId() != null);
    }

    private boolean checkUserIsExistent(String userId){
        ComUser comUser = comUserDAO.findById(userId);
        return (comUser != null && comUser.getUserId() != null);
    }

    private void checkBeforeAdd(ComUser user) throws UserCheckBeforeAddException{
        try{
            /*
             * check the object user
             */
            if(user == null)
                throw new NullPointerException("user is null");

            /*
             * check login name
             */
            if(user.getLoginName() == null)
                throw new NullPointerException("user's login name is null");
            else if(!checkSizeIsLegal(user.getLoginName(), 1, 32))
                throw new UserAddLoginNameSizeException("size of user's login-name is not in (0, 32]");
            else if(checkLoginNameIsOnly(user.getLoginName()))
                throw new UserAddLoginNameNotOnlyException("login name is existent");

            /*
             * check login password
             */
            if(user.getLoginPassword() == null)
                throw new NullPointerException("user's login password is null");

            /*
             * check user's name
             */
            if(user.getName() == null)
                throw new NullPointerException("user's name is null");
            else if(!checkSizeIsLegal(user.getName(), 1, 32))
                throw new UserAddNameSizeException("user's name is not in (0, 32]");

            /*
             * check user's department
             */
            if(user.getComDepartment() == null)
                throw new NullPointerException("user's department is null");
            else if(!checkDepartmentIsExistent(user.getComDepartment().getDepartmentId()))
                throw new UserAddDepartmentNotExistentException("user's department is not existent");

        }catch(UserAddLoginNameSizeException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeAddException();
        }catch(UserAddLoginNameNotOnlyException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeAddException();
        }catch(UserAddNameSizeException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeAddException();
        }catch(UserAddDepartmentNotExistentException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComUser user) throws UserCheckBeforeDelException{

        try{
            /*
             * check object user
             */
            if(user == null || user.getUserId() == null)
                throw new NullPointerException("user is null");

            /*
             * check user is existent or not
             */
            if(!checkUserIsExistent(user.getUserId()))
                throw new UserDelUserNotExistentException("user is not existent");

        }catch(UserDelUserNotExistentException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComUser user) throws UserCheckBeforeUpdException{
        try{
            /*
             * check user
             */
            if(user == null || user.getUserId() == null)
                throw new NullPointerException("user is null");

            /*
             * check user is existent or not
             */
            if(!checkUserIsExistent(user.getUserId()))
                throw new UserUpdUserNotExistentException("user is not existent");

            ComUser comUser = comUserDAO.findById(user.getUserId());

            /*
             * check login name
             */
            if(user.getLoginName() == null)
                throw new NullPointerException("user's login name is null");
            else if(!comUser.getLoginName().equals(user.getLoginName())) {
                if(!checkSizeIsLegal(user.getLoginName(), 1, 32))
                    throw new UserUpdLoginNameSizeException("login name is not in (0, 32]");
                if(!checkLoginNameIsOnly(user.getLoginName()))
                    throw new UserUpdLoginNameRepeatException("login name is existent");
            }

            /*
             * check login password
             */
            if(user.getLoginPassword() == null)
                throw new NullPointerException("user's login password is null");

            /*
             * check name
             */
            if(user.getName() == null)
                throw new NullPointerException("user's name is null");
            else if(!checkSizeIsLegal(user.getName(), 1, 32))
                throw new UserUpdNameSizeException("size of user's name is not in (0, 32]");

            /*
             * check department
             */
            if(user.getComDepartment() == null)
                throw new NullPointerException("department is null");
            if(!checkDepartmentIsExistent(user.getComDepartment().getDepartmentId()))
                throw new UserUpdDepartmentNotExistentException("department is not existent");

        }catch(UserUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeUpdException();
        }catch(UserUpdLoginNameRepeatException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeUpdException();
        }catch(UserUpdLoginNameSizeException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeUpdException();
        }catch(UserUpdNameSizeException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeUpdException();
        }catch(UserUpdDepartmentNotExistentException e){
            System.out.println(e.toString());
            throw new UserCheckBeforeUpdException();
        }
    }

    public void addUser(ComUser user){

        try{

            checkBeforeAdd(user);

            user.setLoginPassword(MD5.get32(user.getLoginPassword()));
            user.setStatus(0);
            comUserDAO.save(user);

        }catch(UserCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delUser(ComUser user){

        try{

            checkBeforeDel(user);

            user = comUserDAO.findById(user.getUserId());
            user.setStatus(1);
            comUserDAO.attachDirty(user);

        }catch(UserCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void updUser(ComUser user){

        try{
            checkBeforeUpd(user);

            user.setStatus(0);
            comUserDAO.attachDirty(user);

        }catch(UserCheckBeforeUpdException e){
           System.out.println(e.toString());
        }
    }
}
