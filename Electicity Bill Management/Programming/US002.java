import java.util.ArrayList;
import java.util.Scanner;


// A class to test the bill operations
class US002 {
    public static void main(String[] args) {
        // Create a bill operations object
        BillOperations bo = new BillOperations();

        // A boolean variable to control the loop
        boolean flag = true;

        // A loop to take input from the user and perform the operations
        while (flag) {
            // Display the menu of options
            System.out.println("Enter your choice:");
            System.out.println("1. To add a bill");
            System.out.println("2. To update a bill");
            System.out.println("3. To delete a bill");
            System.out.println("4. To exit");

            // Get the choice from the user
            int choice = bo.sc.nextInt();

            // Perform the operation based on the choice
            switch (choice) {
                case 1:
                    bo.addBill();
                    break;
                case 2:
                    bo.updateBill();
                    break;
                case 3:
                    bo.deleteBill();
                    break;
                case 4:
                    flag = false; // To exit the loop
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        // Close the scanner object
        bo.sc.close();
    }
}


// A class to represent a bill
class Bill {
    // Attributes of a bill
    int consumerNumber;
    double dueAmount;
    double payableAmount;

    // A constructor to initialize a bill object
    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    // A method to display the bill details
    public void display() {
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Due Amount: " + dueAmount);
        System.out.println("Payable Amount: " + payableAmount);
    }
}

// A class to perform the operations on bills
class BillOperations {
    // An array list to store the bills
    ArrayList<Bill> bills;

    // A scanner object to take input from the console
    Scanner sc;

    // A constructor to initialize the array list and the scanner
    public BillOperations() {
        bills = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // A method to add a bill to the array list
    public void addBill() {
        // Get the bill attributes from the console
        System.out.println("Enter the consumer number:");
        int consumerNumber = sc.nextInt();
        System.out.println("Enter the due amount:");
        double dueAmount = sc.nextDouble();
        System.out.println("Enter the payable amount:");
        double payableAmount = sc.nextDouble();

        // Create a bill object with the given attributes
        Bill bill = new Bill(consumerNumber, dueAmount, payableAmount);

        // Add the bill object to the array list
        bills.add(bill);

        // Display an acknowledgment message
        System.out.println("Bill details are added successfully");
    }

    // A method to update the amount details of a bill
    public void updateBill() {
        // Get the amount and consumer number from the console
        System.out.println("Enter the amount:");
        double amount = sc.nextDouble();
        System.out.println("Enter the consumer number:");
        int consumerNumber = sc.nextInt();

        // Find the bill with the given consumer number in the array list
        for (Bill bill : bills) {
            if (bill.consumerNumber == consumerNumber) {
                // Update the amount details of the bill
                bill.dueAmount = amount;
                bill.payableAmount = amount;
                // Display an acknowledgment message
                System.out.println("Bill details are updated successfully");
                return; // Exit the method
            }
        }

        // If the bill is not found, display a message
        System.out.println("Bill not found");
    }

    // A method to delete a bill from the array list
    public void deleteBill() {
        // Get the consumer number from the console
        System.out.println("Enter the consumer number:");
        int consumerNumber = sc.nextInt();

        // Find the bill with the given consumer number in the array list
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            if (bill.consumerNumber == consumerNumber) {
                // Remove the bill from the array list
                bills.remove(i);
                // Display an acknowledgment message
                System.out.println("Bill details are deleted");
                return; // Exit the method
            }
        }

        // If the bill is not found, display a message
        System.out.println("Bill not found");
    }
}

