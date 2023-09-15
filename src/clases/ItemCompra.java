package clases;

public class ItemCompra {
	private int cantidad;
	private Producto producto;
	private float importe;
	
	public ItemCompra(int cantidad, Producto producto, float importe) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.importe = importe;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
}
