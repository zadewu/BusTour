/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Harrik
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "JavaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findByPhone(String phone) {
        String sqlQuery = "SELECT c FROM Customer c WHERE c.cusPhone = :cusPhone ORDER BY c.cusID DESC";
        Query query = em.createQuery(sqlQuery);
        query.setParameter("cusPhone", phone);
        return query.getResultList();
    }

    @Override
    public Customer findID(String phone) {
        String sqlQuery = "SELECT c FROM Customer c WHERE c.cusPhone = :cusPhone";
        try {
            Query query = em.createQuery(sqlQuery);
            query.setParameter("cusPhone", phone);
            return (Customer) query.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }

    }
}
