package modelo;

import java.util.List;

import dto.OrdenDeCompraDto;

import java.util.Date;

public class OrdenDeCompra extends Documento{
	private List<ItemDeCompra> items;
	
	public OrdenDeCompra(int numero, Date fecha, int proveedorCuit, List<ItemDeCompra> items) {
		super(numero,calcularImporte(items), fecha, proveedorCuit);
		this.items = items;
	}

	public OrdenDeCompra(OrdenDeCompraDto ordenDeCompraDto, int id) {
		super(id, calcularImporte(ordenDeCompraDto.getItems()), ordenDeCompraDto.getFecha(), ordenDeCompraDto.getProveedor());
		this.items = ordenDeCompraDto.getItems();
	}

	public List<ItemDeCompra> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDeCompra> items) {
		this.items = items;
	}
	
	public static float calcularImporte(List<ItemDeCompra> items) {
		float importe = 0;
		for(ItemDeCompra i: items) {
			importe += i.getImporte();
		}
		return importe;
	}
}