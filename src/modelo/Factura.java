package modelo;

import java.util.List;
import java.util.Date;

public class Factura extends Documento {
	private OrdenDeCompra ordenCompra;
	private List<ItemDeFactura> productos;
	private List<Impuesto> impuestos;
	private List<OrdenDePago> ordenDePago;
	private float totalARetener;
	private List<ItemDeFactura> items;

	public Factura(int numero, float importe, Date fecha, Proveedor proveedor, OrdenDeCompra ordenCompra,
			List<ItemDeFactura> productos, List<Impuesto> impuestos, List<OrdenDePago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		super(numero, importe, fecha, proveedor);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenDePago = ordenDePago;
		this.totalARetener = totalARetener;
		this.items = items;
	}

	public OrdenDeCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenDeCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public List<ItemDeFactura> getProductos() {
		return productos;
	}

	public void setProductos(List<ItemDeFactura> productos) {
		this.productos = productos;
	}

	public List<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public List<OrdenDePago> getOrdenDePago() {
		return ordenDePago;
	}

	public void setOrdenDePago(List<OrdenDePago> ordenDePago) {
		this.ordenDePago = ordenDePago;
	}

	public float getTotalARetener() {
		return totalARetener;
	}

	public void setTotalARetener(float totalARetener) {
		this.totalARetener = totalARetener;
	}

	public List<ItemDeFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemDeFactura> items) {
		this.items = items;
	}
}