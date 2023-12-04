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
		menu = new JMenu("Producto");

		ProductoView productoScreen = new ProductoView(panel);
		menu.add(productoScreen.getAgregar());
		menu.add(productoScreen.getQuitar());

		return menu;
	}

}
