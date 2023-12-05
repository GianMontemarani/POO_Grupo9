package modelo;

import java.util.List;
import java.util.Date;

public class OrdenDePago extends Documento{
	private List<Factura> facturas;
	private List<NotaDeDebito> notasDebito;
	private List<NotaDeCredito> notasCredito;
	private float pagoEfectivo;
	private List<Cheque> cheques;
	
	public OrdenDePago(List<Factura> facturas, List<NotaDeDebito> notasDebito,
			List<NotaDeCredito> notasCredito, float pagoEfectivo, List<Cheque> cheques, int numero, float importe, Date fecha, int proveedorCuit) {
		super(numero, importe, fecha, proveedorCuit);
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

	public List<NotaDeDebito> getNotasDebito() {
		return notasDebito;
	}

	public void setNotasDebito(List<NotaDeDebito> notasDebito) {
		this.notasDebito = notasDebito;
	}

	public List<NotaDeCredito> getNotasCredito() {
		return notasCredito;
	}

	public void setNotasCredito(List<NotaDeCredito> notasCredito) {
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