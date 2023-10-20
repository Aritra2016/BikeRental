package org.easy_rental.ui;

import org.Service.BikeService;
import org.easy_rental.model.Bike;

import java.util.Set;

public class UserInterface {
    public void main(String[] args) {
        displayBikeDetails();
    }

    public void displayBikeDetails() {

        BikeService bikeService = new BikeService();
        Set<Bike> bikes = bikeService.getBikeDetails();

        // Display bike details
        for (Bike bike : bikes) {
            System.out.println("Bike ID: " + bike.getBikeId());
            System.out.println("Bike Name: " + bike.getBikeName());
            System.out.println("Company Name: " + bike.getCompanyName());
            System.out.println("Serial Number: " + bike.getSerialNumber());
            System.out.println("Rent Price: " + bike.getRentPrice());
            System.out.println();
        }
    }
}
