package Controlador;

import Modelo.Cliente;
import Vista.Vista;
import DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteControlador {
    private Cliente miClienteLuismi = new Cliente();
    private Vista miVistaLuismi;
    private Database miBaseDeDatosLuismi;

    public ClienteControlador(Database baseDeDatos) {
        this.miBaseDeDatosLuismi = baseDeDatos;
        this.miVistaLuismi = null;
    }
    
    public ClienteControlador(Database baseDeDatos, Vista miVista) {
        this.miBaseDeDatosLuismi = baseDeDatos;
        this.miVistaLuismi = miVista;
    }

    public void insertarClienteLuismi(Cliente cliente) {
        Connection connectionLuismi = null;
        PreparedStatement preparedStatementLuismi = null;

        try {
            connectionLuismi = miBaseDeDatosLuismi.connectLuismi();
            String sql = "INSERT INTO cliente (nombre, apellido, email, fechaAlta) VALUES (?, ?, ?, ?)";
            preparedStatementLuismi = connectionLuismi.prepareStatement(sql);
            
            preparedStatementLuismi.setString(1, cliente.getNombreLuismi());
            preparedStatementLuismi.setString(2, cliente.getApellidoLuismi());
            preparedStatementLuismi.setString(3, cliente.getEmailLuismi());
            preparedStatementLuismi.setString(4, cliente.getFechaAltaLuismi());
            

            int rowsAffected = preparedStatementLuismi.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente insertado exitosamente");
            } else {
                System.out.println("Error al insertar cliente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementLuismi != null) {
                    preparedStatementLuismi.close();
                }
                if (connectionLuismi != null) {
                    connectionLuismi.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarClienteLuismi(Cliente cliente) {
    	Connection connectionLuismi = null;
        PreparedStatement preparedStatementLuismi = null;

        try {
            connectionLuismi = miBaseDeDatosLuismi.connectLuismi();
            String sql = "DELETE FROM cliente WHERE id=?";
            preparedStatementLuismi = connectionLuismi.prepareStatement(sql);
            
            preparedStatementLuismi.setInt(1, cliente.getIdLuismi());  

            int rowsAffected = preparedStatementLuismi.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado correctamente");
            } else {
                System.out.println("Error al eliminar cliente");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatementLuismi != null) {
                    preparedStatementLuismi.close();
                }
                if (connectionLuismi != null) {
                    connectionLuismi.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void verClientesLuismi() {
        
    }

	public Database getConectionLuismi() {
		try {
			miBaseDeDatosLuismi.connectLuismi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void mostrarPantallaDeCargaLuismi() {
		this.miVistaLuismi.MostrarPantallaCargaLuismi();
	}
	
	public void mostrarVentanaLuismi() {
		this.miVistaLuismi.inicializarVentanaLuismi();
	}
	
	public void setClienteLuismi(Cliente clienteLuismi) {
        this.miClienteLuismi = clienteLuismi;
    }
	
	 public void setVistaLuismi(Vista vistaLuismi) {
	    this.miVistaLuismi = vistaLuismi;
	 }
}
