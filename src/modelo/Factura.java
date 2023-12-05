package modelo;

import java.util.List;

import dto.FacturaDto;

import java.util.Date;

public class Factura extends Documento {
	private OrdenDeCompra ordenCompra;
	private List<ItemDeFactura> productos;
	private List<Impuesto> impuestos;
	private List<OrdenDePago> ordenesDePago;
	private float totalARetener;
	private List<ItemDeFactura> items;

	public Factura(int numero, float importe, Date fecha, int proveedorCuit, OrdenDeCompra ordenCompra,
			List<ItemDeFactura> productos, List<Impuesto> impuestos, List<OrdenDePago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		super(numero, importe, fecha, proveedorCuit);
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenesDePago = ordenDePago;
		this.totalARetener = totalARetener;
		this.items = items;
	}
	
	public Factura(FacturaDto facturaDto, int numero) {
		super(numero, facturaDto.getImporte(), facturaDto.getFecha(), facturaDto.getProveedor());
		this.ordenCompra = facturaDto.getOrdenCompra();
		this.productos = facturaDto.getProductos();
		this.impuestos = facturaDto.getImpuestos();
		this.ordenesDePago = facturaDto.getOrdenDePago();
		this.totalARetener = facturaDto.getTotalARetener();
		this.items = facturaDto.getItems();
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
		return ordenesDePago;
	}

	public void setOrdenDePago(List<OrdenDePago> ordenDePago) {
		this.ordenesDePago = ordenDePago;
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
	
	public float getDeuda() {
		float importe = this.getImporte();
		for(OrdenDePago op: this.ordenesDePago) {
			importe -= op.getImporte();
		}
		return importe;
	}
	
	public Boolean estaPaga() {
		if(this.getDeuda() != 0) {
			return false;
		}else {
			return true;
		}
	}
}