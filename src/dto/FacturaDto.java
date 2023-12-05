package dto;

import java.util.List;


import modelo.Factura;
import modelo.Impuesto;
import modelo.ItemDeFactura;
import modelo.OrdenDeCompra;
import modelo.OrdenDePago;
import modelo.Proveedor;

import java.util.Date;

public class FacturaDto{
	private int numero;
	private float importe;
	private Date fecha;
	private Proveedor proveedor;
	private OrdenDeCompra ordenCompra;
	private List<ItemDeFactura> productos;
	private List<Impuesto> impuestos;
	private List<OrdenDePago> ordenDePago;
	private float totalARetener;
	private List<ItemDeFactura> items;

	public FacturaDto(float importe, Date fecha, Proveedor proveedor, OrdenDeCompra ordenCompra,
			List<ItemDeFactura> productos, List<Impuesto> impuestos, List<OrdenDePago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		this.importe = importe;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.ordenCompra = ordenCompra;
		this.productos = productos;
		this.impuestos = impuestos;
		this.ordenDePago = ordenDePago;
		this.totalARetener = totalARetener;
		this.items = items;
	}

	public FacturaDto(Factura factura) {
		this.numero= factura.getNumero();
		this.importe = factura.getImporte();
		this.fecha = factura.getFecha();
		this.proveedor =  factura.getProveedor();
		this.ordenCompra = factura.getOrdenCompra();
		this.productos = factura.getProductos();
		this.impuestos = factura.getImpuestos();
		this.ordenDePago = factura.getOrdenDePago();
		this.totalARetener = factura.getTotalARetener();
		this.items = factura.getItems();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	
	public float getDeuda() {
		float importe = this.getImporte();
		for(OrdenDePago op: this.ordenDePago) {
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
