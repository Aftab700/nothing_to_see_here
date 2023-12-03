import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

// Main class
public class register_complaint {
    public static void main(String[] args) {
        // Creating a scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Taking the input from the user
        System.out.println("Enter the complaint type: ");
        String complaintType = sc.nextLine();

        System.out.println("Enter the category: ");
        String category = sc.nextLine();

        System.out.println("Enter the landmark: ");
        String landmark = sc.nextLine();

        System.out.println("Enter the customer name: ");
        String customerName = sc.nextLine();

        System.out.println("Enter the problem: ");
        String problem = sc.nextLine();

        System.out.println("Enter the consumer number: ");
        int consumerNumber = sc.nextInt();

        sc.nextLine(); // Consuming the newline

        System.out.println("Enter the address: ");
        String address = sc.nextLine();

        System.out.println("Enter the mobile number: ");
        long mobileNumber = sc.nextLong();

        // Creating a complaint object with the user input
        Complaint complaint = new Complaint(customerName, consumerNumber, address, mobileNumber, complaintType,
                category, landmark, problem);

        // Registering the complaint
        complaint.registerComplaint();

        // Closing the scanner
        sc.close();
    }
}

// Consumer class
class Consumer {
    // Instance variables
    private String customerName;
    private int consumerNumber;
    private String address;
    private long mobileNumber;

    // Constructor
    public Consumer(String customerName, int consumerNumber, String address, long mobileNumber) {
        this.customerName = customerName;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(int consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

// Complaint class, inherited from Consumer class
class Complaint extends Consumer {
    // Instance variables
    private String complaintType;
    private String category;
    private String landmark;
    private String problem;

    // Constructor
    public Complaint(String customerName, int consumerNumber, String address, long mobileNumber, String complaintType,
            String category, String landmark, String problem) {
        // Calling the super class constructor
        super(customerName, consumerNumber, address, mobileNumber);
        this.complaintType = complaintType;
        this.category = category;
        this.landmark = landmark;
        this.problem = problem;
    }

    // Getters and setters
    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    // Method to insert the complaint details into the database
    public void registerComplaint() {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // SQL query to insert the complaint details
        String sql = "INSERT INTO complaint (customer_name, consumer_number, address, mobile_number, complaint_type, category, landmark, problem) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Establishing the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Check if table exists if not create
            createTableIfNotExists(con, "complaint");

            // Preparing the statement
            PreparedStatement ps = con.prepareStatement(sql);

            // Setting the parameters
            ps.setString(1, getCustomerName());
            ps.setInt(2, getConsumerNumber());
            ps.setString(3, getAddress());
            ps.setLong(4, getMobileNumber());
            ps.setString(5, getComplaintType());
            ps.setString(6, getCategory());
            ps.setString(7, getLandmark());
            ps.setString(8, getProblem());

            // Executing the statement
            int rows = ps.executeUpdate();

            // Checking the result
            if (rows > 0) {
                System.out.println("Successfully registered complaint");
            } else {
                System.out.println("Failed to register complaint");
            }

            // Closing the resources
            ps.close();
            con.close();

        } catch (SQLException e) {
            // Handling the exception
            e.printStackTrace();
        }
    }

    // Method to check if the complaint table exists
    public static boolean tableExists(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getTables(null, null, tableName, new String[] { "TABLE" });
        return rs.next();
    }

    // Method to create the complaint table if it does not exist
    public static void createTableIfNotExists(Connection conn, String tableName) throws SQLException {
        // Check if the table exists
        if (!tableExists(conn, tableName)) {
            // Create the SQL statement to create the table
            String sql = "CREATE TABLE " + tableName + " ("
                    + "complaint_type VARCHAR(255), "
                    + "category VARCHAR(255), "
                    + "landmark VARCHAR(255), "
                    + "customer_name VARCHAR(255), "
                    + "problem VARCHAR(255), "
                    + "consumer_number INT, "
                    + "address VARCHAR(255), "
                    + "mobile_number BIGINT"
                    + ");";

            // Execute the statement
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            // Print a message
            System.out.println("Created table " + tableName);
        } else {
            // Print a message
            // System.out.println("Table " + tableName + " already exists");
        }
    }
}
