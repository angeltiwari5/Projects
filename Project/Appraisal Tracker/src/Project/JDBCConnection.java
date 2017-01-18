


package Project;
import java.sql.*;

public class JDBCConnection {
    Connection Connect = null;
    JDBCConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "sonam");
            //System.out.println("Connected to database...........!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}