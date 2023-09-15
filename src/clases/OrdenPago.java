package clases;

import java.util.Collection;

public class OrdenPago {
	private Collection<Factura> facturas;
	private Collection<NotaDebito> notasDebitos;
	private Collection<NotaCredito> notasCreditos;
	private float total;
	private float pagoEfectivo;
	private Collection<Cheque> cheques;
	
	public OrdenPago(Collection<Factura> facturas, Collection<NotaDebito> notasDebitos,
			Collection<NotaCredito> notasCreditos, float total, float pagoEfectivo, Collection<Cheque> cheques) {
		this.facturas = facturas;
		this.notasDebitos = notasDebitos;
		this.notasCreditos = notasCreditos;
		this.total = total;
		this.pagoEfectivo = pagoEfectivo;
		this.cheques = cheques;
	}

	public Collection<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
	}

	public Collection<NotaDebito> getNotasDebitos() {
		return notasDebitos;
	}

	public void setNotasDebitos(Collection<NotaDebito> notasDebitos) {
		this.notasDebitos = notasDebitos;
	}

	public Collection<NotaCredito> getNotasCreditos() {
		return notasCreditos;
	}

	public void setNotasCreditos(Collection<NotaCredito> notasCreditos) {
		this.notasCreditos = notasCreditos;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getPagoEfectivo() {
		return pagoEfectivo;
	}

	public void setPagoEfectivo(float pagoEfectivo) {
		this.pagoEfectivo = pagoEfectivo;
	}

	public Collection<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(Collection<Cheque> cheques) {
		this.cheques = cheques;
	}
}
