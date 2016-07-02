/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.cms.DAO.impl;

import com.leapfrog.cms.DAO.CourseDAO;
import com.leapfrog.cms.entity.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Satish
 */
public class CourseDAOImpl implements CourseDAO {

    private final List<Course> courseList;

    public CourseDAOImpl() {
        courseList = new ArrayList<>();
    }

    @Override
    public void insert(Course c) {
        courseList.add(c);
    }

    @Override
    public boolean delete(int id) {
        boolean hasDelete=false;
        for (Course c : courseList) {
            if (c.getId() == id) {
                courseList.remove(c);
                hasDelete=true;
                break;
            }
        }
        return hasDelete;
    }

    @Override
    public Course searchById(int id) {

        for (Course c : courseList) {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> showAll() {
        return courseList;
    }

}
