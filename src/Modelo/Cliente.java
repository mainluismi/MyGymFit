package Modelo;

public class Cliente {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String fechaAlta;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nombre, String apellido, String email, String fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaAlta = fechaAlta;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
