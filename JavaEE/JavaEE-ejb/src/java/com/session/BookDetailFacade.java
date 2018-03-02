/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.BookDetail;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Harrik
 */
@Stateless
public class BookDetailFacade extends AbstractFacade<BookDetail> implements BookDetailFacadeLocal {

    @PersistenceContext(unitName = "JavaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookDetailFacade() {
        super(BookDetail.class);
    }

    @Override
    public List<BookDetail> findSpecific(String phone, Date date) {
        String sqlQuery = "SELECT b FROM BookDetail b WHERE b.cusPhone = :cusPhone AND b.bookDate = :bookDate";
        Query query = em.createQuery(sqlQuery);
        query.setParameter("cusPhone", phone);
        query.setParameter("bookDate", date);
        return query.getResultList();
    }
    
}
