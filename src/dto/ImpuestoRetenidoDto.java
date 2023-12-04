package dto;

import java.util.List;

import modelo.Impuesto;

public class ImpuestoRetenidoDto {
	int idFactura;
	float montoRetenido;
	List<Impuesto> impuestosRetenido;
	
	public ImpuestoRetenidoDto(int idFactura, float montoRetenido, List<Impuesto> impuestosRetenido) {
		this.idFactura = idFactura;
		this.montoRetenido = montoRetenido;
		this.impuestosRetenido = impuestosRetenido;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public float getMontoRetenido() {
		return montoRetenido;
	}

	public void setMontoRetenido(float montoRetenido) {
		this.montoRetenido = montoRetenido;
	}

	public List<Impuesto> getImpuestosRetenido() {
		return impuestosRetenido;
	}

	public void setImpuestosRetenido(List<Impuesto> impuestosRetenido) {
		this.impuestosRetenido = impuestosRetenido;
	}
	
	
}
