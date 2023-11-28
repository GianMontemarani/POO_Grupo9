package modelo;

import java.util.Collection;
import java.util.Date;

public class Factura extends Documento {
	private OrdenCompra ordenCompra;
	private Collection<Item> productos;
	private Collection<Impuesto> impuestos;
	private Collection<OrdenPago> ordenDePago;
	private float totalARetener;
	
	public Factura(int numero, float importe, Date fecha, Proveedor proveedor, OrdenCompra ordenCompra,
			Collection<Item> productos, Collection<Impuesto> impuestos, Collection<OrdenPago> ordenDePago,
			float totalARetener) {
		super(numero, importe, fecha, proveedor);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenDePago = ordenDePago;
		this.totalARetener = totalARetener;
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

	public Collection<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Collection<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public Collection<OrdenPago> getOrdenDePago() {
		return ordenDePago;
	}

	public void setOrdenDePago(Collection<OrdenPago> ordenDePago) {
		this.ordenDePago = ordenDePago;
	}

	public float getTotalARetener() {
		return totalARetener;
	}

	public void setTotalARetener(float totalARetener) {
		this.totalARetener = totalARetener;
	}	
}