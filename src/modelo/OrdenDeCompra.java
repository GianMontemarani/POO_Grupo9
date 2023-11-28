package modelo;

import java.util.List;
import java.util.Date;

public class OrdenCompra extends Documento{
	private List<Item> items;
	
	public OrdenCompra(int numero, float importe, Date fecha, Proveedor proveedor, List<Item> items) {
		super(numero, importe, fecha, proveedor);
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}