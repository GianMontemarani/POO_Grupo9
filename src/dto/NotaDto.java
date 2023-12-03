package dto;

import java.util.Date;
import java.util.List;

import modelo.Impuesto;
import modelo.ItemDeFactura;
import modelo.NotaDeCredito;
import modelo.NotaDeDebito;
import modelo.OrdenDeCompra;
import modelo.OrdenDePago;
import modelo.Proveedor;

public class NotaDto {
	private int numero;
	private float importe;
	private Date fecha;
	private Proveedor proveedor;

	public NotaDto(float importe, Date fecha, Proveedor proveedor, OrdenDeCompra ordenCompra,
			List<ItemDeFactura> productos, List<Impuesto> impuestos, List<OrdenDePago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		this.importe = importe;
		this.fecha = fecha;
		this.proveedor = proveedor;
	}

	public NotaDto(NotaDeCredito notaDeCredito) {
		this.numero= notaDeCredito.getNumero();
		this.importe = notaDeCredito.getImporte();
		this.fecha = notaDeCredito.getFecha();
		this.proveedor =  notaDeCredito.getProveedor();
	}
	
	public NotaDto(NotaDeDebito notaDeCredito) {
		this.numero= notaDeCredito.getNumero();
		this.importe = notaDeCredito.getImporte();
		this.fecha = notaDeCredito.getFecha();
		this.proveedor =  notaDeCredito.getProveedor();
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
}
