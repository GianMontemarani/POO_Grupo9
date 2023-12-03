package modelo;

import java.util.Date;

import dto.NotaDto;

public class NotaDeCredito extends Documento {
	
	public NotaDeCredito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}

	public NotaDeCredito(NotaDto notaDto, int numero) {
		super(numero, notaDto.getImporte(), notaDto.getFecha(), notaDto.getProveedor());
	}	
}