package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exceptions.RiderNotFoundException;
import com.airtribe.ridewise.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    protected List<Rider> allRiders = new ArrayList<>();

    public void addRider(Rider rider){
        this.allRiders.add(rider);
    }


    public List<Rider> getAllRiders() {
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
