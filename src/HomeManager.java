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
        System.out.println("\n***Adding a Home***\n");
        
        System.out.println("Enter the home's model: ");
        String model = scnr.nextLine();

        System.out.println("\nEnter the home's street address: ");
        String address = scnr.nextLine();

        System.out.println("\nEnter the city: ");
        String city = scnr.nextLine();

        System.out.println("\nEnter the state: ");
        String state = scnr.nextLine();

        System.out.println("\nEnter the zip code: ");
        String zip = scnr.nextLine();

        System.out.println(("\nEnter the home's price: "));
        double price = 0.0;
        boolean validPrice = false;

        while (!validPrice) {
            try {
                String input = scnr.nextLine().replace(",", "");
                price = Double.parseDouble(input);
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter the price using only numbers and decimals: ");
            }
        }

        System.out.println("\nEnter the square footage: ");
        int sqft = 0;
        boolean validSqft = false;

        while (!validSqft) {
            try {
                String input = scnr.nextLine().replace(",", "");
                sqft = Integer.parseInt(input);
                validSqft = true;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter the square footage using only numbers: ");
            }
        }

        System.out.println("\nEnter the sale status: ");
        String status = scnr.nextLine();
        
        Home newHome = new Home(model, address, city, state, zip, price, sqft, status);

        System.out.println("\nHere is the information you entered:");
        System.out.println("Model: " + model);
        System.out.println("Address: " + address + ", " + city + ", " + state + " " + zip);
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Square Footage: " + sqft);
        System.out.println("Sale Status: " + status);

        homeInventory.add(newHome);
        System.out.println("\nHome added successfully!");

    }
    // Method for listing the homes
    public void listHomes() {
        if (homeInventory.isEmpty()) {
            System.out.println("\nNo homes in inventory.");
            return;
        }

        System.out.println("\nCurrent Home Inventory:");
        for (Home home : homeInventory) {
            home.displayHome();
        }
    }

    // Method for removing a home
    public boolean deleteHome(Scanner scnr) { // This part was messy trying to figure out how to properly get Scanner working for best practice
        if (homeInventory.isEmpty()) {
            System.out.println("\nNo homes in inventory to delete.");
            return false;
        }

        listHomes(); // Show current inventory for user reference
        System.out.println("\nEnter the Home ID to delete: ");
        String homeID = scnr.nextLine();

        boolean found = false;

        Iterator<Home> iterator = homeInventory.iterator(); // To avoid ConcurrentModificationException
        while (iterator.hasNext()) {
            Home home = iterator.next();
            if (home.getHomeID().equals(homeID)) {
                iterator.remove();
                System.out.println("\nHome successfully deleted.");
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
        System.out.println("\nEnter the Home's ID you want to update from the above list: ");
        String homeID = scnr.nextLine();

        for (Home home : homeInventory) {
            if (home.getHomeID().equals(homeID)) {
                boolean updated = false;

                while (true) {
                    System.out.println("\nHome found! Which option would you like to update (enter the option number)?");

                    System.out.println("\nUpdate options:");
                    System.out.println("1. Model");
                    System.out.println("2. Street Address");
                    System.out.println("3. City");
                    System.out.println("4. State");
                    System.out.println("5. Zip Code");
                    System.out.println("6. Price");
                    System.out.println("7. Square Footage");
                    System.out.println("8. Sale Status");
                    System.out.println("9. Done Updating");
                    System.out.println("Enter the option number (choose only one): ");

                    int choice = 0;
                    try {
                        choice = Integer.parseInt(scnr.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid input. Please enter a number between 1 and 9 (numbers only).");
                        continue;
                    }
                    
                    switch (choice) {
                        case 1:
                            System.out.println("\nEnter new model: ");
                            home.setHomeModel(scnr.nextLine());
                            updated = true;
                            break;
                        case 2:
                            System.out.println("\nEnter new street address: ");
                            home.setStreetAddress(scnr.nextLine());
                            updated = true;
                            break;
                        case 3:
                            System.out.println("\nEnter new city: ");
                            home.setCity(scnr.nextLine());
                            updated = true;
                            break;
                        case 4:
                            System.out.println("\nEnter new state: ");
                            home.setState(scnr.nextLine());
                            updated = true;
                            break;
                        case 5:
                            System.out.println("\nEnter new zip code: ");
                            String newZip = scnr.nextLine();
                            home.setZipCode(newZip);
                            updated = true;
                            break;
                        case 6:
                            double newPrice = 0.0;
                            boolean validPrice = false;
                            
                            System.out.println("\nEnter new price: ");
                            while (!validPrice) {
                                try {
                                    String priceInput = scnr.nextLine().replace(",", "");
                                    newPrice = Double.parseDouble(priceInput);
                                    validPrice = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("\nInvalid input. Please enter a numeric value (numbers and decimals only).");
                                }
                            }
                            home.setHomePrice(newPrice);
                            updated = true;
                            break;
                        case 7:
                            int newSqft = 0;
                            boolean vaildSqft = false;

                            System.out.println("\nEnter new square footage: ");
                            while (!vaildSqft) {
                                try {
                                    String sqftInput = scnr.nextLine().replace(",", "");
                                    newSqft = Integer.parseInt(sqftInput);
                                    vaildSqft = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("\nInvalid input. Please enter a numeric value (numbers only).");
                                }
                            }
                            home.setSquareFeet(newSqft);
                            updated = true;    
                            break;
                        case 8:
                            System.out.println("\nEnter new sale status: ");
                            home.setSaleStatus(scnr.nextLine());
                            updated = true;
                            break;
                        case 9:
                            if (updated) {
                                System.out.println("\nUpdating complete. Home successfully updated.");
                            } else {
                                System.out.println("\nNo updates were made.");
                            }
                            return updated;
                        default:
                            System.out.println("\nInvalid option. Please choose a valid option.");

                    }
                }
            }
        }

        System.out.println("\nHome not found.");
        return false;

    }

    public void exportFile() {
        if (homeInventory.isEmpty()) {
            System.out.println("\nNo homes in inventory to export.");
            return;
        }

        BufferedWriter writer = null;
        try {
            String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
            File file = new File(desktopPath, "HomeInventory.txt");

            writer = new BufferedWriter(new FileWriter(file));

            writer.write("\nHome Inventory List\n");
            writer.write("===================\n");

            for (Home home : homeInventory) {
                writer.write("Home ID: " + home.getHomeID() + "\n");
                writer.write("Model: " + home.getHomeModel() + "\n");
                writer.write("Address: " + home.getHomeStreetAddress() + ", " + home.getHomeCity() + ", " + home.getHomeState() + " " + home.getHomeZipCode() + "\n");
                writer.write("Price: $" + String.format("%.2f", home.getHomePrice()) + "\n");
                writer.write("Square Footage: " + home.getSquareFeet() + "\n");
                writer.write("Sale Status: " + home.getSaleStatus() + "\n");
                writer.write("----------------------\n"); // To visually separate objects for readability
            }

            System.out.println("\nHome Inventory successfully exported to Desktop as 'HomeInventory.txt'.");

        } catch (IOException e) {
            System.out.println("\nError exporting file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("\nError closing file writer: " + e.getMessage());
            }
        }
    }

    public void closeScanner() {
        if (scnr != null) {
            scnr.close();
        }
    }

    // Future importFile() method here
}