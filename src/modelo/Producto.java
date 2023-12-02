package modelo;

import dto.ProductoDto;

public class Producto {
	private String unidad;
	private float precio;
	private int iva;
	private int id;
	private String nombre;
	
	public Producto(String unidad, float precio, int iva, int id, String nombre) {
		this.unidad = unidad;
		this.precio = precio;
		this.iva = iva;
		this.id = id;
		this.nombre = nombre;
	}
	
	public Producto(ProductoDto productoDto, int id) {
		this.unidad = productoDto.getUnidad();
		this.precio = productoDto.getPrecio();
		this.iva = productoDto.getIva();
		this.nombre = productoDto.getNombre();
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}