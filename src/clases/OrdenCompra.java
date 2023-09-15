package clases;

import java.util.Collection;

public class OrdenCompra {
	private Collection<ItemCompra> items;
	private int numero;
	private Proveedor proveedor;
	private float total;
	
	public OrdenCompra(Collection<ItemCompra> items, int numero, Proveedor proveedor, float total) {
		this.items = items;
		this.numero = numero;
		this.proveedor = proveedor;
		this.total = total;
	}

	public Collection<ItemCompra> getItems() {
		return items;
	}

	public void setItems(Collection<ItemCompra> items) {
		this.items = items;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
