/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Harrik
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "JavaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public Employee findEmployee(String username, String password) {
        String sqlQuery = "SELECT e FROM Employee e WHERE e.username = :username and e.password = :password";
        Query query = em.createQuery(sqlQuery);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (Employee) query.getSingleResult();
    }
    
}
