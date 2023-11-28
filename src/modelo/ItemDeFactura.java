package modelo;

public class ItemDeFactura {
	private int cantidad;
	private Producto producto;
	private float importe;
	private Impuesto impuesto;

	public ItemDeFactura(int cantidad, Producto producto, float importe, Impuesto impuesto) {
		this.cantidad = cantidad;
		this.producto = producto;
		this.importe = importe;
		this.impuesto = impuesto;
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

	public Impuesto getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}
}