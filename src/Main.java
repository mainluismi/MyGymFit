import Modelo.Cliente;
import Vista.Vista;

import java.awt.EventQueue;

import Controlador.ClienteControlador;
import DataBase.Database;

public class Main {

    public static void main(String[] args) {
        Database databaseLuismi = new Database("jdbc:mysql://localhost:3306/MyGymFit", "root", "");

        ClienteControlador clienteControladorLuismi = new ClienteControlador(databaseLuismi);
        Vista miVistaLuismi = new Vista(clienteControladorLuismi); 

        clienteControladorLuismi.setVistaLuismi(miVistaLuismi);  
        clienteControladorLuismi.mostrarPantallaDeCargaLuismi();
        clienteControladorLuismi.mostrarVentanaLuismi();
    }
}



