package modelo;

public class Direccion {
	private String calle;
	private int altura;
	private int codigoPostal;
	private String pais;
	private String provincia;
	private String ciudad;
	
	public Direccion(String calle, int altura, int codigoPostal, String pais, String provincia, String ciudad) {
		this.calle = calle;
		this.altura = altura;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.provincia = provincia;
		this.ciudad = ciudad;
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
