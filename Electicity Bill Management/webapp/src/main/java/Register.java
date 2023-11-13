import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("GET /Register....");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        req.getRequestDispatcher("/Register.html").include(req, res);
        out.println("");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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
            System.out.println("Consumer  Registration successful.");
            req.getRequestDispatcher("/Register_confirmation.html").include(req, res);
            out.println("<script>document.getElementById(\"customer_id_message\").innerHTML = \"" + consumer_number + "\";\n");
            out.println("document.getElementById(\"customer_name_message\").innerHTML = \"" + user_name + "\";\n");
            out.println("document.getElementById(\"mobile_number_message\").innerHTML = \"" + mobile_number + "\";\n</script>");
            
            // connect to database later

        }
    }

    public static String check_form_data(String consumer_number, String bill_number, String user_title,
            String user_name, String email, String country_code, String mobile_number, String user_id, String pwd,
            String conf_pwd) {
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
        return "ok";
    }
}
