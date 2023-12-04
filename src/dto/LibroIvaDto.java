package dto;

import java.util.Date;

public class LibroIvaDto {
	int cuit;
	String nombre;
	Date fecha;
	float porcentaje;
	float total;
	
	public LibroIvaDto(int cuit, String nombre, Date fecha, float porcentaje, float total) {
		this.cuit = cuit;
		this.nombre = nombre;
		this.fecha = fecha;
		this.porcentaje = porcentaje;
		this.total = total;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
