package org.Service;
import org.easy_rental.model.Customer;
import org.easy_rental.model.Bike;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class rentalService {

    private List<Customer> customers;
    private List<Bike> bikes;

    public rentalService() {
        customers = new ArrayList<>();
        bikes = new ArrayList<>();
    }


    // Add a customer to the rental service
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Add a bike to the rental service
    public void addBike(Bike bike) {
        bikes.add(bike);
    }


    // Get all customers sorted by their dob in ascending order
    public List<Customer> getAllCustomersSortedByDob() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getDob))
                .collect(Collectors.toList());
    }

    // Apply a discount of 10% to customers associated for 5 or more years
    public void applyDiscountToEligibleCustomers() {
        Predicate<Customer> discountCondition = c ->
                Period.between(c.getRegistrationDate(), LocalDate.now()).getYears() >= 5;

        customers.stream()
                .filter(discountCondition)
                .forEach(c -> {

                    //#### Logic-Create logic for calculateDiscount( ) in Customer class
                    double discount = c.calculateDiscount();

                    System.out.println("Discount applied to customer " + c.getName() + ": " + discount + "%");
                });
    }



    // Get a list of regular customers from China aged above 18
    public List<Customer> getRegularCustomersFromChinaAbove18() {
        Predicate<Customer> regularCustomerCondition = c ->
                c.getCustType().equals("Regular") && c.getCountry().equals("China") && c.getAge() >18;

        return customers.stream()
                .filter(regularCustomerCondition)
                .collect(Collectors.toList());
    }

    // Get the number of customers whose age is 50+ years
    public long getCustomersAge50PlusCount() {
        //#### Logic-Create logic for getAge( ) in Customer class
        Predicate<Customer> ageCondition = c -> c.getAge() >= 50;
        //
        return customers.stream().filter(ageCondition).count();
    }





    // Get privileged customers from the USA
    public List<Customer> getPrivilegedCustomersUSA() {
        Predicate<Customer> privilegedCustomerCondition = c ->
                c.getCustType().equals("Privileged") && c.getCountry().equals("USA");

        return customers.stream()
                .filter(privilegedCustomerCondition)
                .collect(Collectors.toList());
    }

    // ... Additional methods for managing customers, bikes, and rentals ...

}
