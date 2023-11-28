package modelo;

import java.util.Date;

public class NotaDebito extends Documento {
	
	public NotaDebito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}

}