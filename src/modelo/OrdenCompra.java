package modelo;

import java.util.Collection;
import java.util.Date;

public class OrdenCompra extends Documento{
	private Collection<Item> items;
	
	public OrdenCompra(int numero, float importe, Date fecha, Proveedor proveedor, Collection<Item> items) {
		super(numero, importe, fecha, proveedor);
		this.items = items;
	}

	public Collection<Item> getItems() {
		return items;
	}
	
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
}