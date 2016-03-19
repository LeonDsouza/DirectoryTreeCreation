/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.controller;

/**
 *
 * @author Leon
 */





import java.io.File;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.crce.interns.form.LoginForm;
import org.crce.interns.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import javax.validation.Valid;

@Controller
//@RequestMapping("loginform.html")
public class DirectoryController {

    @Autowired
    public DirectoryService directoryService;

    /*
     @RequestMapping(value = "/form", method = RequestMethod.GET)  //Put your mapping here
     public String showForm(Map model) {
     LoginForm loginForm = new LoginForm();
     model.put("loginForm", loginForm);
     return "loginform";
     }

     @RequestMapping(value = "/logged", method = RequestMethod.POST)
     public String processForm(@Valid LoginForm loginForm, BindingResult result,
     Map model) {

     /*if (result.hasErrors()) {
     return "loginform";
     }*/
    /* String role = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword());
     //System.out.println("ROLE:"+role);
     if (role.equals("Student")) {
     model.put("loginForm", loginForm);
     return "Student";
     } else if (role.equals("StudentTPC")) {
     model.put("loginForm", loginForm);
     return "StudentTPC";
     } else if (role.equals("TPO")) {
     model.put("loginForm", loginForm);
     return "TPO";
     } else {
     result.rejectValue("userName", "invaliduser");
     return "loginform";
     }
     }*/
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexLoad() {
        return "index";
    }

    @RequestMapping(value = "/createFolders", method = RequestMethod.POST)
    public String createFolders() {
        System.out.println("In class");
        String path = "C:\\Users\\Leon\\Desktop";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        List list = directoryService.createStudentFolder();
        boolean created = false;
        for (Object l1 : list) {
            System.out.println(l1);
            File files = new File(path + "\\" + Integer.toString(year) + "\\Student\\" + (l1.toString()) + "\\Resume");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        List list1 = directoryService.createFacultyFolder();
        for (Object l1 : list1) {
            System.out.println(l1);
            File files = new File(path + "\\" + Integer.toString(year) + "\\Faculty\\" + (l1.toString()));
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        if (created == true) {
            return "Result";

        } else {
            return "Error";
        }
        //DirectoryTreeCreationImpl create = new DirectoryTreeCreationImpl();
        //return create.createDirectoryTree();

        //File files = new File(path + "\\" + Integer.toString(year) + "\\D1");
        //DirectoryDAOImpl directory = new DirectoryDAOImpl();
        //Reference Codes
        /*if (!files.exists()) {
         System.out.println("In first If");
         if (files.mkdirs()) {
         System.out.println("in 2nd if");
         return "Result";
         }

         }
         return "Error";*/
        //}
    }
}
