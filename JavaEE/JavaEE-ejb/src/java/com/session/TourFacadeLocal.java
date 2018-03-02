/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.Tour;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Harrik
 */
@Local
public interface TourFacadeLocal {

    void create(Tour tour);

    void edit(Tour tour);

    void remove(Tour tour);

    Tour find(Object id);

    List<Tour> findAll();

    List<Tour> findRange(int[] range);

    int count();

    List<Tour> findAllFrom();

    List<Tour> findAllTo();

    List<Tour> findSpecificTour(String from, String to, Date date, String time);
}
