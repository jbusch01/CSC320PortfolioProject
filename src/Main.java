import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HomeManager manager = new HomeManager();

        while (true) {
            System.out.println("Please choose from one of the following options:");
            System.out.println("1. Add a Home");
            System.out.println("2. View Current Inventory");
            System.out.println("3. Update a Home");
            System.out.println("4. Delete a Home");
            System.out.println("5. Export Inventory List to Desktop");
            System.out.println("6. Exit Program");

            if (scnr.hasNextInt()) {
                int menuOption = scnr.nextInt();
                scnr.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scnr.nextLine();
                continue;
            }
            
            switch (menuOption) {

                case 1:
                    try {
						manager.addHome();
					} catch (Exception e) {
						System.out.println("Error adding home: " + e.getMessage());
					}
                    break;
                case 2:
					manager.listHomes();
                    break;
                case 3:
                    try {
					    manager.updateHome(scnr);
                    } catch (Exception e) {
                        System.out.println("Error updating home: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
						manager.deleteHome(scnr);
					} catch (Exception e) {
						System.out.println("Error deleting home: " + e.getMessage());
					}
                    break;
                case 5:
                    System.out.println("Please confirm you would like to export the home inventory to a file (Y/N): ");
                    String confirm = scnr.nextLine().trim().toLowerCase();

                    if (confirm.equals("y")) {
                        manager.exportFile();
                    } else {
                        System.out.println("Export canceled.");
                    }
                    break;
                case 6:
                    scnr.close();
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
                    break;

            }
        }

    }    
}
