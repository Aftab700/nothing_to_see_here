import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import init_db_package.init_db;

public class new1 {
    private static Connection connection;

    public static void main(String[] args) {
       System.out.println("==============================================="); 
        // try {
        // connection = init_db.connect_mysql();
        // PreparedStatement ps = connection
        // .prepareStatement("SELECT ConsumerId FROM Customer WHERE ConsumerId = ?");
        // ps.setString(1, "4234567890123");
        // ResultSet rs = ps.executeQuery();
        // System.out.println(rs.next());
        // connection.close();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }
}
