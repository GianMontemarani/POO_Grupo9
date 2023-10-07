package modelo;

import java.util.Collection;

public class CuentaCorriente {
	private int numero;
	private Collection<Factura> facturas;
	private Collection<NotaDebito> notasDebitos;
	private Collection<NotaCredito> notasCreditos;
	
	public CuentaCorriente(int numero, Collection<Factura> facturas, Collection<NotaDebito> notasDebitos,
			Collection<NotaCredito> notasCreditos) {
		this.numero = numero;
		this.facturas = facturas;
		this.notasDebitos = notasDebitos;
		this.notasCreditos = notasCreditos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
	
	
	
}
