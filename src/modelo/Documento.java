package modelo;

import java.util.Date;

public abstract class Documento {
	private int numero;
	private float importe;
	private Date fecha;
	private Proveedor proveedor;
	
	protected Documento(int numero, float importe, Date fecha, Proveedor proveedor) {
		this.numero = numero;
		this.importe = importe;
		this.fecha = fecha;
		this.proveedor = proveedor;
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