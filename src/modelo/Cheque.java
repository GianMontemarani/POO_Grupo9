package modelo;

import java.util.Date;

public class Cheque extends Documento{
	private Boolean propio;
	private Date fechaVencimiento;
	private String firmante;
	
	public Cheque(int numero, float importe, Date fecha, Proveedor proveedor, Boolean propio, Date fechaVencimiento,
			String firmante) {
		super(numero, importe, fecha, proveedor);
		this.propio = propio;
		this.fechaVencimiento = fechaVencimiento;
		this.firmante = firmante;
	}

	public Boolean getPropio() {
		return propio;
	}

	public void setPropio(Boolean propio) {
		this.propio = propio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getString() {
		return firmante;
	}

	public void setString(String firmante) {
		this.firmante = firmante;
	}	
}