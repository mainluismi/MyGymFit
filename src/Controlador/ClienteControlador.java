package Controlador;

import Modelo.Cliente;
import Vista.Vista;
import DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteControlador {
    private Cliente miCliente = new Cliente();
    private Vista miVista;
    private Database baseDeDatos;

    public ClienteControlador(Database baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
        this.miVista = null;
    }
    
    public ClienteControlador(Database baseDeDatos, Vista miVista) {
        this.baseDeDatos = baseDeDatos;
        this.miVista = miVista;
    }

    public void insertarCliente(Cliente cliente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = baseDeDatos.connect();
            // Assuming your database has a table named 'clientes'
            String sql = "INSERT INTO clientes (nombre, apellido, email, fecha_alta) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getFechaAlta());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Insert successful
                System.out.println("Cliente insertado exitosamente");
            } else {
                // Insert failed
                System.out.println("Error al insertar cliente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarCliente(Cliente cliente) {
        // Implement the logic for deleting a client in the database
        // You can use a similar structure as the insertarCliente method
    }

    public void verClientes() {
        // Implement the logic for viewing clients in the database
        // You can use a similar structure as the insertarCliente method
    }

	public Database getConection() {
		try {
			baseDeDatos.connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Metodos para mostrar la pantalla de carga y la ventana
	public void mostrarPantallaDeCarga() {
		this.miVista.mostrarPantallaCarga();
	}
	
	public void mostrarVentana() {
		this.miVista.inicializarVentana();
	}
}
