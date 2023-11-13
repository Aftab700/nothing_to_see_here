// import java.io.IOException;
// import java.io.PrintWriter;

// @WebServlet("/first")
public class FirstServlet{
    // public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        
    //     System.out.println("this is get method....");
    //     res.setContentType("text/html");
    //     PrintWriter out = res.getWriter();
    //     out.println("<h1> this is get method of servlet=============2</h2>");
        
        
    // }
public static void main(String[] args) {
    String pwd = "aaaAaa@.@!#$%?+";
    if ((pwd.matches("[a-zA-Z0-9_\\-\\.@!#$%?+]+") && pwd.length() > 5 && pwd.length() < 31)) {
        System.out.println("true");                   
    } 
            
    
    
    }
}
