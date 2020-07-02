package com.example.booking_system;

import com.example.booking_system.models.Booking;
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
	public void canFindAllCoursesForGivenRating() {
		List<Course> foundCourses = courseRepository.findByRating(5);
		assertEquals("Mrs Jacob's Jujitsu", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomersByCourseName() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseName("Akido With Agnes");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canFindAllCoursesByCustomerName() {
		List<Course> foundCourses = courseRepository.findByBookingsCustomerName("Rooree");
		assertEquals("Mrs Jacob's Jujitsu", foundCourses.get(0).getName());
	}

	@Test
	public void canFindAllBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findByDate("08AUG20");
		assertEquals(2, foundBookings.size());
	}

	@Test
	public void canFindCustomersByTownAndCourse() {
		List<Customer> foundCustomers = customerRepository.findByTownAndBookingsCourseName("Nice", "Akido With Agnes");
		assertEquals("Jean-Luc", foundCustomers.get(0).getName());
	}

	@Test
	public void canFindCustomersOlderThan100ByTownAndCourse() {
		List<Customer> foundCustomers = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(100, "Tokyo", "Akido With Agnes");
		assertEquals("Methuselah", foundCustomers.get(0).getName());
	}

}
