package modelo;

import java.util.Date;

public class Cheque {
	private Boolean propio;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private float importe;
	private String firmante;
	
	public Cheque(Boolean propio, Date fechaEmision, Date fechaVencimiento, float importe, String firmante) {
		this.propio = propio;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.importe = importe;
		this.firmante = firmante;
	}

	public Boolean getPropio() {
		return propio;
	}

	public void setPropio(Boolean propio) {
		this.propio = propio;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}
}
