/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import com.entity.BookDetail;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Harrik
 */
@Local
public interface BookDetailFacadeLocal {

    void create(BookDetail bookDetail);

    void edit(BookDetail bookDetail);

    void remove(BookDetail bookDetail);

    BookDetail find(Object id);

    List<BookDetail> findAll();

    List<BookDetail> findRange(int[] range);

    int count();
    
    List<BookDetail> findSpecific(String phone, Date date);
}
