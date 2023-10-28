package modelo;

import java.util.Collection;

public class Factura extends Documento {
	private OrdenCompra ordenCompra;
	private Collection<Item> productos;
	private Collection<TipoImpuesto> impuestos;
	private OrdenPago ordenDePago;
	
	public Factura(int numero, float total, Proveedor proveedor, OrdenCompra ordenCompra,
			Collection<Item> productos, Collection<TipoImpuesto> impuestos, OrdenPago ordenDePago) {
		super(numero, total, proveedor);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenDePago = ordenDePago;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Collection<Item> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Item> productos) {
		this.productos = productos;
	}

	public Collection<TipoImpuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Collection<TipoImpuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public OrdenPago getOrdenDePago() {
		return ordenDePago;
	}

	public void setOrdenDePago(OrdenPago ordenDePago) {
		this.ordenDePago = ordenDePago;
	}
	
	
}
