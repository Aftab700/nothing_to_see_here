import java.util.ArrayList;
import java.util.Scanner;


// A class to test the complaint operations
class US003 {
    public static void main(String[] args) {
        // Create a complaint operations object
        ComplaintOperations co = new ComplaintOperations();

        // A boolean variable to control the loop
        boolean flag = true;

        // A loop to take input from the user and perform the operations
        while (flag) {
            // Display the menu of options
            System.out.println("Enter your choice:");
            System.out.println("1. To register a complaint");
            System.out.println("2. To delete a complaint");
            System.out.println("3. To exit");

            // Get the choice from the user
            int choice = co.sc.nextInt();
            co.sc.nextLine(); // To consume the newline character

            // Perform the operation based on the choice
            switch (choice) {
                case 1:
                    co.registerComplaint();
                    break;
                case 2:
                    co.deleteComplaint();
                    break;
                case 3:
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



// A class to represent a complaint
class Complaint {
    // Attributes of a complaint
    int complaintId;
    String complaintType;
    String category;
    String landMark;
    String customerName;
    String problem;
    int consumerNumber;
    String address;
    String mobileNumber;

    // A static variable to generate unique complaint ids
    static int complaintCount = 0;

    // A constructor to initialize a complaint object
    public Complaint(String complaintType, String category, String landMark, String customerName, String problem, int consumerNumber, String address, String mobileNumber) {
        // Increment the complaint count and assign it as the complaint id
        complaintCount++;
        this.complaintId = complaintCount;
        this.complaintType = complaintType;
        this.category = category;
        this.landMark = landMark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // A method to display the complaint details
    public void display() {
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Complaint Type: " + complaintType);
        System.out.println("Category: " + category);
        System.out.println("LandMark: " + landMark);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Problem: " + problem);
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Address: " + address);
        System.out.println("Mobile Number: " + mobileNumber);
    }
}

// A class to perform the operations on complaints
class ComplaintOperations {
    // An array list to store the complaints
    ArrayList<Complaint> complaints;

    // A scanner object to take input from the console
    Scanner sc;

    // A constructor to initialize the array list and the scanner
    public ComplaintOperations() {
        complaints = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // A method to register a complaint and add it to the array list
    public void registerComplaint() {
        // Get the complaint attributes from the console
        System.out.println("Enter the complaint type:");
        String complaintType = sc.nextLine();
        System.out.println("Enter the category:");
        String category = sc.nextLine();
        System.out.println("Enter the land mark:");
        String landMark = sc.nextLine();
        System.out.println("Enter the customer name:");
        String customerName = sc.nextLine();
        System.out.println("Enter the problem:");
        String problem = sc.nextLine();
        System.out.println("Enter the consumer number:");
        int consumerNumber = sc.nextInt();
        sc.nextLine(); // To consume the newline character
        System.out.println("Enter the address:");
        String address = sc.nextLine();
        System.out.println("Enter the mobile number:");
        String mobileNumber = sc.nextLine();

        // Create a complaint object with the given attributes
        Complaint complaint = new Complaint(complaintType, category, landMark, customerName, problem, consumerNumber, address, mobileNumber);

        // Add the complaint object to the array list
        complaints.add(complaint);

        // Display a registration acknowledgment message
        System.out.println("Successfully registered Complaint");
    }

    // A method to delete a complaint from the array list
    public void deleteComplaint() {
        // Get the complaint id from the console
        System.out.println("Enter the complaint id:");
        int complaintId = sc.nextInt();

        // Find the complaint with the given complaint id in the array list
        for (int i = 0; i < complaints.size(); i++) {
            Complaint complaint = complaints.get(i);
            if (complaint.complaintId == complaintId) {
                // Remove the complaint from the array list
                complaints.remove(i);
                // Display an acknowledgment message
                System.out.println("Complaint details are deleted");
                return; // Exit the method
            }
        }

        // If the complaint is not found, display a message
        System.out.println("Complaint not found");
    }
}

