import java.util.ArrayList;
import java.util.Scanner;

// A class to test the customer operations
class US001 {
    public static void main(String[] args) {
        // Create a customer operations object
        CustomerOperations co = new CustomerOperations();

        // A boolean variable to control the loop
        boolean flag = true;

        // A loop to take input from the user and perform the operations
        while (flag) {
            // Display the menu of options
            System.out.println("Enter your choice:");
            System.out.println("1. To add a customer");
            System.out.println("2. To update a customer");
            System.out.println("3. To delete a customer");
            System.out.println("4. To select customers");
            System.out.println("5. To exit");

            // Get the choice from the user
            int choice = co.sc.nextInt();
            co.sc.nextLine(); // To consume the newline character

            // Perform the operation based on the choice
            switch (choice) {
                case 1:
                    co.addCustomer();
                    break;
                case 2:
                    co.updateCustomer();
                    break;
                case 3:
                    co.deleteCustomer();
                    break;
                case 4:
                    co.selectCustomers();
                    break;
                case 5:
                    flag = false; // To exit the loop
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        // Close the scanner object
        co.sc.close();
    }
}

// A class to represent a customer
class Customer {
    // Attributes of a customer
    int consumerId;
    int billNumber;
    String title;
    String customerName;
    String email;
    String mobileNumber;
    String userId;
    String password;
    String confirmPassword;

    // A constructor to initialize a customer object
    public Customer(int consumerId, int billNumber, String title, String customerName, String email, String mobileNumber, String userId, String password, String confirmPassword) {
        this.consumerId = consumerId;
        this.billNumber = billNumber;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // A method to display the customer details
    public void display() {
        System.out.println("Consumer ID: " + consumerId);
        System.out.println("Bill Number: " + billNumber);
        System.out.println("Title: " + title);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("User ID: " + userId);
        System.out.println("Password: " + password);
        System.out.println("Confirm Password: " + confirmPassword);
    }
}

// A class to perform the operations on customers
class CustomerOperations {
    // An array list to store the customers
    ArrayList<Customer> customers;

    // A scanner object to take input from the console
    Scanner sc;

    // A constructor to initialize the array list and the scanner
    public CustomerOperations() {
        customers = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // A method to add a customer to the array list
    public void addCustomer() {
        // Get the customer attributes from the console
        System.out.println("Enter the consumer ID:");
        int consumerId = sc.nextInt();
        System.out.println("Enter the bill number:");
        int billNumber = sc.nextInt();
        sc.nextLine(); // To consume the newline character
        System.out.println("Enter the title:");
        String title = sc.nextLine();
        System.out.println("Enter the customer name:");
        String customerName = sc.nextLine();
        System.out.println("Enter the email:");
        String email = sc.nextLine();
        System.out.println("Enter the mobile number:");
        String mobileNumber = sc.nextLine();
        System.out.println("Enter the user ID:");
        String userId = sc.nextLine();
        System.out.println("Enter the password:");
        String password = sc.nextLine();
        System.out.println("Enter the confirm password:");
        String confirmPassword = sc.nextLine();

        // Create a customer object with the given attributes
        Customer customer = new Customer(consumerId, billNumber, title, customerName, email, mobileNumber, userId, password, confirmPassword);

        // Add the customer object to the array list
        customers.add(customer);

        // Display a registration acknowledgment message
        System.out.println("Customer Registration is successful");
    }

    // A method to update the email address of a customer
    public void updateCustomer() {
        // Get the email address and consumer id from the console
        System.out.println("Enter the email address:");
        String email = sc.nextLine();
        System.out.println("Enter the consumer id:");
        int consumerId = sc.nextInt();

        // Find the customer with the given consumer id in the array list
        for (Customer customer : customers) {
            if (customer.consumerId == consumerId) {
                // Update the email address of the customer
                customer.email = email;
                // Display an acknowledgment message
                System.out.println("Customer details are updated successfully");
                return; // Exit the method
            }
        }

        // If the customer is not found, display a message
        System.out.println("Customer not found");
    }

    // A method to delete a customer from the array list
    public void deleteCustomer() {
        // Get the consumer id from the console
        System.out.println("Enter the consumer id:");
        int consumerId = sc.nextInt();

        // Find the customer with the given consumer id in the array list
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.consumerId == consumerId) {
                // Remove the customer from the array list
                customers.remove(i);
                // Display an acknowledgment message
                System.out.println("Customer details are deleted");
                return; // Exit the method
            }
        }

        // If the customer is not found, display a message
        System.out.println("Customer not found");
    }

    // A method to select and display all the customers from the array list
    public void selectCustomers() {
        // Check if the array list is empty
        if (customers.isEmpty()) {
            // Display a message
            System.out.println("No customers found");
        } else {
            // Display all the customers in the array list
            for (Customer customer : customers) {
                customer.display();
                System.out.println();
            }
        }
    }
}
