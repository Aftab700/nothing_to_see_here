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
        out.println("<h1> this is post method of servlet</h2>");
        
        out.println("consumer-number:" + req.getParameter("consumer-number") + "<br>");
        out.println("bill-number:" + req.getParameter("bill-number") + "<br>");
        out.println("user-title:" + req.getParameter("user-title") + "<br>");
        out.println("user-name:" + req.getParameter("user-name") + "<br>");
        out.println("email:" + req.getParameter("email") + "<br>");
        out.println("country-code:" + req.getParameter("country-code") + "<br>");
        out.println("mobile-number:" + req.getParameter("mobile-number") + "<br>");
        out.println("user-id:" + req.getParameter("user-id") + "<br>");
        out.println("pwd:" + req.getParameter("pwd") + "<br>");
        out.println("conf-pwd:" + req.getParameter("conf-pwd") + "<br>");

    }
}
