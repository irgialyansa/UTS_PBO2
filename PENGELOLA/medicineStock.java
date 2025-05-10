import java.util.Scanner;
 // DISCLAIMER INI CODINGAN POV : PENGELOLA/ADMIN 
    // ARRAY 2 DIMENSI   
public class medicineStock {
   
  private static final String[][] medicineStock = {
      { "Obat Batuk", "10" },
      { "Obat Pilek", "10" },
      { "Obat Pusing Kepala", "10" }
  };
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int choice;
    do {
      System.out.println("\n--- Medicine Stock Management Menu ---");
      System.out.println("1. Display Medicine Stock Details");
      System.out.println("2. Update Medicine Stock");
      System.out.println("3. Reduce Medicine Stock");
      System.out.println("4. Exit");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          displayStockDetails();
          break;
        case 2:
          updateStock();
          break;
        case 3:
          reduceStock();
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 4.");
      }
    } while (choice != 4);
  }

  private static void displayStockDetails() {
    System.out.println("\nMedicine Stock Details:");
    for (String[] medicine : medicineStock) {
      System.out.println("Medicine: " + medicine[0] + ", Stock: " + medicine[1]);
    }
  }

  private static void updateStock() {
    System.out.print("Enter the name of the medicine to update stock: (Obat....)");
    String name = scanner.nextLine();
    boolean found = false;
    for (String[] medicine : medicineStock) {
      if (medicine[0].equalsIgnoreCase(name)) {
        System.out.print("Enter the new stock for " + medicine[0] + ": ");
        int newStock = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (newStock >= 0) {
          medicine[1] = Integer.toString(newStock);
          found = true;
          System.out.println("Stock updated for " + medicine[0] + ".");
        } else {
          System.out.println("Stock cannot be negative.");
        }
        break;
      }
    } 
    if (!found) {
      System.out.println("Medicine not found in the stock list.");
    }
  }

  private static void reduceStock() {
    System.out.print("Enter the name of the medicine to reduce stock: (Obat....) ");
    String name = scanner.nextLine();
    boolean found = false;
    for (String[] medicine : medicineStock) {
      if (medicine[0].equalsIgnoreCase(name)) {
        System.out.print("Enter the quantity to reduce from " + medicine[0] + ": ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        int currentStock = Integer.parseInt(medicine[1]);
        if (quantity >= 0 && quantity <= currentStock) {
          medicine[1] = Integer.toString(currentStock - quantity);
          found = true;
          System.out.println("Stock reduced for " + medicine[0] + ".");
        } else {
          System.out.println("Invalid quantity. It cannot be negative or more than the current stock.");
        }
        break;
      }
    }
    if (!found) {
      System.out.println("Medicine not found in the stock list.");
    }
  }
}
    
