import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

// Main class
public class Bill_Details {
    public static void main(String[] args) {
        // Creating a scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        try {
            // Establishing the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!tableExists(conn, "Consumer ")) {
                // Create the SQL statement to create the table
                String sql = "CREATE TABLE " + "Consumer " + " ("
                        + "ConsumerId INT PRIMARY KEY, "
                        + "ConsumerName VARCHAR(50) NOT NULL, "
                        + "Address VARCHAR(100) NOT NULL,  "
                        + "Email VARCHAR(255) NOT NULL "
                        + ");";

                // Execute the statement
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                // Print a message
                System.out.println("Created table " + "Consumer");

                // Add 4 Consumer details
                sql = "INSERT INTO Consumer (ConsumerId, ConsumerName, Address, Email) VALUES"
                        + "(101, 'Alice', '123 Main Street', 'test1@gmail.com'),"
                        + "(102, 'Bob', '456 Park Avenue', 'test2@gmail.com'),"
                        + "(103, 'Charlie', '789 Pine Road', 'test3@gmail.com'),"
                        + "(104, 'David', '101 Maple Lane', 'test4@gmail.com');";
                // Execute the statement
                stmt.executeUpdate(sql);

                // Print a message
                System.out.println("4 Consumer details added to table " + "Consumer");
            } else {
                // Print a message
                // System.out.println("Table " + tableName + " already exists");
            }
            if (!tableExists(conn, "MonthlyBill  ")) {
                // Create the SQL statement to create the table
                String sql = "CREATE TABLE " + "MonthlyBill  " + " ("
                        + "BillId INT PRIMARY KEY, "
                        + "ConsumerId INT NOT NULL,  "
                        + "Amount DECIMAL(10, 2) NOT NULL,  "
                        + "Status VARCHAR(10) NOT NULL,  "
                        + "FOREIGN KEY (ConsumerId) REFERENCES Consumer(ConsumerId)"
                        + ");";

                // Execute the statement
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                // Print a message
                System.out.println("Created table " + "MonthlyBill ");

                // Add 10 bill details
                sql = "INSERT INTO MonthlyBill (BillId, ConsumerId, Amount, Status) VALUES"
                        + "(1, 101, 100.00, 'PAID'),"
                        + "(2, 102, 150.00, 'UNPAID'),"
                        + "(3, 103, 200.00, 'PAID'),"
                        + "(4, 104, 250.00, 'UNPAID'),"
                        + "(5, 101, 300.00, 'PAID'),"
                        + "(6, 102, 350.00, 'UNPAID'),"
                        + "(7, 103, 400.00, 'PAID'),"
                        + "(8, 104, 450.00, 'UNPAID'),"
                        + "(9, 101, 500.00, 'PAID'),"
                        + "(10, 103, 550.00, 'UNPAID');";
                // Execute the statement
                stmt.executeUpdate(sql);

                // Print a message
                System.out.println("10 bill details added to table " + "MonthlyBill");
            } else {
                // Print a message
                // System.out.println("Table " + tableName + " already exists");
            }
        } catch (SQLException e) {
            // Handling the exception
            e.printStackTrace();
        }
        // Taking the input from the user
        System.out.println("Enter Email:");
        String xemail = sc.nextLine();
        System.out.println("Enter Bill No.:");
        String bill_no = sc.nextLine();
        // SQL statement to query the bill details
        String sql = "SELECT c.ConsumerName, c.Address, c.Email, b.Amount, b.Status FROM Consumer c JOIN MonthlyBill b ON c.ConsumerId = b.ConsumerId WHERE c.Email = ? OR b.BillId = ?;";
        try {
            // Loading and registering the driver
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Creating the prepared statement
            PreparedStatement ps = con.prepareStatement(sql);

            // Setting the values for the placeholders
            ps.setString(1, xemail);
            ps.setString(2, bill_no);

            // Executing the statement
            ResultSet rs = ps.executeQuery();

            // Printing the column names
            System.out.println("ConsumerName | Address         | Email           | Amount | Status");

            // Iterating over the result set
            while (rs.next()) {
                // Getting the values of the columns
                String consumerName = rs.getString("ConsumerName");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                double amount = rs.getDouble("Amount");
                String status = rs.getString("Status");

                // Printing the values of the columns
                System.out.println(String.format("%-12s", consumerName) + " | " + String.format("%-14s", address) + " | " + String.format("%-15s", email) + " | " + String.format("%-6s", amount) + " | " + String.format("%-11s", status));
            }

            // Closing the resources
            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            // Handling the exceptions
            e.printStackTrace();
        }

    }

    public static boolean tableExists(Connection conn, String tableName) throws SQLException {
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getTables(null, null, tableName, new String[] { "TABLE" });
        return rs.next();
    }

}