package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exceptions.RiderNotFoundException;
import com.airtribe.ridewise.model.Rider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RiderService {
    protected List<Rider> allRiders = new ArrayList<>();

    public void addDriver(Rider rider){
        this.allRiders.add(rider);
    }


    public List<Rider> getAllDrivers() {
        return this.allRiders;
    }

    public Rider getRiderById(long riderId){
        Rider result = allRiders.stream()
                    .filter(rider -> rider.getId() == riderId)
                    .findFirst()
                    .orElse(null);
        if(null == result){
            throw new RiderNotFoundException("Rider not found with the id: "+riderId);
        }
        return result;
    }

}
