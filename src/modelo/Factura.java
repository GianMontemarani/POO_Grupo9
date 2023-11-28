package modelo;

import java.util.List;
import java.util.Date;

public class Factura extends Documento {
	private OrdenCompra ordenCompra;
	private List<Item> productos;
	private List<Impuesto> impuestos;
	private List<OrdenPago> ordenDePago;
	private float totalARetener;
	private List<ItemDeFactura> items;

	public Factura(int numero, float importe, Date fecha, Proveedor proveedor, OrdenCompra ordenCompra,
			List<Item> productos, List<Impuesto> impuestos, List<OrdenPago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		super(numero, importe, fecha, proveedor);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenDePago = ordenDePago;
		this.totalARetener = totalARetener;
		this.items = items;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public List<Item> getProductos() {
		return productos;
	}

	public void setProductos(List<Item> productos) {
		this.productos = productos;
	}

	public List<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(List<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public List<OrdenPago> getOrdenDePago() {
		return ordenDePago;
	}

	public void setOrdenDePago(List<OrdenPago> ordenDePago) {
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