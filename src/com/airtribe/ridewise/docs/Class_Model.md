# Class Model

## Overview
This document provides an overview of the class model for the RideWise application. The system is designed to manage ride-sharing operations, including riders, drivers, rides, and fare calculations.

## Classes

### 1. Enums
- **LocationEnum**: Represents predefined locations with latitude and longitude.
- **RideStatus**: Enum for ride statuses (e.g., REQUESTED, ONGOING, COMPLETED).
- **VehicleType**: Enum for vehicle types (e.g., SEDAN, SUV, BIKE).

### 2. Exceptions
- **DriverNotFoundException**: Thrown when no driver is found.
- **NoDriverAvailableException**: Thrown when no drivers are available.
- **RideNotFoundException**: Thrown when a ride is not found.
- **RiderNotFoundException**: Thrown when a rider is not found.

### 3. Models
- **Driver**: Represents a driver with attributes like name, location, and availability.
- **Rider**: Represents a rider with attributes like name and ride history.
- **Ride**: Represents a ride with attributes like rider, driver, status, and fare.
- **FareReceipt**: Represents a receipt for a completed ride.

### 4. Services
- **DriverService**: Manages driver-related operations.
- **RiderService**: Manages rider-related operations.
- **RideMatchingService**: Handles ride matching between riders and drivers.

### 5. Strategies
- **RideMatchingStrategy**: Interface for ride matching strategies.
- **NearestDriverStrategy**: Matches riders with the nearest driver.
- **LeastActiveDriverStrategy**: Matches riders with the least active driver.
- **FareCalculationStrategy**: Interface for fare calculation strategies.
- **DefaultFareStrategy**: Default implementation for fare calculation.
- **PeakHourStrategy**: Fare calculation strategy for peak hours.

### 6. Utilities
- **CommonHelper**: Utility class for common operations.
- **IdGenerator**: Utility class for generating unique IDs.

### 7. UI
- **DriverMenu**: Handles driver-related menu operations.
- **RiderMenu**: Handles rider-related menu operations.
- **RideMenu**: Handles ride-related menu operations.
- **MenuHandler**: Centralized menu handler.

## Relationships
- **Driver** and **Rider** are associated with **Ride**.
- **Ride** uses **RideStatus** to track its state.
- **RideMatchingService** uses **RideMatchingStrategy** to find drivers.
- **FareCalculationStrategy** is used by **Ride** to calculate fares.
