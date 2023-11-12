import java.util.Scanner;


// A class to display the customer details of a given customer
class US004 {
    // A preconfigured array of customers
    static Customer[] customers = {
        new Customer(101, "Alice", "9876543210", "alice@gmail.com"),
        new Customer(102, "Bob", "8765432109", "bob@yahoo.com"),
        new Customer(103, "Charlie", "7654321098", "charlie@outlook.com"),
        new Customer(104, "David", "6543210987", "david@bing.com"),
        new Customer(105, "Eve", "5432109876", "eve@msn.com")
    };

    // A scanner object to take input from the console
    static Scanner sc = new Scanner(System.in);

    // A method to display the customer details of a given customer
    public static void displayCustomer() {
        // Get the consumer id from the console
        System.out.print("Enter the consumer id: ");
        int consumerId = sc.nextInt();
        System.out.println("");
        // Find the customer with the given consumer id in the array
        for (Customer customer : customers) {
            if (customer.consumerId == consumerId) {
                // Display the customer details in a table format
                System.out.println("Consumer ID | Customer Name | Mobile Number | Email");
                System.out.println(String.format("%-11s", customer.consumerId) + " | " + String.format("%-13s",customer.customerName) + " | " + String.format("%-13s",customer.mobileNumber) + " | " + customer.email);
                return; // Exit the method
            }
        }

        // If the customer is not found, display a message
        System.out.println("Customer not found");
    }

    // A main method to test the display customer method
    public static void main(String[] args) {
        // Call the display customer method
        displayCustomer();

        // Close the scanner object
        sc.close();
    }
}



// A class to represent a customer
class Customer {
    // Attributes of a customer
    int consumerId;
    String customerName;
    String mobileNumber;
    String email;

    // A constructor to initialize a customer object
    public Customer(int consumerId, String customerName, String mobileNumber, String email) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}

