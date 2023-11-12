import java.util.Scanner;


// A class to display the unpaid bill details of a given customer
class US005 {
    // A preconfigured array of bills
    static Bill[] bills = {
        new Bill(101, "Alice", 1000.0, 0.0),
        new Bill(102, "Bob", 500.0, 500.0),
        new Bill(103, "Charlie", 2000.0, 1000.0),
        new Bill(104, "David", 0.0, 0.0),
        new Bill(105, "Eve", 1500.0, 500.0)
    };

    // A scanner object to take input from the console
    static Scanner sc = new Scanner(System.in);

    // A method to display the unpaid bill details of a given customer
    public static void displayBill() {
        // Get the consumer id from the console
        System.out.print("Enter the consumer id:");
        int consumerId = sc.nextInt();
        System.out.println("");
        // Find the bill with the given consumer id in the array
        for (Bill bill : bills) {
            if (bill.consumerId == consumerId) {
                // Check if the bill is unpaid
                if (bill.dueAmount > bill.payableAmount) {
                    // Display the bill details in a table format
                    System.out.println("Consumer ID | Customer Name | Due Amount | Payable Amount");
                    System.out.println(String.format("%-11s", bill.consumerId) + " | " + String.format("%-13s", bill.customerName) + " | " + String.format("%-10s", bill.dueAmount) + " | " + bill.payableAmount);
                    return; // Exit the method
                } else {
                    // Display a message
                    System.out.println("No unpaid bill found for this customer");
                    return; // Exit the method
                }
            }
        }

        // If the bill is not found, display a message
        System.out.println("Bill not found");
    }

    // A main method to test the display bill method
    public static void main(String[] args) {
        // Call the display bill method
        displayBill();

        // Close the scanner object
        sc.close();
    }
}

// A class to represent a bill
class Bill {
    // Attributes of a bill
    int consumerId;
    String customerName;
    double dueAmount;
    double payableAmount;

    // A constructor to initialize a bill object
    public Bill(int consumerId, String customerName, double dueAmount, double payableAmount) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }
}