/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms.controller;

import com.leapfrog.cms.DAO.CourseDAO;
import com.leapfrog.cms.Program;
import com.leapfrog.cms.entity.Course;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Satish
 */
public class CourseControlller {

    CourseDAO courseDAO;
    Scanner input;

    public CourseControlller(CourseDAO courseDAO, Scanner input) {
        this.courseDAO = courseDAO;
        this.input = input;

    }

    public void menu() {
        System.out.println("********************");
        System.out.println("1.Add Course");
        System.out.println("2.Delete Course");
        System.out.println("3.Search by ID");
        System.out.println("4.Show All");
        System.out.println("5.Back");
        System.out.println("********************");
    }

    public void add() {
        try {
            while (true) {
                Course c = new Course();
                System.out.println("Add Course");
                System.out.println("==============================");
                System.out.println("Enter course id");
                c.setId(input.nextInt());
                System.out.println("Enter course name");
                c.setName(input.next());
                courseDAO.insert(c);
                System.out.println("==============================");
                System.out.println("Do you want to add more[Y/N]:");
                String decide = input.next();
                if (decide.equalsIgnoreCase("Y")) {
                } else if (decide.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Please type either Y or N");
                }
            }
        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }
    }

    public void delete() {
        try {
            while (true) {
                System.out.println("Add Course");
                System.out.println("==============================");
                System.out.println("Enter Id to Delete:");
                if (courseDAO.delete(input.nextInt())) {
                    System.out.println("Delete Successful");

                } else {
                    System.out.println("Record Not found");
                }
                System.out.println("==============================");
                System.out.println("Do you want to delete more[Y/N]:");
                String decide = input.next();
                if (decide.equalsIgnoreCase("Y")) {
                } else if (decide.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Please type either Y or N");
                }
            }
        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }

    }

    public void idSearch() {
        System.out.println("Search by course id");
        System.out.println("==============================");
        try {
            while (true) {
                System.out.println("Enter Id to search:");
                Course c = courseDAO.searchById(input.nextInt());
                if (c != null) {
                    System.out.println("Search complete");
                    System.out.println(c.toString());
                } else {
                    System.out.println("Record not found");
                }
                System.out.println("==============================");
                System.out.println("Do you want to search more[Y/N]:");
                String decide = input.next();
                if (decide.equalsIgnoreCase("Y")) {
                } else if (decide.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Please type either Y or N");
                }
            }
        } catch (InputMismatchException im) {
            im.getMessage();
        }

    }

    public void courseView() {
        System.out.println("Course Details");
        System.out.println("=======================================");
        courseDAO.showAll().forEach(s -> {
            System.out.println(s.toString());
        });
        System.out.println("=======================================");
    }

    public void controller() {
        try {
            while (true) {
                menu();
                System.out.println("Enter you Choice[1-5]");
                int choice = input.nextInt();
                if (choice == 1) {
                    add();
                } else if (choice == 2) {
                    delete();
                } else if (choice == 3) {
                    idSearch();
                } else if (choice == 4) {
                    courseView();
                } else if (choice == 5) {
                    System.out.println("Do you really want to move to main menu?[Y/N]");
                    String decide = input.next();
                    if (decide.equalsIgnoreCase("Y")) {
                        break;
                    } else if (decide.equalsIgnoreCase("N")) {
                        System.out.println();
                    } else {
                        System.out.println("Please type either Y or N");
                    }
                }
                else
                {
                    System.out.println("Please enter between 1 and 5");
                }
            }

        } catch (InputMismatchException im) {
            System.out.println(im.getMessage());
        }
    }
}
