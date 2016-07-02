package com.leapfrog.cms.DAO.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.leapfrog.cms.DAO.EnquiryDAO;
import com.leapfrog.cms.entity.Enquiry;
import java.util.ArrayList;
import java.util.List;


public class EnquiryDAOImpl implements EnquiryDAO {
    List<Enquiry> enquiryList;

    public EnquiryDAOImpl() {
        enquiryList=new ArrayList<>();
    }
    

    @Override
    public void insert(Enquiry enquiry) {
        enquiryList.add(enquiry);
    }

    @Override
    public List<Enquiry> showAll() {
        return enquiryList;
    }
    
}
