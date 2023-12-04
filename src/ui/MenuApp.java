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
		menu.add(productoScreen.getAgregar());
		menu.add(productoScreen.getListar());

		return menu;
	}
	
	public JMenu menuFunctions(JPanel panel) {
		menu = new JMenu("Funciones");

		FunctionsView functionsView = new FunctionsView(panel);
		menu.add(functionsView.FacturasPorDiaProveedor());
		menu.add(functionsView.precioPorProducto());
		menu.add(functionsView.ObtenerOrdenesDePago());
		menu.add(functionsView.DeudaPorProveedor());
		menu.add(functionsView.ImpuestosRetenidos());
		menu.add(functionsView.LibroIVA());
		menu.add(functionsView.CuentaCorrienteDeProveedores());

		return menu;
	}

}
