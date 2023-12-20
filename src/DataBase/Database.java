/**
 * La clase `Database` proporciona funcionalidades para conectar y desconectar a una base de datos MySQL.
 * Utiliza el controlador JDBC para gestionar la conexi�n.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    /**
     * La URL de la base de datos.
     */
    private String urlLuismi;

    /**
     * El nombre de usuario para la conexi�n a la base de datos.
     */
    private String userLuismi;

    /**
     * La contrase�a del usuario para la conexi�n a la base de datos.
     */
    private String passwordLuismi;

    /**
     * Construye una nueva instancia de `Database` con la informaci�n de conexi�n proporcionada.
     *
     * @param urlLuismi La URL de la base de datos.
     * @param userLuismi El nombre de usuario para la conexi�n a la base de datos.
     * @param passwordLuismi La contrase�a del usuario para la conexi�n a la base de datos.
     */
    public Database(String urlLuismi, String userLuismi, String passwordLuismi) {
        this.urlLuismi = urlLuismi;
        this.userLuismi = userLuismi;
        this.passwordLuismi = passwordLuismi;
    }

    /**
     * Establece una conexi�n a la base de datos.
     *
     * @return La conexi�n establecida a la base de datos.
     * @throws SQLException Si ocurre un error al intentar conectar a la base de datos.
     */
    public Connection connectLuismi() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(urlLuismi, userLuismi, passwordLuismi);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de base de datos no encontrado", e);
        }
    }

    /**
     * Desconecta la conexi�n proporcionada a la base de datos.
     *
     * @param connectionLuismi La conexi�n a la base de datos que se desconectar�.
     * @throws SQLException Si ocurre un error al intentar desconectar la base de datos.
     */
    public void disconnectLuismi(Connection connectionLuismi) throws SQLException {
        if (connectionLuismi != null && !connectionLuismi.isClosed()) {
            connectionLuismi.close();
        }
    }
}
