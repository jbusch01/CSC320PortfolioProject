// Class for handling information about a single home (object)

import java.util.Scanner;

public class Home {
    public static void home(String[] args) {
        Scanner scnr = new Scanner(System.in);
    
    String homeID;
    String homeModel;
    String homeStreetAddress;
    String homeCity;
    String homeState;
    int homeZipCode;
    
    }
    // Constructor
    public Home() {
        System.out.println("Please enter the following details:");
        System.out.println("1. Home Model: ");
        home.homeModel = scnr.next();
        System.out.println("2. Street Address: ");
        home.homeStreetAddress = scnr.next();
        System.out.println("3. City: ");
        home.homeCity = scnr.next();
        System.out.println("4. State: ");
        home.homeState = scnr.next();
        System.out.println("5. Zip Code: ");
        home.homeZipCode = scnr.nextInt();

        return homeModel, homeStreetAddress, homeCity, homeState, homeZipCode


    }
    public void displayHome(String homeID, String homeModel, String homeStreetAddress, String homeCity, String homeState, int homeZipCode) {
        // Method to print home details
        System.out.println("Please verify the information you entered. Confirm with Y for yes and N for no.");
        System.out.println("Home Information:");
        System.out.println("Home ID: " + homeID);
        System.out.println("Model: " + homeModel);
        System.out.println("Street Address: " + homeStreetAddress);
        System.out.println("City: " + homeCity);
        System.out.println("State: " + homeState);
        System.out.println("Zip Code: " + homeZipCode);
    }
}