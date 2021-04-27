package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("db");

        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String dbname = resource.getString("db.dbname");

        Properties prop = new Properties();

        prop.put("user", user);
        prop.put("password", pass);
        prop.put("dbname", dbname);
        return DriverManager.getConnection(url, prop);
    }
}
