package modelo;

public class Producto {
	private String unidad;
	private float precio;
	private int iva;
	private int id;
	
	public Producto(String unidad, float precio, int iva, int id) {
		this.unidad = unidad;
		this.precio = precio;
		this.iva = iva;
		this.id = id;
	}
	
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
