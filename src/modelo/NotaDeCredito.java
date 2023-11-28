package modelo;

import java.util.Date;

public class NotaDeCredito extends Documento {
	
	public NotaDeCredito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}	
}