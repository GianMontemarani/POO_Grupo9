package modelo;

import java.util.Date;

public class CertificadoRetencion {
	private Date fechaInicio;
	private Date fechaVencimiento;
	private TipoImpuesto impuesto;
	
	public CertificadoRetencion(Date fechaInicio, Date fechaVencimiento, TipoImpuesto impuesto) {
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


	public TipoImpuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(TipoImpuesto impuesto) {
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
 
  	@Override
	public String toString() {
		return "fechaInicio: "+fechaInicio+"fechaVencimiento: "+fechaVencimiento+"activo: "+"impuesto: "+impuesto;
  	}
}
