package dto;

import java.util.Date;
import java.util.List;

import modelo.Impuesto;
import modelo.ItemDeFactura;
import modelo.NotaDeCredito;
import modelo.NotaDeDebito;
import modelo.OrdenDeCompra;
import modelo.OrdenDePago;

public class NotaDto {
	private int numero;
	private float importe;
	private Date fecha;
	private int proveedorCuit;

	public NotaDto(float importe, Date fecha, int proveedorCuit, OrdenDeCompra ordenCompra,
			List<ItemDeFactura> productos, List<Impuesto> impuestos, List<OrdenDePago> ordenDePago,
			float totalARetener, List<ItemDeFactura> items) {
		this.importe = importe;
		this.fecha = fecha;
		this.proveedorCuit = proveedorCuit;
	}

	public NotaDto(NotaDeCredito notaDeCredito) {
		this.numero= notaDeCredito.getNumero();
		this.importe = notaDeCredito.getImporte();
		this.fecha = notaDeCredito.getFecha();
		this.proveedorCuit =  notaDeCredito.getProveedor();
	}
	
	public NotaDto(NotaDeDebito notaDeCredito) {
		this.numero= notaDeCredito.getNumero();
		this.importe = notaDeCredito.getImporte();
		this.fecha = notaDeCredito.getFecha();
		this.proveedorCuit =  notaDeCredito.getProveedor();
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

	public int getProveedor() {
		return proveedorCuit;
	}

	public void setProveedor(int proveedorCuit) {
		this.proveedorCuit = proveedorCuit;
	}
}
