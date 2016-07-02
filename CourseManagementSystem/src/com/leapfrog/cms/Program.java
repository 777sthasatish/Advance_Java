/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms;

import com.leapfrog.cms.DAO.EnquiryDAO;
import com.leapfrog.cms.DAO.impl.CourseDAOImpl;
import com.leapfrog.cms.DAO.impl.EnquiryDAOImpl;
import com.leapfrog.cms.controller.CourseControlller;
import com.leapfrog.cms.controller.EnquiryController;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Satish
 */
public class Program {

    Scanner input = new Scanner(System.in);
    EnquiryDAO enquiryDAO = new EnquiryDAOImpl();
    CourseControlller cc = new CourseControlller(new CourseDAOImpl(), input);
    EnquiryController ec = new EnquiryController(enquiryDAO, input, cc);

    public static void main(String[] args) {
        Program p=new Program();
        p.decision();
    }

    public void decision() {
        try {
            while (true) {
                System.out.println("Course Management System");
                System.out.println("****************************");
                System.out.println("1. Course");
                System.out.println("2. Enquiry");
                System.out.println("3. Exit");
                System.out.println("****************************");

                System.out.println("Please choose from above list");

                switch (input.nextInt()) {
                    case 1:
                        cc.controller();
                        break;
                    case 2:
                        ec.process();
                        break;
                    case 3:
                        System.exit(0);

                }
            }

        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }
    }
}
