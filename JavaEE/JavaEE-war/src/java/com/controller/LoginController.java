/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Employee;
import com.session.EmployeeFacadeLocal;
import com.utils.SessionUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Harrik
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    private Employee emp = new Employee();
    
    public LoginController() {
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public EmployeeFacadeLocal getEmployeeFacade() {
        return employeeFacade;
    }

    public void setEmployeeFacade(EmployeeFacadeLocal employeeFacade) {
        this.employeeFacade = employeeFacade;
    }
    
    public String login(){
        emp = employeeFacade.findEmployee(emp.getUsername(), emp.getPassword());
        if (emp == null) {
            emp = new Employee();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Employee does not exist!",
                            "Login Error!"));
            return "login";
        } else {
            HttpSession session = SessionUtil.getSession();
            session.setAttribute("employee", emp);
            String role = emp.getRole();
            if(role.equalsIgnoreCase("admin")) return "admin";
            else return "index";
        }
    }
    
}
