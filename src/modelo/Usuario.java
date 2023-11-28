package modelo;

public class Usuario {
	private int usuarioId;
	private String nombre;
	private String apellido;
	private String rol;
	public Usuario(int usuarioId, String nombre, String apellido, String rol) {
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	public String getRol(){
		return rol;
	}
	public void setRol(String rol){
		this.rol = rol;
	}
}