package com.example.booking_system;

import com.example.booking_system.models.Course;
import com.example.booking_system.models.Customer;
import com.example.booking_system.repositories.BookingRepository;
import com.example.booking_system.repositories.CourseRepository;
import com.example.booking_system.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {}

	@Test
	public void canFindAllCoursesForGivenRating(){
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals("Mrs Jacob's Jujitsu", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomersByCourseName() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Akido With Agnes");
		assertEquals(2, foundCustomers.size());
	}

}
