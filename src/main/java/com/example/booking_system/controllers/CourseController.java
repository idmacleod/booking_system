package com.example.booking_system.controllers;

import com.example.booking_system.models.Course;
import com.example.booking_system.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;


    @GetMapping
    public ResponseEntity<List<Course>> getCoursesFilterRatingCustomer(
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customer") String customerName)
    {
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (customerName != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }


}
