package modelo;

import dto.UsuarioDto;

public class Usuario {
	private int usuarioId;
	private String user;
	private String password;
	private String nombre;
	private String apellido;
	private String rol;
	
	public Usuario(int usuarioId, String user, String password, String nombre, String apellido, String rol) {
		this.usuarioId = usuarioId;
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}
	
	public Usuario(UsuarioDto usuarioDto, int id) {
		this.usuarioId = usuarioDto.getUsuarioId();
		this.user = usuarioDto.getUser();
		this.password = usuarioDto.getPassword();
		this.nombre = usuarioDto.getNombre();
		this.apellido = usuarioDto.getApellido();
		this.rol = usuarioDto.getRol();
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