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
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Harrik
 */
@Named(value = "tourController")
@SessionScoped
public class TourController implements Serializable {

    private Tour tour;
    private List<Tour> allFrom;
    private List<Tour> allTo;
    private List<Tour> detailTour;
    
    private String tourFrom;
    private String tourTo;
    private Date tourDate;
    
    
    @EJB
    private TourFacadeLocal tourFacade;

    @PostConstruct
    public void init(){
        tour = new Tour();
        allFrom = tourFacade.findAllFrom();
        allTo = tourFacade.findAllTo();
        
    }
    
    
    public TourController() {
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<Tour> getAllFrom() {
        return allFrom;
    }

    public void setAllFrom(List<Tour> allFrom) {
        this.allFrom = allFrom;
    }

    public TourFacadeLocal getTourFacade() {
        return tourFacade;
    }

    public void setTourFacade(TourFacadeLocal tourFacade) {
        this.tourFacade = tourFacade;
    }

    public List<Tour> showAll(){
        return tourFacade.findAll();
    }

    public List<Tour> getAllTo() {
        return allTo;
    }

    public void setAllTo(List<Tour> allTo) {
        this.allTo = allTo;
    }
    
    public String getTourFrom() {
        return tourFrom;
    }

    public void setTourFrom(String tourFrom) {
        this.tourFrom = tourFrom;
    }

    public String getTourTo() {
        return tourTo;
    }

    public void setTourTo(String tourTo) {
        this.tourTo = tourTo;
    }
    
    public String nextPage(){
        
        return "test-result.xhtml";
    }
    
    public String searchTour(){
        return "allTour.xhtml";
    }
    
    public String confirmTour(){
        return "confirmBooking.xhtml";
    }
    
    public List<Tour> getDetailTour() {
        return detailTour;
    }

    public void setDetailTour(List<Tour> detailTour) {
        this.detailTour = detailTour;
    }
    
   
    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }
    
    public List<Tour> findSpecific(){
        return tourFacade.findSpecificTour(tour.getTourFrom(), tour.getTourTo(), tour.getTourDate(), tour.getTourTime());
    }
    
    public String nextPagewithID(String id){
        return "test-result.xhtml";
    }
}
