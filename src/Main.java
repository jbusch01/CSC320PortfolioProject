import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HomeManager manager = new HomeManager();

        while (true) {
            System.out.println("\nPlease choose from one of the following options:");
            System.out.println("1. Add a Home");
            System.out.println("2. View Current Inventory");
            System.out.println("3. Update a Home");
            System.out.println("4. Delete a Home");
            System.out.println("5. Export Inventory List to Desktop");
            System.out.println("6. Exit Program");

            int menuOption = 0;
            try {
                menuOption = Integer.parseInt(scnr.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option. Please enter a number between 1 and 6 (numbers only).");
                continue;
            }
          
            switch (menuOption) {

                case 1:
                    try {
						manager.addHome();
					} catch (Exception e) {
						System.out.println("\nError adding home: " + e.getMessage());
					}
                    break;
                case 2:
					manager.listHomes();
                    break;
                case 3:
                    try {
					    manager.updateHome(scnr);
                    } catch (Exception e) {
                        System.out.println("\nError updating home: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
						manager.deleteHome(scnr);
					} catch (Exception e) {
						System.out.println("\nError deleting home: " + e.getMessage());
					}
                    break;
                case 5:
                    System.out.println("\nPlease confirm you would like to export the home inventory to a file (Y/N): ");
                    String confirm = scnr.nextLine().trim().toLowerCase();

                    if (confirm.equals("y")) {
                        manager.exportFile();
                    } else {
                        System.out.println("\nExport canceled.");
                    }
                    break;
                case 6:
                    manager.closeScanner();
                    scnr.close();
                    System.out.println("\nExiting program...take care!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid option. Please enter a valid option.");
                    break;

            }
        }

    }    
}