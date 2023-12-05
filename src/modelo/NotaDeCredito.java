package modelo;

import java.util.Date;

import dto.NotaDto;

public class NotaDeCredito extends Documento {
	
	public NotaDeCredito(int numero, float importe, Date fecha, int proveedorCuit) {
		super(numero, importe, fecha, proveedorCuit);
	}

	public NotaDeCredito(NotaDto notaDto, int numero) {
		super(numero, notaDto.getImporte(), notaDto.getFecha(), notaDto.getProveedor());
	}	
}