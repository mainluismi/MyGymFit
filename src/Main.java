/**
 * La clase `Main` es la clase principal que inicia la aplicación MyGymFit.
 * Crea instancias de la base de datos, el controlador del cliente y la vista, y muestra la interfaz gráfica de usuario.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
import Modelo.Cliente;
import Vista.Vista;
import java.awt.EventQueue;
import Controlador.ClienteControlador;
import DataBase.Database;
import Controlador.ClienteControlador;
import DataBase.Database;
import Vista.Vista;

public class Main {

    /**
     * Método principal que inicia la aplicación MyGymFit.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Crear una instancia de la base de datos
        Database databaseLuismi = new Database("jdbc:mysql://localhost:3306/MyGymFit", "root", "");

        // Crear instancias del controlador del cliente y la vista
        ClienteControlador clienteControladorLuismi = new ClienteControlador(databaseLuismi);
        Vista miVistaLuismi = new Vista(clienteControladorLuismi);

        // Establecer la vista en el controlador
        clienteControladorLuismi.setVistaLuismi(miVistaLuismi);

        // Mostrar la pantalla de carga y la ventana principal
        clienteControladorLuismi.mostrarPantallaDeCargaLuismi();
        clienteControladorLuismi.mostrarVentanaLuismi();
    }
}




