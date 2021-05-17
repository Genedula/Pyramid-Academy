import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection connection = null;

    private static void makeConnection() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("resources/config.properties"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("url");
        String usr = props.getProperty("usr");
        String pwd = props.getProperty("pwd");
        try {
            connection = DriverManager.getConnection(url, usr, pwd);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        if(connection == null) {
            makeConnection();
        }
        return connection;
    }
}