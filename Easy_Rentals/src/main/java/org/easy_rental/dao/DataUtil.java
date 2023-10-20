package org.easy_rental.dao;

import org.easy_rental.model.Bike;
import java.util.ArrayList;
import java.util.List;
public class DataUtil {
    public static List<Bike> getAllBikes() {
        List<Bike> bikes = new ArrayList<>();

        // Add bikes to the list
        ///Create constructor in Bike class

        bikes.add(new Bike("1001", "CBR", "Honda", "Hon:1001", 500));
        bikes.add(new Bike("1002", "CBZ", "Hero", "Her:1002", 800));
        bikes.add(new Bike("1003", "Bullet", "Enfield", "Enf:1003", 900));
        bikes.add(new Bike("1004", "Karizma", "Hero", "Her:1004", 700));

        return bikes;
    }

}
