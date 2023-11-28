package modelo;

import java.util.Date;

public class NotaCredito extends Documento {
	
	public NotaCredito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}	
}