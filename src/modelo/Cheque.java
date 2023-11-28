package modelo;

import java.util.Date;

public class Cheque extends Documento{
	private Boolean propio;
	private Date vencimiento;
	private String firmante;
	
	public Cheque(int numero, float importe, Date fecha, Proveedor proveedor, Boolean propio, Date vencimiento,
			String firmante) {
		super(numero, importe, fecha, proveedor);
		this.propio = propio;
		this.vencimiento = vencimiento;
		this.firmante = firmante;
	}

	public Boolean getPropio() {
		return propio;
	}

	public void setPropio(Boolean propio) {
		this.propio = propio;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getString() {
		return firmante;
	}

	public void setString(String firmante) {
		this.firmante = firmante;
	}	
}