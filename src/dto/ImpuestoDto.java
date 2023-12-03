package dto;

import modelo.Impuesto;
import modelo.TipoImpuesto;

public class ImpuestoDto {
	private int id;
	private String nombre;
	private float porcentaje;
	private TipoImpuesto tipoImpuesto;
	
	public ImpuestoDto(String nombre, float porcentaje, TipoImpuesto tipoImpuesto) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.tipoImpuesto = tipoImpuesto;
	}

	public ImpuestoDto(Impuesto impuesto) {
		this.id = impuesto.getId();
		this.nombre = impuesto.getNombre();
		this.porcentaje = impuesto.getPorcentaje();
		this.tipoImpuesto = impuesto.getTipoImpuesto();
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
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	public TipoImpuesto getTipoImpuesto() {
		return tipoImpuesto;
	}
	public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}	
}
