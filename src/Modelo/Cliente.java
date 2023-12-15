package Modelo;

public class Cliente {
	private int idLuismi;
	private String nombreLuismi;
	private String apellidoLuismi;
	private String emailLuismi;
	private String fechaAltaLuismi;
	
	public Cliente() {
		
	}
	
	public Cliente(int idLuismi) {
		this.idLuismi = idLuismi;
	}
	
	public Cliente(int idLuismi, String nombreLuismi, String apellidoLuismi, String emailLuismi, String fechaAltaLuismi) {
		super();
		this.idLuismi = idLuismi;
		this.nombreLuismi = nombreLuismi;
		this.apellidoLuismi = apellidoLuismi;
		this.emailLuismi = emailLuismi;
		this.fechaAltaLuismi = fechaAltaLuismi;
	}
	
	public int getIdLuismi() {
		return idLuismi;
	}
	
	public void setIdLuismi(int idLuismi) {
		this.idLuismi = idLuismi;
	}
	
	public String getNombreLuismi() {
		return nombreLuismi;
	}
	
	public void setNombreLuismi(String nombreLuismi) {
		this.nombreLuismi = nombreLuismi;
	}
	
	public String getApellidoLuismi() {
		return apellidoLuismi;
	}
	
	public void setApellidoLuismi(String apellidoLuismi) {
		this.apellidoLuismi = apellidoLuismi;
	}
	
	public String getEmailLuismi() {
		return emailLuismi;
	}
	
	public void setEmailLuismi(String emailLuismi) {
		this.emailLuismi = emailLuismi;
	}
	
	public String getFechaAltaLuismi() {
		return fechaAltaLuismi;
	}
	
	public void setFechaAltaLuismi(String fechaAlta) {
		this.fechaAltaLuismi = fechaAlta;
	}
}
