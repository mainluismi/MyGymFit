package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String urlLuismi;
    private String userLuismi;
    private String passwordLuismi;

    public Database(String urlLuismi, String userLuismi, String passwordLuismi) {
        this.urlLuismi = urlLuismi;
        this.userLuismi = userLuismi;
        this.passwordLuismi = passwordLuismi;
    }

    public Connection connectLuismi() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(urlLuismi, userLuismi, passwordLuismi);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }

    public void disconnectLuismi(Connection connectionLuismi) throws SQLException {
        if (connectionLuismi != null && !connectionLuismi.isClosed()) {
            connectionLuismi.close();
        }
    }
}
