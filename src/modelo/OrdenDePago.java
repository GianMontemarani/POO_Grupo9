package modelo;

import java.util.List;
import java.util.Date;

public class OrdenDePago {
	private List<Factura> facturas;
	private List<NotaDebito> notasDebito;
	private List<NotaCredito> notasCredito;
	private float pagoEfectivo;
	private List<Cheque> cheques;
	
	public OrdenDePago(List<Factura> facturas, List<NotaDebito> notasDebito,
			List<NotaCredito> notasCredito, float pagoEfectivo, List<Cheque> cheques, int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
		this.facturas = facturas;
		this.notasDebito = notasDebito;
		this.notasCredito = notasCredito;
		this.pagoEfectivo = pagoEfectivo;
		this.cheques = cheques;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<NotaDebito> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<NotaDebito> notasDebito) {
		this.notasDebito = notasDebito;
	}

	public List<NotaCredito> getNotasCredito() {
		return notasCredito;
	}

	public void setNotasCredito(List<NotaCredito> notasCredito) {
		this.notasCredito = notasCredito;
	}
	
	public float getPagoEfectivo() {
		return pagoEfectivo;
	}

	public void setPagoEfectivo(float pagoEfectivo) {
		this.pagoEfectivo = pagoEfectivo;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
}