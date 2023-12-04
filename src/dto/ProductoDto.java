package dto;

import modelo.Producto;

public class ProductoDto {
	private String unidad;
	private float precio;
	private int iva;
	private String nombre;
	private int id;
	
	public ProductoDto(int id,String unidad, float precio, int iva, String nombre) {
		this.id = id;
		this.unidad = unidad;
		this.precio = precio;
		this.iva = iva;
		this.nombre = nombre;
	}
	
	public ProductoDto(Producto producto) {
		this.id = producto.getId();
		this.unidad = producto.getUnidad();
		this.precio = producto.getPrecio();
		this.iva = producto.getIva();
		this.nombre = producto.getNombre();
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + "; Precio: " + this.getPrecio() + "; %IVA: " + this.getIva() + "; Unidad: " + this.getUnidad();
	}
}
