package modelo;

import java.util.Date;

import dto.ChequeDto;

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

	public Cheque(ChequeDto chequeDto, int id) {
		super(id, chequeDto.getImporte(), chequeDto.getFecha(), chequeDto.getProveedor());
		this.propio = chequeDto.getTipoPropio();
		this.fechaVencimiento = chequeDto.getFecha();
		this.firmante = chequeDto.getFirmante();
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

	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}
}