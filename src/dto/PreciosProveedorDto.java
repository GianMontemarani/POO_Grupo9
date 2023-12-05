package dto;

public class PreciosProveedorDto {
	int cuit;
	String razonSocial;
	float precio;
	
	public PreciosProveedorDto(int cuit, String razonSocial, float precio) {
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.precio = precio;
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
	public void setrazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
