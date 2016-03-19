/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leon
 */




//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.crce.interns.model.RoleMaster;
//import org.crce.interns.model.UserDetails;
import org.hibernate.Query;
import java.util.List;

@Repository("directoryDAO")
public class DirectoryDAOImpl implements DirectoryDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }
       /*
	public String checkLogin(String userName, String userPassword) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		String roleName="";
		//Query using Hibernate Query Language
		String SQL_QUERY ="from RoleMaster as r where r.roleId=(select roleId from UserDetails as u where u.userName=? and u.userPassword=?)";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,userName);
		query.setParameter(1,userPassword);
		List list = query.list();
		if  ( !(list.isEmpty())){
			RoleMaster r=(RoleMaster)list.get(0);
			roleName=r.getRoleName();
			System.out.println("Role:"+roleName);
		}
		session.close();

		return roleName;
	}
        */
        
       
    @Override
       public List createStudentFolder()
       {
           System.out.println("In createstudentfolder");
		Session session = sessionFactory.openSession();
		
		//Query using Hibernate Query Language
		String SQL_QUERY ="select userName from UserDetails where roleId like '1'";
		Query query = session.createQuery(SQL_QUERY);
		
		
		List list = query.list();
                for(Object l1 : list)
                {
                    System.out.println(l1);
                }
		if  ( !(list.isEmpty())){
			
			System.out.println("List has something");
		}
		session.close();

		return list;
       }
       
       @Override
       public List createFacultyFolder()
       {
           System.out.println("In createstudentfolder");
		Session session = sessionFactory.openSession();
		
		//Query using Hibernate Query Language
		String SQL_QUERY ="select userName from UserDetails where roleId like '2'";
		Query query = session.createQuery(SQL_QUERY);
		
		
		List list = query.list();
                for(Object l1 : list)
                {
                    System.out.println(l1);
                }
		if  ( !(list.isEmpty())){
			
			System.out.println("List has something");
		}
		session.close();

		return list;
       }

  }