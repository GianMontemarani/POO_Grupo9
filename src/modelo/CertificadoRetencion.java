package modelo;

import java.sql.Date;

public class CertificadoRetencion {
	private Date fechaInicio;
	private Date fechaVencimiento;
	private Boolean activo;
	private TipoImpuesto impuesto;
	
	public CertificadoRetencion(Date fechaInicio, Date fechaVencimiento, Boolean activo, TipoImpuesto impuesto) {
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.activo = activo;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public TipoImpuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(TipoImpuesto impuesto) {
		this.impuesto = impuesto;
	}

}
