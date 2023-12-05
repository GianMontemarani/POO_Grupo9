package modelo;

import java.util.Date;

public class CertificadoRetencion {
	private Date fechaInicio;
	private Date fechaVencimiento;
	private Impuesto impuesto;
	
	public CertificadoRetencion(Date fechaInicio, Date fechaVencimiento, Impuesto impuesto) {
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.impuesto = impuesto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}
	
	public boolean isActive() {
		Date now = new Date();
		if(now.after(this.fechaVencimiento)) {
			return false;
		}else {
			return true;
		}
	}
}