package com.example.booking_system.components;

import com.example.booking_system.models.Booking;
import com.example.booking_system.models.Course;
import com.example.booking_system.models.Customer;
import com.example.booking_system.repositories.BookingRepository;
import com.example.booking_system.repositories.CourseRepository;
import com.example.booking_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {

        Course course1 = new Course("Mrs Jacob's Jujitsu", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Theresa's Tae Kwon Do", "Livingston", 2);
        courseRepository.save(course2);

        Course course3 = new Course("Akido With Agnes", "Glasgow", 4);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Rooree", "Edinburgh", 12);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Eugene", "Edinburgh", 28);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Seven Of Nine", "Tokyo", 40);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Jean-Luc", "Nice", 80);
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Methuselah", "Tokyo", 150);
        customerRepository.save(customer5);

        Booking booking1 = new Booking("07JUL20", course1, customer1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("31JUL20", course2, customer2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("08AUG20", course3, customer3);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("08AUG20", course3, customer4);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking("08AUG20", course3, customer5);
        bookingRepository.save(booking5);

    }

}
