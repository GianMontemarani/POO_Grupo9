package ui;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FunctionsView {
	private JMenuItem FacturasPorDiaProveedor;
	private JMenuItem precioPorProducto;
	private JMenuItem ObtenerOrdenesDePago;
	private JMenuItem DeudaPorProveedor;
	private JMenuItem ImpuestosRetenidos;
	private JMenuItem LibroIVA;
	private JMenuItem CuentaCorrienteDeProveedores;
	
	private JPanel panel;
	
	public FunctionsView(JPanel panel) {
		this.panel = panel;

		FacturasPorDiaProveedor = new JMenuItem("Facturas Por Dia Proveedor");
		precioPorProducto = new JMenuItem("Precio Por Producto");
		ObtenerOrdenesDePago = new JMenuItem("Obtener Ordenes De Pago");
		DeudaPorProveedor = new JMenuItem("Deuda Por Proveedor");
		ImpuestosRetenidos = new JMenuItem("Impuestos Retenidos");
		LibroIVA = new JMenuItem("Libro IVA");
		CuentaCorrienteDeProveedores = new JMenuItem("Cuenta Corriente De Proveedores");
		
	}
	public JMenuItem FacturasPorDiaProveedor() {
		return FacturasPorDiaProveedor;
	}
	public JMenuItem precioPorProducto() {
		return precioPorProducto;
	}
	public JMenuItem ObtenerOrdenesDePago() {
		return ObtenerOrdenesDePago;
	}
	public JMenuItem DeudaPorProveedor() {
		return DeudaPorProveedor;
	}
	public JMenuItem ImpuestosRetenidos() {
		return ImpuestosRetenidos;
	}
	public JMenuItem LibroIVA() {
		return LibroIVA;
	}
	public JMenuItem CuentaCorrienteDeProveedores() {
		return CuentaCorrienteDeProveedores;
	}
}
