/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Tour;
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
public class TourFacade extends AbstractFacade<Tour> implements TourFacadeLocal {

    @PersistenceContext(unitName = "JavaEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TourFacade() {
        super(Tour.class);
    }
    
    @Override
    public List<Tour> findAllFrom() {
        String queryStr = "SELECT DISTINCT t.tourFrom FROM Tour t";
        Query query = em.createQuery(queryStr);
        return query.getResultList();
    }

    @Override
    public List<Tour> findAllTo() {
        String queryStr = "SELECT DISTINCT t.tourTo FROM Tour t";
        Query query = em.createQuery(queryStr);
        return query.getResultList();
    }

    @Override
    public List<Tour> findSpecificTour(String from, String to, Date date, String time) {
        String queryStr = "SELECT t FROM Tour t WHERE t.tourFrom = :tourFrom and t.tourTo = :tourTo and t.tourDate = :tourDate and t.tourTime = :tourTime";
        Query query = em.createQuery(queryStr);
        query.setParameter("tourFrom", from);
        query.setParameter("tourTo", to);
        query.setParameter("tourDate", date);
        query.setParameter("tourTime", time);
        return query.getResultList();
    }

}
