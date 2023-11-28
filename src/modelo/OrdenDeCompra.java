package modelo;

import java.util.List;
import java.util.Date;

public class OrdenDeCompra extends Documento{
	private List<ItemDeFactura> items;
	
	public OrdenDeCompra(int numero, float importe, Date fecha, Proveedor proveedor, List<ItemDeFactura> items) {
		super(numero, importe, fecha, proveedor);
		this.items = items;
	}

	public List<ItemDeFactura> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDeFactura> items) {
		this.items = items;
	}
}