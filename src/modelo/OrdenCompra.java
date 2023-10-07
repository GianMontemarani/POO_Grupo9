package modelo;

import java.util.Collection;

public class OrdenCompra extends Documento{
	private Collection<Item> items;
	
	public OrdenCompra(Collection<Item> items, int numero, float total, Proveedor proveedor) {
		super(numero, total, proveedor);
		this.items = items;
	}

	public Collection<Item> getItems() {
		return items;
	}
	
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
}
