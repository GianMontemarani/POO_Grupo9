package dto;

import java.util.Date;

import modelo.Cheque;

public class ChequeDto {
	private int numero;
	private float importe;
	private Date fecha;
	private int proveedorCuit;
	private Boolean tipoPropio;
	private Date fechaVencimientoDate;
	private String firmante;
	
	public ChequeDto(int numero, float importe, Date fecha, int proveedorCuit, Boolean tipoPropio,
			Date fechaVencimientoDate, String firmante) {
		this.numero = numero;
		this.importe = importe;
		this.fecha = fecha;
		this.proveedorCuit = proveedorCuit;
		this.tipoPropio = tipoPropio;
		this.fechaVencimientoDate = fechaVencimientoDate;
		this.firmante = firmante;
	}

	public ChequeDto(Cheque cheque) {
		this.numero = cheque.getNumero();
		this.importe = cheque.getImporte();
		this.fecha = cheque.getFecha();
		this.proveedorCuit = cheque.getProveedor();
		this.tipoPropio = cheque.getPropio();
		this.fechaVencimientoDate = cheque.getFechaVencimiento();
		this.firmante = cheque.getFirmante();
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

	public void setProveedor(int proveedorCuit) {
		this.proveedorCuit = proveedorCuit;
	}

	public Boolean getTipoPropio() {
		return tipoPropio;
	}

	public void setTipoPropio(Boolean tipoPropio) {
		this.tipoPropio = tipoPropio;
	}

	public Date getFechaVencimientoDate() {
		return fechaVencimientoDate;
	}

	public void setFechaVencimientoDate(Date fechaVencimientoDate) {
		this.fechaVencimientoDate = fechaVencimientoDate;
	}

	public String getFirmante() {
		return firmante;
	}

	public void setFirmante(String firmante) {
		this.firmante = firmante;
	}
}
