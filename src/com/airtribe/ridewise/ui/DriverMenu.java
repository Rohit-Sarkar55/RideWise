package com.airtribe.ridewise.ui;

import java.util.Scanner;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.enums.VehicleType;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.service.DriverService;

public class DriverMenu implements MenuHandler {
    private DriverService driverService;

    public DriverMenu(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Driver Menu ---");
            System.out.println("1. Add Driver");
            System.out.println("2. Get Driver By Id");
            System.out.println("3. View All Available Drivers");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Driver Name: ");
                    String driverName = scanner.nextLine();

                    System.out.println("Choose Vehicle Type:");
                    for (VehicleType type : VehicleType.values()) {
                        System.out.println(type.ordinal() + 1 + ". " + type);
                    }
                    System.out.print("Enter your choice: ");
                    int vehicleChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (vehicleChoice < 1 || vehicleChoice > VehicleType.values().length) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    VehicleType vehicleType = VehicleType.values()[vehicleChoice - 1];
                    System.out.println("Choose Current Location:");
                    for (LocationEnum location : LocationEnum.values()) {
                        System.out.println(location.ordinal() + 1 + ". " + location);
                    }

                    System.out.print("Enter your choice: ");
                    int locationChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (locationChoice < 1 || locationChoice > LocationEnum.values().length) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    Driver driver = new Driver(driverName, LocationEnum.values()[locationChoice - 1],vehicleType);
                    driverService.addDriver(driver);
                    System.out.println("Driver added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Driver ID to Search: ");
                    long driverId = scanner.nextLong();
                    Driver foundDriver = driverService.getDriverById(driverId);
                    System.out.println(foundDriver);
                    break;

                case 3:
                    System.out.println("Available Drivers:");
                    driverService.getAllAvailableDrivers().forEach(System.out::println);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}