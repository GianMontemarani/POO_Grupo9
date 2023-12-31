package modelo;

import java.util.Date;

import dto.NotaDto;

public class NotaDeDebito extends Documento {
	
	public NotaDeDebito(int numero, float importe, Date fecha, int proveedorCuit) {
		super(numero, importe, fecha, proveedorCuit);
	}

	public NotaDeDebito(NotaDto notaDto, int numero) {
		super(numero, notaDto.getImporte(), notaDto.getFecha(), notaDto.getProveedor());
	}	

}