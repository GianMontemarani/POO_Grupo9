package dto;

import modelo.Usuario;

public class UsuarioDto {
	private int usuarioId;
	private String user;
	private String password;
	private String nombre;
	private String apellido;
	private String rol;
	
	public UsuarioDto(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public UsuarioDto(String user, String password, String nombre, String apellido, String rol) {
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}

	public UsuarioDto(Usuario usuario) {
		this.usuarioId = usuario.getUsuarioId();
		this.user = usuario.getUser();
		this.password = usuario.getPassword();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.rol = usuario.getRol();
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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