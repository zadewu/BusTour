/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.BookDetail;
import com.entity.Customer;
import com.entity.Tour;
import com.session.BookDetailFacadeLocal;
import com.session.CustomerFacadeLocal;
import com.session.TourFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Harrik
 */
@Named(value = "bookController")
@SessionScoped
public class BookController implements Serializable {

    private Tour tour;
    private Customer cus;
    private String id;
    private int bookSeat;
    private String cusID;
    private String phoneNo;
    private Date detailDate;
    private BookDetail bookDetail;
    private List<BookDetail> bookDetails;
    
    @EJB
    private BookDetailFacadeLocal bookDetailFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

    @EJB
    private TourFacadeLocal tourFacade;

    @PostConstruct
    public void init() {
        tour = new Tour();
        cus = new Customer();
        bookDetail = new BookDetail();
        bookDetails = new ArrayList<>();
    }

    public BookController() {
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public BookDetailFacadeLocal getBookDetailFacade() {
        return bookDetailFacade;
    }

    public void setBookDetailFacade(BookDetailFacadeLocal bookDetailFacade) {
        this.bookDetailFacade = bookDetailFacade;
    }

    public CustomerFacadeLocal getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacadeLocal customerFacade) {
        this.customerFacade = customerFacade;
    }

    public TourFacadeLocal getTourFacade() {
        return tourFacade;
    }

    public void setTourFacade(TourFacadeLocal tourFacade) {
        this.tourFacade = tourFacade;
    }

//    public Tour confirmTour(){
//        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        id = parameterMap.get("id");
//        tour.setTourID(id);
//        return tourFacade.find(id);
//    }
    public String tourDetail() {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        id = parameterMap.get("id");
        tour.setTourID(id);
        tour.setTourDate(tourFacade.find(id).getTourDate());
        tour.setTourTime(tourFacade.find(id).getTourTime());
        return "confirmBooking.xhtml";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String bookTour() {
        List<Customer> cusList = customerFacade.findByPhone(cus.getCusPhone());
        if(cusList.isEmpty()){
            customerFacade.create(cus);
            Tour t = tourFacade.find(id);
            bookDetail.setCusID(cus);
            bookDetail.setTourID(t);
            bookDetail.setCusName(cus.getCusName());
            bookDetail.setCusPhone(cus.getCusPhone());
            bookDetail.setBookDate(tour.getTourDate());
            bookDetail.setBookTime(tour.getTourTime());
            bookDetail.setBookSeat(bookSeat);
            bookDetail.setPrice(bookSeat * t.getPrice());
            bookDetailFacade.create(bookDetail);
            t.setSeat(t.getSeat() - bookSeat);
            tourFacade.edit(t);
        }else{
            Customer c = customerFacade.findID(cus.getCusPhone());
            Tour t = tourFacade.find(id);
            bookDetail.setCusID(c);
            bookDetail.setTourID(t);
            bookDetail.setCusName(c.getCusName());
            bookDetail.setCusPhone(c.getCusPhone());
            bookDetail.setBookDate(tour.getTourDate());
            bookDetail.setBookTime(tour.getTourTime());
            bookDetail.setBookSeat(bookSeat);
            bookDetail.setPrice(bookSeat * t.getPrice());
            bookDetailFacade.create(bookDetail);
            t.setSeat(t.getSeat() - bookSeat);
            tourFacade.edit(t);
        }
        return "index.xhtml";

    }

    public void addTour() {
        List<Customer> cusList = customerFacade.findByPhone(cus.getCusPhone());
        if(cusList.isEmpty()){
            customerFacade.create(cus);
            Customer c = customerFacade.findID(cus.getCusPhone());
            Tour t = tourFacade.find(id);
            bookDetail.setCusID(c);
            bookDetail.setTourID(t);
            bookDetail.setCusName(c.getCusName());
            bookDetail.setCusPhone(c.getCusPhone());
            bookDetail.setBookDate(t.getTourDate());
            bookDetail.setBookTime(t.getTourTime());
            bookDetail.setBookSeat(bookSeat);
            bookDetail.setPrice(bookSeat * t.getPrice());
            bookDetailFacade.create(bookDetail);
            t.setSeat(t.getSeat() - bookSeat);
            tourFacade.edit(t);
        }else{
            Customer c = customerFacade.findID(cus.getCusPhone());
        }
    }

    public List<Customer> findCus() {
        return customerFacade.findByPhone(cus.getCusPhone());
    }

    public String nextPage() {
        return "test-result.xhtml";
    }

    public int getBookSeat() {
        return bookSeat;
    }

    public void setBookSeat(int bookSeat) {
        this.bookSeat = bookSeat;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
    
    public String reviewBooking(){
        bookDetails = bookDetailFacade.findSpecific(phoneNo, detailDate);
        return "reviewBooking.xhtml";
    }
    
    
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Date getDetailDate() {
        return detailDate;
    }

    public void setDetailDate(Date detailDate) {
        this.detailDate = detailDate;
    }

    public List<BookDetail> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(List<BookDetail> bookDetails) {
        this.bookDetails = bookDetails;
    }
}
