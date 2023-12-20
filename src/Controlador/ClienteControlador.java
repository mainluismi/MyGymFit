/**
 * La clase `ClienteControlador` es una clase de controlador encargada de manejar operaciones relacionadas con clientes,
 * interactuando con el modelo (`Cliente`), la vista (`Vista`) y la base de datos (`Database`).
 * Incluye métodos para insertar y eliminar clientes de la base de datos, así como otros métodos de utilidad.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
package Controlador;

import Modelo.Cliente;
import Vista.Vista;
import DataBase.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteControlador {
	/**
     * La instancia de cliente asociada con este controlador.
     */
    private Cliente miClienteLuismi = new Cliente();
    /**
     * La instancia de vista asociada con este controlador.
     */
    private Vista miVistaLuismi;
    /**
     * La instancia de base de datos asociada con este controlador.
     */
    private Database miBaseDeDatosLuismi;
    
    /**
     * Construye un nuevo `ClienteControlador` con una referencia a la base de datos.
     *
     * @param baseDeDatos La base de datos a la que se conectará el controlador.
     */
    public ClienteControlador(Database baseDeDatos) {
        this.miBaseDeDatosLuismi = baseDeDatos;
        this.miVistaLuismi = null;
    }
    
    /**
     * Construye un nuevo `ClienteControlador` con referencias a la base de datos y la vista.
     *
     * @param baseDeDatos La base de datos a la que se conectará el controlador.
     * @param miVista La vista asociada con este controlador.
     */
    public ClienteControlador(Database baseDeDatos, Vista miVista) {
        this.miBaseDeDatosLuismi = baseDeDatos;
        this.miVistaLuismi = miVista;
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param cliente El cliente a insertar en la base de datos.
     */
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

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param cliente El cliente a eliminar de la base de datos.
     */
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

    /**
     * Muestra la lista de clientes.
     */
    public void verClientesLuismi() {
        
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
	public Database getConectionLuismi() {
		try {
			miBaseDeDatosLuismi.connectLuismi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * Muestra la pantalla de carga en la vista.
     */
	public void mostrarPantallaDeCargaLuismi() {
		this.miVistaLuismi.MostrarPantallaCargaLuismi();
	}
	
	/**
     * Inicializa la ventana en la vista.
     */
	public void mostrarVentanaLuismi() {
		this.miVistaLuismi.inicializarVentanaLuismi();
	}
	
	/**
     * Establece el cliente asociado con este controlador.
     *
     * @param clienteLuismi El cliente a asociar con este controlador.
     */
	public void setClienteLuismi(Cliente clienteLuismi) {
        this.miClienteLuismi = clienteLuismi;
    }
	
	/**
     * Establece la vista asociada con este controlador.
     *
     * @param vistaLuismi La vista a asociar con este controlador.
     */
	 public void setVistaLuismi(Vista vistaLuismi) {
	    this.miVistaLuismi = vistaLuismi;
	 }
}
