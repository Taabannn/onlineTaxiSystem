package ir.maktab58.onlinetaxisys.view;

import ir.maktab58.onlinetaxisys.exceptions.OnlineTaxiSysEx;
import ir.maktab58.onlinetaxisys.models.Admin;
import ir.maktab58.onlinetaxisys.models.Driver;
import ir.maktab58.onlinetaxisys.models.Passenger;
import ir.maktab58.onlinetaxisys.service.OnlineTaxiService;

import java.util.List;
import java.util.Scanner;

/**
 * @author Taban Soleymani
 */
public class OnlineTaxiSys {
    private final Scanner scanner = new Scanner(System.in);
    private final OnlineTaxiService onlineTaxiService = new OnlineTaxiService();

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    **********Welcome**********
                    1) Add a group of drivers
                    2) Add a group of passengers
                    3) Driver signup or login
                    4) Passenger signup or login
                    5) Show Ongoing Travels
                    6) Show a list of drivers
                    7) Show a list of passengers
                    8) Exit""");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addAGroupOfDrivers();
                    case "2" -> addAGroupOfPassengers();
                    case "3" -> driverSignupOrLogin();
                    case "4" -> passengerSignupOrLogin();
                    case "5" -> showOngoingTravels();
                    case "6" -> showAllDriversInformation();
                    case "7" -> showAllPassengersInformation();
                    case "8" -> exit = true;
                    default -> throw OnlineTaxiSysEx.builder()
                            .message("Your choice must be between 1 to 8.")
                            .errorCode(400).build();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showAllPassengersInformation() {
        System.out.println("Only admin can see passengersInfo list");
        isUserAllowed();
        List<Passenger> passengerList = onlineTaxiService.getAllPassengers();
        if (passengerList.size() == 0) {
            System.out.println("There is no passenger to show...");
            return;
        }
        passengerList.forEach(System.out::println);
    }

    private void showAllDriversInformation() {
        System.out.println("Only admin can see driversInfo list");
        isUserAllowed();
        List<Driver> driverList = onlineTaxiService.getAllDrivers();
        if (driverList.size() == 0) {
            System.out.println("There is no driver to show...");
            return;
        }
        driverList.forEach(System.out::println);
    }

    private void showOngoingTravels() {

    }

    private void passengerSignupOrLogin() {

    }

    private void driverSignupOrLogin() {

    }

    private void addAGroupOfPassengers() {
        isUserAllowed();
        System.out.println("How many Passengers would you like to add?");
        int numOfPassengers = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numOfPassengers; i++) {

        }
    }

    private void addAGroupOfDrivers() {
        isUserAllowed();
        System.out.println("How many Drivers would you like to add?");
        int numOfDivers = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numOfDivers; i++) {

        }
    }

    private void addANewPassenger() {

    }

    private void addNewDriver() {

    }

    private void isUserAllowed() {
        System.out.println("Please enter your username and password.");
        String[] tokens = scanner.nextLine().trim().split(" ");
        String username = tokens[0];
        String password = tokens[1];
        boolean isAllowed = Admin.getInstance().isUserAdmin(username, password);
        if (!isAllowed)
            throw OnlineTaxiSysEx.builder()
                    .message("Wrong user or pass for admin\n" +
                            "You're not allowed to add passengers or drivers.")
                            .errorCode(400).build();
    }
}
