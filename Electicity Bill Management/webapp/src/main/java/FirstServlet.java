import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

import init_db_package.init_db;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/new")
public class FirstServlet extends HttpServlet {

    private static Connection connection;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        connection = init_db.connect_mysql();

        System.out.println("GET /new....");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("new");

        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT ConsumerId FROM Customer WHERE ConsumerId = ?");
            ps.setString(1, "1234567890123");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.next());

            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
