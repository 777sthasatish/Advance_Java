/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms.entity;

/**
 *
 * @author Satish
 */
public class Enquiry {
    private String firstName, lastName, eMail, course;
    private int id;

    public Enquiry() {
    }

    public Enquiry(String firstName, String lastName, String eMail, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Enquiry{" + "firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", course=" + course + ", id=" + id + '}';
    }

   
}
