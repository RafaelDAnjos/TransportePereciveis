package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Rafael
 */

public class DBConnection {

    private static Connection instance = null;        
    
    public DBConnection() {
    }
    public static synchronized Connection getInstance() {
        if (instance == null) {
            try {
                Connection c = null;
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transportePereciveis", "postgres", "");
                c.setAutoCommit(true);
                instance = c;
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return instance;
    }
}