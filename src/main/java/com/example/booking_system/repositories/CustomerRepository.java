package com.example.booking_system.repositories;

import com.example.booking_system.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByTownAndBookingsCourseName(String town, String name);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(Integer olderThan, String town, String name);

}