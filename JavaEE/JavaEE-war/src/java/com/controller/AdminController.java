/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.utils.SessionUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Harrik
 */
@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable {

    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
    }
    
    public String goToTour(){
        return "tour";
    }
    
    public String logout(){
        HttpSession session = SessionUtil.getSession();
        session.setAttribute("employee", null);
        return "login";
    }
    
    public boolean isLogged(){
        HttpSession session = SessionUtil.getSession();
        return session.getAttribute("employee") != null;
    }
    
}
