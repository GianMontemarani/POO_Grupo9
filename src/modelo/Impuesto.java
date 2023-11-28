package modelo;

public class Impuesto {
	private String nombre;
	private float porcentaje;
	private TipoImpuesto tipoImpuesto;
	public Impuesto(String nombre, float porcentaje, TipoImpuesto tipoImpuesto) {
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.tipoImpuesto = tipoImpuesto;
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