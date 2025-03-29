import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeManager {
    private Scanner scnr = new Scanner(System.in);
    ArrayList<Home> homeInventory = new ArrayList<>();

    // Method for adding a home to the ArrayList
    public void addHome() {
        System.out.println("***Adding a Home***\n");
        
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
        scnr.nextLine(); // newline buffer

        System.out.println("Enter the square footage: ");
        int sqft = scnr.nextInt();
        scnr.nextLine(); // newline buffer

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
    public boolean deleteHome(Scanner scnr) { // This part was messy trying to figure out how to properly get Scanner working for best practice
        if (homeInventory.isEmpty()) {
            System.out.println("No homes in inventory to delete.");
            return false;
        }

        listHomes(); // Show current inventory for user reference
        System.out.println("Enter the Home ID to delete: ");
        String homeID = scnr.nextLine();

        boolean found = false;

        Iterator<Home> iterator = homeInventory.iterator(); // To avoid ConcurrentModificationException
        while (iterator.hasNext()) {
            Home home = iterator.next();
            if (home.getHomeID().equals(homeID)) {
                iterator.remove();
                System.out.println("Home successfully deleted.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Home not found.");
        }

        return found;
    }

    // Method for updating a home
    public boolean updateHome(Scanner scnr) {
        if (homeInventory.isEmpty()) {
            System.out.println("No homes available to update.");
            return false;
        }

        listHomes();
        System.out.println("Enter the Home's ID you want to update from the above list: ");
        String homeID = scnr.nextLine();

        for (Home home : homeInventory) {
            if (home.getHomeID().equals(homeID)) {
                boolean updated = false;

                while (true) {
                    System.out.println("Home found! Which option would you like to update (enter the option number)?");

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
                            updated = true;
                            break;
                        case 2:
                            System.out.println("Enter new street address: ");
                            home.setStreetAddress(scnr.nextLine());
                            updated = true;
                            break;
                        case 3:
                            System.out.println("Enter new city: ");
                            home.setCity(scnr.nextLine());
                            updated = true;
                            break;
                        case 4:
                            System.out.println("Enter new state: ");
                            home.setState(scnr.nextLine());
                            updated = true;
                            break;
                        case 5:
                            System.out.println("Enter new zip code: ");
                            int newZip = scnr.nextInt();
                            scnr.nextLine(); // To consume newline
                            home.setZipCode(newZip);
                            updated = true;
                            break;
                        case 6:
                            System.out.println("Enter new square footage: ");
                            int newSqft = scnr.nextInt();
                            scnr.nextLine(); // To consume newline
                            home.setSquareFeet(newSqft);
                            updated = true;
                            break;
                        case 7:
                            System.out.println("Enter new sale status: ");
                            home.setSaleStatus(scnr.nextLine());
                            updated = true;
                            break;
                        case 8:
                            if (updated) {
                                System.out.println("Updating complete. Home successfully updated.");
                            } else {
                                System.out.println("No updates were made.");
                            }
                            return updated;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");

                    }
                }
            }
        }

        System.out.println("Home not found.");
        return false;

    }

    public void exportFile() {
        if (homeInventory.isEmpty()) {
            System.out.println("No homes in inventory to export.");
            return;
        }

        BufferedWriter writer = null;
        try {
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
            File file = new File(desktopPath, "HomeInventory.txt");

            writer = new BufferedWriter(new FileWriter(file));

            writer.write("Home Inventory List\n");
            writer.write("===================\n");

            for (Home home : homeInventory) {
                writer.write("Home ID: " + home.getHomeID() + "\n");
                writer.write("Model: " + home.getHomeModel() + "\n");
                writer.write("Address: " + home.getHomeStreetAddress() + ", " + home.getHomeCity() + ", " + home.getHomeState() + " " + home.getHomeZipCode() + "\n");
                writer.write("Square Footage: " + home.getSquareFeet() + "\n");
                writer.write("Sale Status: " + home.getSaleStatus() + "\n");
                writer.write("----------------------\n"); // To visually separate objects for readability
            }

            System.out.println("Home Inventory successfully exported to Desktop as 'HomeInventory.txt'.");

        } catch (IOException e) {
            System.out.println("Error exporting file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing file writer: " + e.getMessage());
            }
        }
    }

    public void closeScanner() {
        if (scnr != null) {
            scnr.close();
        }
    }
}