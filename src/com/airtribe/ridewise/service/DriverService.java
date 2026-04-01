package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.exceptions.DriverNotFoundException;
import com.airtribe.ridewise.exceptions.NoDriverAvailableException;
import com.airtribe.ridewise.exceptions.RiderNotFoundException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    
    protected List<Driver> allDrivers = new ArrayList<>();

    public void addDriver(Driver driver){
        this.allDrivers.add(driver);
    }

  
    public List<Driver> getAllDrivers() {
        return allDrivers;
    }

    public List<Driver> getAllAvailableDriversBasedOnType(VehicleType vehicleType){
        List<Driver> list =  allDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
        if(list.isEmpty()){
            throw new NoDriverAvailableException("No Driver available");
        }
        return list;
    }

    public List<Driver> getAllAvailableDrivers(){
        List<Driver> list =  allDrivers.stream()
                .filter(Driver::isAvailable).toList();
        if(list.isEmpty()){
            throw new NoDriverAvailableException("No Driver available");
        }
        return list;
    }

    public Driver getDriverById(long driverId){
        Driver result = allDrivers.stream()
                .filter(driver -> driver.getId() == driverId)
                .findFirst()
                .orElse(null);
        if(null == result){
            throw new DriverNotFoundException("Driver not found with the id: "+driverId);
        }
        return result;
    }
}
