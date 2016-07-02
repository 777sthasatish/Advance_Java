/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms.DAO;

import com.leapfrog.cms.entity.Enquiry;
import java.util.List;

/**
 *
 * @author Satish
 */
public interface EnquiryDAO {
    void insert(Enquiry enquiry);
    List<Enquiry> showAll();
}
