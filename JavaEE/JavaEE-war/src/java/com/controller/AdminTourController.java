/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Tour;
import com.session.TourFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Harrik
 */
@Named(value = "adminTourController")
@SessionScoped
public class AdminTourController implements Serializable {

    @EJB
    private TourFacadeLocal tourFacade;

    private Tour tour;
    private List<Tour> tours;
    
    @PostConstruct
    void init(){
        tour = new Tour();
        tours = new ArrayList<>();
    }
    
    public AdminTourController() {
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public TourFacadeLocal getTourFacade() {
        return tourFacade;
    }

    public void setTourFacade(TourFacadeLocal tourFacade) {
        this.tourFacade = tourFacade;
    }
    
    public List<Tour> getTours() {
        return this.tours = tourFacade.findAll();
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
    
    public void addTour(){
        tourFacade.create(tour);
//        tour = new Tour();
    }
    
    public void delete(Tour tour){
        tourFacade.remove(tour);
    }
}
