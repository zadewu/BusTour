/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harrik
 */
@Entity
@Table(name = "Tour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t")
    , @NamedQuery(name = "Tour.findByTourID", query = "SELECT t FROM Tour t WHERE t.tourID = :tourID")
    , @NamedQuery(name = "Tour.findByTourFrom", query = "SELECT t FROM Tour t WHERE t.tourFrom = :tourFrom")
    , @NamedQuery(name = "Tour.findByTourTo", query = "SELECT t FROM Tour t WHERE t.tourTo = :tourTo")
    , @NamedQuery(name = "Tour.findByTourDate", query = "SELECT t FROM Tour t WHERE t.tourDate = :tourDate")
    , @NamedQuery(name = "Tour.findByTourTime", query = "SELECT t FROM Tour t WHERE t.tourTime = :tourTime")
    , @NamedQuery(name = "Tour.findBySeat", query = "SELECT t FROM Tour t WHERE t.seat = :seat")
    , @NamedQuery(name = "Tour.findByPrice", query = "SELECT t FROM Tour t WHERE t.price = :price")})
public class Tour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tourID")
    private String tourID;
    @Size(max = 50)
    @Column(name = "tourFrom")
    private String tourFrom;
    @Size(max = 50)
    @Column(name = "tourTo")
    private String tourTo;
    @Column(name = "tourDate")
    @Temporal(TemporalType.DATE)
    private Date tourDate;
    @Size(max = 50)
    @Column(name = "tourTime")
    private String tourTime;
    @Column(name = "seat")
    private Integer seat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tourID")
    private Collection<BookDetail> bookDetailCollection;

    public Tour() {
    }

    public Tour(String tourID) {
        this.tourID = tourID;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
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

    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }

    public String getTourTime() {
        return tourTime;
    }

    public void setTourTime(String tourTime) {
        this.tourTime = tourTime;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<BookDetail> getBookDetailCollection() {
        return bookDetailCollection;
    }

    public void setBookDetailCollection(Collection<BookDetail> bookDetailCollection) {
        this.bookDetailCollection = bookDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourID != null ? tourID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.tourID == null && other.tourID != null) || (this.tourID != null && !this.tourID.equals(other.tourID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Tour[ tourID=" + tourID + " ]";
    }
    
}
