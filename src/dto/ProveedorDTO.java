package dto;

import java.util.Date;
import java.util.List;

import modelo.Rubro;

public class ProveedorDTO {
	private int cuit;
	private String razonSocial;
	private String nombre;
	private int telefono;
	private String correoElectronico;
	private Date inicioActividades;
	private List<Rubro> rubros;
	private float maxDeuda;
	private String calle;
	private int altura;
	private int codigoPostal;
	private String pais;
	private String provincia;
	private String ciudad;
	
	public ProveedorDTO(int cuit, String razonSocial, String nombre, int telefono, String correoElectronico,
			Date inicioActividades, List<Rubro> rubros, float maxDeuda, String calle, int altura, int codigoPostal,
			String pais, String provincia, String ciudad) {
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.inicioActividades = inicioActividades;
		this.rubros = rubros;
		this.maxDeuda = maxDeuda;
		this.calle = calle;
		this.altura = altura;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getInicioActividades() {
		return inicioActividades;
	}

	public void setInicioActividades(Date inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}

	public float getMaxDeuda() {
		return maxDeuda;
	}

	public void setMaxDeuda(float maxDeuda) {
		this.maxDeuda = maxDeuda;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
