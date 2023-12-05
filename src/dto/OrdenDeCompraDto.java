package dto;

import java.util.Date;
import java.util.List;

import modelo.ItemDeCompra;
import modelo.OrdenDeCompra;

public class OrdenDeCompraDto {
	private int numero;
	private float importe;
	private Date fecha;
	private int proveedorCuit;
	private List<ItemDeCompra> items;
	
	public OrdenDeCompraDto(int numero, float importe, Date fecha, int proveedorCuit, List<ItemDeCompra> items) {
		this.numero = numero;
		this.importe = importe;
		this.fecha = fecha;
		this.proveedorCuit = proveedorCuit;
		this.items = items;
	}

	public OrdenDeCompraDto(OrdenDeCompra ordenDeCompra) {
		this.numero = ordenDeCompra.getNumero();
		this.importe = ordenDeCompra.getImporte();
		this.fecha = ordenDeCompra.getFecha();
		this.proveedorCuit = ordenDeCompra.getProveedor();
		this.items = ordenDeCompra.getItems();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getProveedor() {
		return proveedorCuit;
	}

	public void setProveedor(int proveedorCuit) {
		this.proveedorCuit = proveedorCuit;
	}

	public List<ItemDeCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemDeCompra> items) {
		this.items = items;
	}
}
