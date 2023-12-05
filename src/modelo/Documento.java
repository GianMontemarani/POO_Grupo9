package modelo;

import java.util.Date;

public abstract class Documento {
	private int numero;
	private float importe;
	private Date fecha;
	private int proveedorCuit;
	
	protected Documento(float importe, Date fecha, int proveedor) {
		this.importe = importe;
		this.fecha = fecha;
		this.proveedorCuit = proveedor;
	}
	
	protected Documento(int numero, float importe, Date fecha, int proveedor) {
		this.numero = numero;
		this.importe = importe;
		this.fecha = fecha;
		this.proveedorCuit = proveedor;
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

	public void setProveedor(int proveedor) {
		this.proveedorCuit = proveedor;
	}
}