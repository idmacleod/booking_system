package com.example.booking_system.repositories;

import com.example.booking_system.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(Integer rating);

    List<Course> findByBookingsCustomerName(String name);

}
