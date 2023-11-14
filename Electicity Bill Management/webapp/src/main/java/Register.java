import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import init_db_package.init_db;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static Connection connection;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("GET /Register....");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/Register.html").include(req, res);
        out.println("");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        connection = init_db.connect_mysql();
        System.out.println("POST /Register....");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String consumer_number = req.getParameter("consumer_number");
        String bill_number = req.getParameter("bill_number");
        String user_title = req.getParameter("user_title");
        String user_name = req.getParameter("user_name");
        String email = req.getParameter("email");
        String country_code = req.getParameter("country_code");
        String mobile_number = req.getParameter("mobile_number");
        String user_id = req.getParameter("user_id");
        String pwd = req.getParameter("pwd");
        String conf_pwd = req.getParameter("conf_pwd");

        String check_message = check_form_data(consumer_number, bill_number, user_title, user_name, email, country_code,
                mobile_number, user_id, pwd, conf_pwd);

        System.out.println(check_message);

        if (check_message != "ok") {
            req.getRequestDispatcher("/Register.html").include(req, res);
            out.println("<script>document.getElementById(\"message\").innerHTML = \"" + check_message + "\";\n");
            out.println("document.getElementById(\"message\").classList.remove('hidden');</script>");

            return;
        } else {
            System.out.println("Consumer  Registration successful....");
            req.getRequestDispatcher("/Register_confirmation.html").include(req, res);
            out.println("<script>document.getElementById(\"customer_id_message\").innerHTML = \"" + consumer_number
                    + "\";\n");
            out.println("document.getElementById(\"customer_name_message\").innerHTML = \"" + user_name + "\";\n");
            out.println("document.getElementById(\"mobile_number_message\").innerHTML = \"" + mobile_number
                    + "\";\n</script>");

            // connect to database
            try {
                connection = init_db.connect_mysql();
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO Customer (ConsumerId, bill_number, user_title, CustomerName, Email, MobileNumber, UserId, Password) VALUES\r\n"
                                + "(?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, consumer_number);
                ps.setString(2, bill_number);
                ps.setString(3, user_title);
                ps.setString(4, user_name);
                ps.setString(5, email);
                ps.setString(6, "+"+country_code+" "+mobile_number);
                ps.setString(7, user_id);
                ps.setString(8, pwd);
                Integer rs = ps.executeUpdate();
                System.out.println(rs);
                if (rs > 0) {
                    System.out.println("New Registration data added to customer table.....");
                }else{
                    System.out.println("New Registration data not added to table.......");
                }
                // connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String check_form_data(String consumer_number, String bill_number, String user_title,
            String user_name, String email, String country_code, String mobile_number, String user_id, String pwd,
            String conf_pwd) {

        connection = init_db.connect_mysql();
        if (!consumer_number.matches("\\d{13}")) {
            System.out.println("consumer_number not valid");
            return "invalid Consumer Number!";
        }
        if (!bill_number.matches("\\d{5}")) {
            System.out.println("bill_number not valid");
            return "invalid Bill Number!";
        }
        if (!(user_name.length() < 51 && user_name.length() > 3 && user_name.matches("[a-zA-Z\s]*"))) {
            System.out.println("user_name not valid");
            return "invalid Name!";
        }
        if (!(email.matches("[a-zA-Z0-9\\.\\-+_]+@[a-zA-Z0-9\\.\\-+_]+\\.[a-z]+") && email.length() > 5)) {
            System.out.println("email not valid");
            return "invalid email!";
        }
        if (!(country_code.matches("\\d+"))) {
            System.out.println("country_code not valid");
            return "invalid Country code!";
        }
        if (!(mobile_number.matches("\\d{10}"))) {
            System.out.println("mobile_number not valid");
            return "invalid Mobile number!";
        }
        if (!(user_id.matches("[a-zA-Z0-9_\\-\\.]+") && user_id.length() > 4 && user_id.length() < 21)) {
            System.out.println("user_id not valid");
            return "invalid User Id!";
        }
        if (!(pwd.matches("[a-zA-Z0-9_\\-\\.@!#$%?+]+") && pwd.length() > 5 && pwd.length() < 31)) {
            System.out.println("pwd not valid");
            return "invalid Password!";
        }
        if (!pwd.equals(conf_pwd)) {
            System.out.println("conf_pwd not valid");
            return "invalid Confirm Password!";
        }
        try {
            connection = init_db.connect_mysql();
            PreparedStatement ps = connection
                    .prepareStatement("SELECT ConsumerId FROM Customer WHERE ConsumerId = ?");
            ps.setString(1, consumer_number);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            if (rs.next()) {
                return "Consumer Number already exists!";
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = init_db.connect_mysql();
            PreparedStatement ps = connection
                    .prepareStatement("SELECT UserId FROM Customer WHERE UserId = ?");
            ps.setString(1, user_id);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            if (rs.next()) {
                return "UserId already exists!";
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = init_db.connect_mysql();
            PreparedStatement ps = connection
                    .prepareStatement("SELECT Email FROM Customer WHERE Email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            if (rs.next()) {
                return "Email already exists!";
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "ok";
    }
}
