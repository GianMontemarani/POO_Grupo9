package modelo;

import java.util.Date;

public class NotaDeDebito extends Documento {
	
	public NotaDeDebito(int numero, float importe, Date fecha, Proveedor proveedor) {
		super(numero, importe, fecha, proveedor);
	}

}