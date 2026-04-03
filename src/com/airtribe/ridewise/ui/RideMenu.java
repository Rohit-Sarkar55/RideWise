package com.airtribe.ridewise.ui;

import java.util.List;
import java.util.Scanner;
import java.util.Map;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.exceptions.NoDriverAvailableException;
import com.airtribe.ridewise.exceptions.RideNotFoundException;
import com.airtribe.ridewise.exceptions.RiderNotFoundException;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideMatchingService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.FareCalculationStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;

public class RideMenu implements MenuHandler {
    private RideMatchingService rideMatchingService;
    private RiderService riderService;

    public RideMenu(RideMatchingService rideMatchingService,RiderService riderService) {
        this.rideMatchingService = rideMatchingService;
        this.riderService = riderService;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Ride Menu ---");
            System.out.println("1. Request Ride");
            System.out.println("2. View Rides");
            System.out.println("3. Complete a Ride");
            System.out.println("4. Cancel a Ride");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Rider ID: ");
                    long riderId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    try{
                        Rider rider = riderService.getRiderById(riderId);

                        System.out.println("Choose Destination:");
                        List<LocationEnum> locationList = List.of(LocationEnum.values()).stream()
                                .filter(locationEnum -> locationEnum != rider.getCurrentLocation())
                                .toList();

                        for (int i = 0; i< locationList.size(); i++) {
                            System.out.println(i+ 1 + ". " + locationList.get(i).name());
                        }

                        System.out.print("Enter your choice: ");
                        int locationChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (locationChoice < 1 || locationChoice > locationList.size()) {
                            System.out.println("Invalid choice. Please try again.");
                            break;
                        }
                        LocationEnum destination = locationList.get(locationChoice - 1);

                        Ride ride = new Ride(rider, destination);
                        rideMatchingService.addRide(ride);
                        System.out.println("Calculating fares for each vehicle type...");
                        Map<VehicleType, Double> fares = rideMatchingService.calculateFareForAllVehicleTypes(ride);

                        System.out.println("Available options:");
                        int option = 1;
                        for (Map.Entry<VehicleType, Double> entry : fares.entrySet()) {
                            System.out.println(option + ". Vehicle Type: " + entry.getKey() + ", Fare: " + entry.getValue());
                            option++;
                        }

                        System.out.print("Choose an option: ");
                        int selectedOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (selectedOption < 1 || selectedOption > fares.size()) {
                            System.out.println("Invalid choice. Please try again.");
                            break;
                        }

                        VehicleType selectedVehicle = (VehicleType) fares.keySet().toArray()[selectedOption - 1];

                        rideMatchingService.findAndAssignDriver(ride, selectedVehicle);
                        System.out.println("Ride requested successfully with " + selectedVehicle + ".");
                        System.out.println(ride.getDriver());
                    }catch (NoDriverAvailableException | RiderNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Rides:");
                    rideMatchingService.getAllRides().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Ride ID to complete: ");
                    long rideId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    try {
                        Ride ride = rideMatchingService.completeRideWithId(rideId);
                        System.out.println("Ride completed successfully.");
                        System.out.println(ride.getFareReceipt());
                    }catch (RideNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter Ride ID to cancel: ");
                    rideId = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    try {
                        rideMatchingService.cancelRideWithId(rideId);
                        System.out.println("Ride cancelled successfully.");
                    }catch (RideNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}