import java.util.Scanner;
import java.util.ArrayList;

public class HomeManager {
    private Scanner scnr = new Scanner(System.in);
    ArrayList<Home> homeInventory = new ArrayList<>();

    // Method for adding a home
    public void addHome() {
        // Prompt user for all home details
        // Create new Home object
        // Add it to homList

    }
    // Method for listing the homes
    public void listHome() {
        // Loop through homeInventory and display each home

    }

    // Method for removing a home
    public boolean deleteHome(String homeID) {
        return true;
        
        // Search for home by ID
        // If found, remove from list and return true
        // If not found, return false

    }

    // Method for updating a home
    public boolean updateHome(String homeID) {
        return true;
        // Search for home by ID
        // If found, prompt for new values and update fields (optional)
        // Return true/false depending on success

    }

}
