import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeManager {
    private Scanner scnr = new Scanner(System.in);
    ArrayList<Home> homeInventory = new ArrayList<>();

    // Method for adding a home to the ArrayList
    public void addHome() {
        System.out.println("Enter the home's model: ");
        String model = scnr.nextLine();

        System.out.println("Enter the home's street address: ");
        String address = scnr.nextLine();

        System.out.println("Enter the city: ");
        String city = scnr.nextLine();

        System.out.println("Enter the state: ");
        String state = scnr.nextLine();

        System.out.println("Enter the zip code: ");
        int zip = scnr.nextInt();

        System.out.println("Enter the square footage: ");
        int sqft = scnr.nextInt();
        scnr.nextLine();

        System.out.println("Enter the sale status: ");
        String status = scnr.nextLine();
        
        Home newHome = new Home(model, address, city, state, zip, sqft, status);

        System.out.println("Here is the information you entered:");
        System.out.println("Model: " + model);
        System.out.println("Address: " + address + ", " + city + ", " + state + " " + zip);
        System.out.println("Square Footage: " + sqft);
        System.out.println("Sale Status: " + status);

        homeInventory.add(newHome);
        System.out.println("Home added successfully!");

    }
    // Method for listing the homes
    public void listHomes() {
        if (homeInventory.isEmpty()) {
            System.out.println("No homes in inventory.");
            return;
        }

        System.out.println("Current Home Inventory:");
        for (Home home : homeInventory) {
            home.displayHome();
        }
    }

    // Method for removing a home
    public boolean deleteHome(String homeID) {
        Iterator<Home> iterator = homeInventory.iterator(); // To avoid ConcurrentModificationException

        while (iterator.hasNext()) {
            Home home = iterator.next();
            if (home.getHomeID().equals(homeID)) {
                iterator.remove();
                System.out.println("Home deleted.");
                return true;
            }
        }

        System.out.println("Home not found.");
        return false;
    }

    // Method for updating a home
    public boolean updateHome() {
        listHomes();

        System.out.println("Enter the Home's ID you would like to update from the above list: ");
        String homeID = scnr.nextLine();

        for (Home home : homeInventory) {
            if (home.getHomeID().equals(homeID)) {
                boolean updated = false;

                while (true) {
                    System.out.println("Home found! Which option would you like to update?");
                    System.out.println("Please enter only one option. If multiple options need to be updated, complete one, then select another.");

                    System.out.println("1. Model");
                    System.out.println("2. Street Address");
                    System.out.println("3. City");
                    System.out.println("4. State");
                    System.out.println("5. Zip Code");
                    System.out.println("6. Square Footage");
                    System.out.println("7. Sale Status");
                    System.out.println("8. Done Updating");
                    System.out.println("Enter choice (choose only one): ");

                    int choice = scnr.nextInt();
                    scnr.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Enter new model: ");
                            home.setHomeModel(scnr.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter new street address: ");
                            home.setStreetAddress(scnr.nextLine());
                            break;
                        case 3:
                            System.out.println("Enter new city: ");
                            home.setCity(scnr.nextLine());
                            break;
                        case 4:
                            System.out.println("Enter new state: ");
                            home.setState(scnr.nextLine());
                            break;
                        case 5:
                            System.out.println("Enter new zip code: ");
                            home.setZipCode(scnr.nextInt());
                            scnr.nextLine();
                            break;
                        case 6:
                            System.out.println("Enter new square footage: ");
                            home.setSquareFeet(scnr.nextInt());
                            scnr.nextLine();
                            break;
                        case 7:
                            System.out.println("Enter new sale status: ");
                            home.setSaleStatus(scnr.nextLine());
                            break;
                        case 8:
                            if (updated) {
                                System.out.println("Updating complete. Home successfully updated.");
                            } else {
                                System.out.println("No upadtes were made.");
                            }
                            return updated;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");

                    }
                }
            }
        }

        System.out.println("Home not found.");
        return true;

    }
}