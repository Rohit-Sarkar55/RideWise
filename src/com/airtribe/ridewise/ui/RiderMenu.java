package com.airtribe.ridewise.ui;

import java.util.Scanner;

import com.airtribe.ridewise.enums.LocationEnum;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.service.RiderService;

public class RiderMenu implements MenuHandler {
    private RiderService riderService;
    public RiderMenu(RiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n--- Rider Menu ---");
            System.out.println("1. Add Rider");
            System.out.println("2. Get Rider By Id");
            System.out.println("3. View All Riders");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Rider Name: ");
                    String riderName = scanner.nextLine();
                    Rider rider = new Rider(riderName, LocationEnum.ELECTRONIC_CITY); // currently hardcoded
                    riderService.addRider(rider);
                    System.out.println("Rider Created successfully.");
                    break;

                case 2:
                    System.out.print("Enter Ride ID to Search: ");
                    long riderId = scanner.nextLong();
                    rider = riderService.getRiderById(riderId);
                    System.out.println(rider);
                    break;

                case 3:
                    System.out.println("Rides:");
                    riderService.getAllRiders().forEach(System.out::println);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}