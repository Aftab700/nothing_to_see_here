import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.jdbc.ScriptRunner;
import init_db_package.init_db;

@WebListener
public class Config implements ServletContextListener {
    private static Connection connection;

    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
        connection = init_db.connect_mysql();
        try {

            if (!connection.getMetaData().getTables(null, null, "customer", new String[] { "TABLE" }).next()) {
                System.out.println("'customer' table not found, creating...");
                ScriptRunner script_runner = new ScriptRunner(connection);
                Reader sql_file_reader = new BufferedReader(new FileReader(
                        "C:\\Users\\Jack Sparrow\\Downloads\\Case Studies_Updated\\Test\\Electicity Bill Management\\webapp\\src\\main\\java\\create_customer_table.sql"));
                script_runner.runScript(sql_file_reader);
                System.out.println("Done.....");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
        System.out.println("Shutting down...........");
    }
}
