import Modelo.Cliente;
import Vista.Vista;

import java.awt.EventQueue;

import Controlador.ClienteControlador;
import DataBase.Database;

public class Main {

    public static void main(String[] args) {
        Database database = new Database("jdbc:mysql://localhost:3306/MyGymFit", "root", "root");
        
        Cliente miCliente = new Cliente();
        ClienteControlador clienteControlador = new ClienteControlador(database);
        Vista miVista = new Vista(clienteControlador);

        miVista.mostrarPantallaCarga();
        miVista.inicializarVentana();
    }
}
