package clases;

import java.util.Collection;

public class Factura extends Documento {
	private OrdenCompra ordenCompra;
	private Collection<ItemCompra> productos;
	private float precioUnitario;
	private Collection<TipoImpuesto> impuestos;
	
	public Factura(int numero, float total, Proveedor proveedor, OrdenCompra ordenCompra,
			Collection<ItemCompra> productos, float precioUnitario, Collection<TipoImpuesto> impuestos) {
		super(numero, total, proveedor);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.precioUnitario = precioUnitario;
		this.impuestos = impuestos;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Collection<ItemCompra> getProductos() {
		return productos;
	}

	public void setProductos(Collection<ItemCompra> productos) {
		this.productos = productos;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Collection<TipoImpuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Collection<TipoImpuesto> impuestos) {
		this.impuestos = impuestos;
	}
	
	
}
