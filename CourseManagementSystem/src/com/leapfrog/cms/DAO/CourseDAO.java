/////*

package com.leapfrog.cms.DAO;

import com.leapfrog.cms.entity.Course;
import java.util.List;

/**
 *
 * @author Satish
 */
public interface CourseDAO {

    void insert(Course c);

    boolean delete(int id);

    Course searchById(int id);

    List<Course> showAll();

}
