package ui;

import javax.swing.JMenu;
import javax.swing.JPanel;

public class MenuApp {
	private JMenu menu;
	
	public JMenu menuProveedor(JPanel panel) {
		menu = new JMenu("Proveedor");

		ProveedorView proveedorScreen = new ProveedorView(panel);
		menu.add(proveedorScreen.getListar());
		menu.add(proveedorScreen.getAgregar());
		

		return menu;
	}
	
	public JMenu menuProducto(JPanel panel) {
		menu = new JMenu("Productos");

		ProductoView productoScreen = new ProductoView(panel);
		menu.add(productoScreen.getListar());
		menu.add(productoScreen.getAgregar());
		

		return menu;
	}
	
	public JMenu menuImpuestos(JPanel panel) {
		menu = new JMenu("Impuestos");

		ImpuestosView impuestosView = new ImpuestosView(panel);
		menu.add(impuestosView.getListar());
		menu.add(impuestosView.getAgregar());

		return menu;
	}
	
	
	public JMenu menuDocumentos(JPanel panel) {
		menu = new JMenu("Documentos");

		DocumentosView documentosScreen = new DocumentosView(panel);
		menu.add(documentosScreen.getFactura());
		menu.add(documentosScreen.getOrdenDeCompra());
		menu.add(documentosScreen.getOrdenDePago());

		return menu;
	}
	
	
	public JMenu menuFunctions(JPanel panel) {
		menu = new JMenu("Funciones");

		FunctionsView functionsView = new FunctionsView(panel);
		menu.add(functionsView.facturasPorDiaProveedor());
		menu.add(functionsView.precioPorProducto());
		menu.add(functionsView.obtenerOrdenesDePago());
		menu.add(functionsView.deudaPorProveedor());
		menu.add(functionsView.ImpuestosRetenidos());
		menu.add(functionsView.LibroIVA());
		menu.add(functionsView.CuentaCorrienteDeProveedores());

		return menu;
	}


}
