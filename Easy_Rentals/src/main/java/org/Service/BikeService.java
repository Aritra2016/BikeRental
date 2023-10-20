package org.Service;

import org.easy_rental.dao.DataUtil;
import org.easy_rental.model.Bike;

import java.util.Set;

public class BikeService {

    public Set<Bike> getBikeDetails() {
        // Type casting the returned value from DataUtil.getAllBikes()
        return (Set<Bike>) (Object) DataUtil.getAllBikes();
    }
}
