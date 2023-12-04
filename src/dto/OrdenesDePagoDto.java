package dto;

import java.util.List;

import modelo.OrdenDePago;

public class OrdenesDePagoDto {
	int idFactura;
	List<OrdenDePago> ordenesDeLaFactura;
	
	public OrdenesDePagoDto(int idFactura, List<OrdenDePago> ordenesDeLaFactura) {
		this.idFactura = idFactura;
		this.ordenesDeLaFactura = ordenesDeLaFactura;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public List<OrdenDePago> getOrdenesDeLaFactura() {
		return ordenesDeLaFactura;
	}

	public void setOrdenesDeLaFactura(List<OrdenDePago> ordenesDeLaFactura) {
		this.ordenesDeLaFactura = ordenesDeLaFactura;
	}
	
	
	
}
