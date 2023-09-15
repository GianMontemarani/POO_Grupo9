package clases;

public abstract class Documento {
	private int numero;
	private float total;
	private Proveedor proveedor;
	
	protected Documento(int numero, float total, Proveedor proveedor) {
		this.numero = numero;
		this.total = total;
		this.proveedor = proveedor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
