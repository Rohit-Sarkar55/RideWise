package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver matchDriver(Rider rider, List<Driver> availableDrivers, VehicleType vehicleType);
}
