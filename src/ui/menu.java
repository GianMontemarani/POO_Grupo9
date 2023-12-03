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
	private JMenuItem test;
	private JMenuItem test2;
	public JMenu menuLogin(JPanel panel) {
		this.panel = panel;

		menu = new JMenu("Login");

		// Submenú Proveedores

		login loginScreen = new login(panel);
		menu.add(loginScreen.getSubMenu());
		return menu;
	}
	
	public JMenu menuProveedor(JPanel panel) {
		this.panel = panel;

		menu = new JMenu("Proveedor");



		proveedor proveedorScreen = new proveedor(panel);
		menu.add(proveedorScreen.getAgregar());
		menu.add(proveedorScreen.getQuitar());
	
		
		return menu;
	}


}
