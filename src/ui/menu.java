package ui;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class menu {
	private JMenu menu;
	private JPanel panel;
	
	public JMenu menuProveedor(JPanel panel) {
		this.panel = panel;

		menu = new JMenu("Proveedor");



		proveedor proveedorScreen = new proveedor(panel);
		menu.add(proveedorScreen.getAgregar());
		menu.add(proveedorScreen.getQuitar());
	
		
		return menu;
	}
	
	
	public JMenu menuProducto(JPanel panel) {
		this.panel = panel;

		menu = new JMenu("Producto");



		producto productoScreen = new producto(panel);
		menu.add(productoScreen.getAgregar());
		menu.add(productoScreen.getQuitar());
	
		
		return menu;
	}


}
