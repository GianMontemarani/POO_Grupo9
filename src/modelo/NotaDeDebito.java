package modelo;

import java.util.Date;

import dto.NotaDto;

public class NotaDeDebito extends Documento {
	
	public NotaDeDebito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}

	public NotaDeDebito(NotaDto notaDto, int numero) {
		super(numero, notaDto.getImporte(), notaDto.getFecha(), notaDto.getProveedor());
	}	

}