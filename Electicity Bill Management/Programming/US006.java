import java.util.Scanner;


// A class to display the complaint details of a given customer
class US006 {
    // A preconfigured array of complaints
    static Complaint[] complaints = {
        new Complaint(101, "Alice", "Water", "Leakage", "Water is leaking from the pipe", "9876543210", "Pending"),
        new Complaint(102, "Bob", "Electricity", "Power Cut", "No power supply since morning", "8765432109", "Resolved"),
        new Complaint(103, "Charlie", "Gas", "Low Pressure", "Gas pressure is very low", "7654321098", "In Progress"),
        new Complaint(104, "David", "Internet", "Slow Speed", "Internet speed is very slow", "6543210987", "Resolved"),
        new Complaint(105, "Eve", "Garbage", "Not Collected", "Garbage is not collected for a week", "5432109876", "Pending")
    };

    // A scanner object to take input from the console
    static Scanner sc = new Scanner(System.in);

    // A method to display the complaint details of a given customer
    public static void displayComplaint() {
        // Get the consumer id from the console
        System.out.print("Enter the consumer id:");
        int consumerId = sc.nextInt();
        System.out.println("");
        // Find the complaint with the given consumer id in the array
        for (Complaint complaint : complaints) {
            if (complaint.consumerId == consumerId) {
                // Display the complaint details in a table format
                System.out.println("Consumer ID | Customer Name | Complaint Type | Category | Problem Description | Mobile | Status");
                System.out.println(String.format("%-11s",complaint.consumerId) + " | " + String.format("%-13s",complaint.customerName) + " | " + String.format("%-14s",complaint.complaintType) + " | " + String.format("%-8s",complaint.category) + " | " + String.format("%-19s",complaint.problemDescription) + " | " + String.format("%-6s",complaint.mobile) + " | " + complaint.status);
                return; // Exit the method
            }
        }

        // If the complaint is not found, display a message
        System.out.println("Complaint not found");
    }

    // A main method to test the display complaint method
    public static void main(String[] args) {
        // Call the display complaint method
        displayComplaint();

        // Close the scanner object
        sc.close();
    }
}


// A class to represent a complaint
class Complaint {
    // Attributes of a complaint
    int consumerId;
    String customerName;
    String complaintType;
    String category;
    String problemDescription;
    String mobile;
    String status;

    // A constructor to initialize a complaint object
    public Complaint(int consumerId, String customerName, String complaintType, String category, String problemDescription, String mobile, String status) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.complaintType = complaintType;
        this.category = category;
        this.problemDescription = problemDescription;
        this.mobile = mobile;
        this.status = status;
    }
}