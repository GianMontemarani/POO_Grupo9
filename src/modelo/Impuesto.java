package modelo;

import dto.ImpuestoDto;

public class Impuesto {
	private int id;
	private String nombre;
	private float porcentaje;
	private TipoImpuesto tipoImpuesto;
	
	public Impuesto(int id, String nombre, float porcentaje, TipoImpuesto tipoImpuesto) {
		this.id = id;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.tipoImpuesto = tipoImpuesto;
	}
	
	public Impuesto(ImpuestoDto impuestoDto, int id) {
		this.id = id;
		this.nombre = impuestoDto.getNombre();
		this.porcentaje = impuestoDto.getPorcentaje();
		this.tipoImpuesto = impuestoDto.getTipoImpuesto();
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