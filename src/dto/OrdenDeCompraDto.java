package dto;

import java.util.Date;
import java.util.List;

import modelo.ItemDeCompra;
import modelo.OrdenDeCompra;
import modelo.Proveedor;

public class OrdenDeCompraDto {
	private int numero;
	private float importe;
	private Date fecha;
	private Proveedor proveedor;
	private List<ItemDeCompra> items;
	
	public OrdenDeCompraDto(int numero, float importe, Date fecha, Proveedor proveedor, List<ItemDeCompra> items) {
		this.numero = numero;
		this.importe = importe;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.items = items;
	}

	public OrdenDeCompraDto(OrdenDeCompra ordenDeCompra) {
		this.numero = ordenDeCompra.getNumero();
		this.importe = ordenDeCompra.getImporte();
		this.fecha = ordenDeCompra.getFecha();
		this.proveedor = ordenDeCompra.getProveedor();
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<ItemDeCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemDeCompra> items) {
		this.items = items;
	}
}
