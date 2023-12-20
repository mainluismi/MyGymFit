/**
 * La clase `Cliente` representa a un cliente con atributos como identificaci�n, nombre, apellido, email y fecha de alta.
 * Proporciona constructores y m�todos de acceso para cada atributo.
 *
 * @author Luismi
 * @version 1.8
 * @since 20/12/23
 */
package Modelo;

public class Cliente {

    /**
     * Identificaci�n �nica del cliente.
     */
    private int idLuismi;

    /**
     * Nombre del cliente.
     */
    private String nombreLuismi;

    /**
     * Apellido del cliente.
     */
    private String apellidoLuismi;

    /**
     * Direcci�n de correo electr�nico del cliente.
     */
    private String emailLuismi;

    /**
     * Fecha en la que el cliente fue dado de alta.
     */
    private String fechaAltaLuismi;

    /**
     * Constructor por defecto.
     */
    public Cliente() {

    }

    /**
     * Constructor con la identificaci�n del cliente.
     *
     * @param idLuismi La identificaci�n del cliente.
     */
    public Cliente(int idLuismi) {
        this.idLuismi = idLuismi;
    }

    /**
     * Constructor con todos los atributos del cliente.
     *
     * @param idLuismi La identificaci�n del cliente.
     * @param nombreLuismi El nombre del cliente.
     * @param apellidoLuismi El apellido del cliente.
     * @param emailLuismi El correo electr�nico del cliente.
     * @param fechaAltaLuismi La fecha de alta del cliente.
     */
    public Cliente(int idLuismi, String nombreLuismi, String apellidoLuismi, String emailLuismi, String fechaAltaLuismi) {
        this.idLuismi = idLuismi;
        this.nombreLuismi = nombreLuismi;
        this.apellidoLuismi = apellidoLuismi;
        this.emailLuismi = emailLuismi;
        this.fechaAltaLuismi = fechaAltaLuismi;
    }

    // M�todos de acceso

    /**
     * Obtiene la identificaci�n del cliente.
     *
     * @return La identificaci�n del cliente.
     */
    public int getIdLuismi() {
        return idLuismi;
    }

    /**
     * Establece la identificaci�n del cliente.
     *
     * @param idLuismi La identificaci�n del cliente.
     */
    public void setIdLuismi(int idLuismi) {
        this.idLuismi = idLuismi;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombreLuismi() {
        return nombreLuismi;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombreLuismi El nombre del cliente.
     */
    public void setNombreLuismi(String nombreLuismi) {
        this.nombreLuismi = nombreLuismi;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return El apellido del cliente.
     */
    public String getApellidoLuismi() {
        return apellidoLuismi;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param apellidoLuismi El apellido del cliente.
     */
    public void setApellidoLuismi(String apellidoLuismi) {
        this.apellidoLuismi = apellidoLuismi;
    }

    /**
     * Obtiene el correo electr�nico del cliente.
     *
     * @return El correo electr�nico del cliente.
     */
    public String getEmailLuismi() {
        return emailLuismi;
    }

    /**
     * Establece el correo electr�nico del cliente.
     *
     * @param emailLuismi El correo electr�nico del cliente.
     */
    public void setEmailLuismi(String emailLuismi) {
        this.emailLuismi = emailLuismi;
    }

    /**
     * Obtiene la fecha de alta del cliente.
     *
     * @return La fecha de alta del cliente.
     */
    public String getFechaAltaLuismi() {
        return fechaAltaLuismi;
    }

    /**
     * Establece la fecha de alta del cliente.
     *
     * @param fechaAlta La fecha de alta del cliente.
     */
    public void setFechaAltaLuismi(String fechaAlta) {
        this.fechaAltaLuismi = fechaAlta;
    }
}
