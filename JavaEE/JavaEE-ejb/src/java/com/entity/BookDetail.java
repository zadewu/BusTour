/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harrik
 */
@Entity
@Table(name = "BookDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookDetail.findAll", query = "SELECT b FROM BookDetail b")
    , @NamedQuery(name = "BookDetail.findByCusName", query = "SELECT b FROM BookDetail b WHERE b.cusName = :cusName")
    , @NamedQuery(name = "BookDetail.findByCusPhone", query = "SELECT b FROM BookDetail b WHERE b.cusPhone = :cusPhone")
    , @NamedQuery(name = "BookDetail.findByBookDate", query = "SELECT b FROM BookDetail b WHERE b.bookDate = :bookDate")
    , @NamedQuery(name = "BookDetail.findByPrice", query = "SELECT b FROM BookDetail b WHERE b.price = :price")
    , @NamedQuery(name = "BookDetail.findByBookSeat", query = "SELECT b FROM BookDetail b WHERE b.bookSeat = :bookSeat")
    , @NamedQuery(name = "BookDetail.findById", query = "SELECT b FROM BookDetail b WHERE b.id = :id")})
public class BookDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "cusName")
    private String cusName;
    @Size(max = 50)
    @Column(name = "cusPhone")
    private String cusPhone;
    @Column(name = "bookDate")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "bookSeat")
    private Integer bookSeat;
    @Column(name = "bookTime")
    private String bookTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cusID", referencedColumnName = "cusID")
    @ManyToOne(optional = false)
    private Customer cusID;
    @JoinColumn(name = "tourID", referencedColumnName = "tourID")
    @ManyToOne(optional = false)
    private Tour tourID;

    public BookDetail() {
    }

    public BookDetail(Integer id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBookSeat() {
        return bookSeat;
    }

    public void setBookSeat(Integer bookSeat) {
        this.bookSeat = bookSeat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCusID() {
        return cusID;
    }

    public void setCusID(Customer cusID) {
        this.cusID = cusID;
    }

    public Tour getTourID() {
        return tourID;
    }

    public void setTourID(Tour tourID) {
        this.tourID = tourID;
    }
    
    public String getBookTime() {
        return bookTime;
    }

    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookDetail)) {
            return false;
        }
        BookDetail other = (BookDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.BookDetail[ id=" + id + " ]";
    }

    
    
}
