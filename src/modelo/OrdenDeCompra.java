package modelo;

import java.util.List;

import dto.OrdenDeCompraDto;

import java.util.Date;

public class OrdenDeCompra extends Documento{
	private List<ItemDeCompra> items;
	
	public OrdenDeCompra(int numero, float importe, Date fecha, Proveedor proveedor, List<ItemDeCompra> items) {
		super(numero, importe, fecha, proveedor);
		this.items = items;
	}

	public OrdenDeCompra(OrdenDeCompraDto ordenDeCompraDto, int id) {
		super(id, ordenDeCompraDto.getImporte(), ordenDeCompraDto.getFecha(), ordenDeCompraDto.getProveedor());
		this.items = ordenDeCompraDto.getItems();
	}

	public List<ItemDeCompra> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDeCompra> items) {
		this.items = items;
	}
}