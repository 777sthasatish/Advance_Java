/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms.controller;

import com.leapfrog.cms.DAO.EnquiryDAO;
import com.leapfrog.cms.Program;
import com.leapfrog.cms.entity.Course;
import com.leapfrog.cms.entity.Enquiry;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Satish
 */
public class EnquiryController {

    EnquiryDAO enquiryDAO;
    Scanner input;
    CourseControlller cc;

    public EnquiryController(EnquiryDAO enquiryDAO, Scanner input, CourseControlller cc) {
        this.enquiryDAO = enquiryDAO;
        this.input = input;
        this.cc = cc;

    }

    public void menu() {
        System.out.println("=========================");
        System.out.println("1. Add Enquiry");
        System.out.println("2. Show Enquiry details");
        System.out.println("3. Back");
        System.out.println("=========================");
    }

    public void addEnquiry() {
        try {
            Enquiry enquiry = new Enquiry();
            System.out.println("Add Enquiry");
            System.out.println("==============================");
            System.out.println("Please enter your id");
            enquiry.setId(input.nextInt());
            System.out.println("Please enter your first name");
            enquiry.setFirstName(input.next());
            System.out.println("Please enter your last name");
            enquiry.setLastName(input.next());
            System.out.println("Please enter your email");
            enquiry.seteMail(input.next());
            System.out.println("list of course that you can enroll in are");
            while (true) {
                cc.courseView();
                System.out.println("Enter the course id from the above course list that you want to enroll in:");
                Course c = cc.courseDAO.searchById(input.nextInt());
                if (c != null) {
                    enquiry.setCourse(c.getName());
                } else {
                    System.out.println("Record not found");
                }
                break;
            }
            enquiryDAO.insert(enquiry);
            System.out.println("==============================");
        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }
    }

    public void getAll() {
        System.out.println("Enquiry Details");
        System.out.println("=======================================");
        enquiryDAO.showAll().forEach(c -> {
            System.out.println(c.toString());
        });
        System.out.println("=======================================");
    }

    public void process() {
        try {
            while (true) {
                menu();
                System.out.println("Enter your choice");
                int choice = input.nextInt();
                if (choice == 1) {
                    addEnquiry();
                } else if (choice == 2) {
                    getAll();
                } else if (choice == 3) {
                    System.out.println("Do you really want to move to main menu?[Y/N]");
                    String decide = input.next();
                    if (decide.equalsIgnoreCase("Y")) {
                        break;
                    } else if (decide.equalsIgnoreCase("N")) {
                        System.out.println();
                    } else {
                        System.out.println("Please type either Y or N");
                    }
                } else {
                    System.out.println("Please enter between 1 and 3");
                }
            }
        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }
    }
}
