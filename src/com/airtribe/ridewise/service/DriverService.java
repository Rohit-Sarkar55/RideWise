package com.airtribe.ridewise.service;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
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
        return allDrivers.stream()
                .filter(driver -> driver.getVehicleType().equals(vehicleType))
                .filter(Driver::isAvailable).toList();
    }

    public List<Driver> getAllAvailableDrivers(){
        return allDrivers.stream()
                .filter(Driver::isAvailable).toList();
    }
}
