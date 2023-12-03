package ui;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class producto {

	private JMenuItem agregarProducto;
	private JMenuItem quitarProducto;
	private JPanel panel;

	public producto(JPanel panel) {
		this.panel = panel;

		agregarProducto = new JMenuItem("Agregar");
		agregar();

		quitarProducto = new JMenuItem("Quitar");
		quitar();
	}

	private void agregar() {
		/* Configuro la pantalla de agregar */
		agregarProducto.addActionListener(e -> {

			panel.removeAll();
			panel.setLayout(null);
			
			/* Nombre */
			JLabel usuario = new JLabel("Nombre");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Unidad */
			JLabel password = new JLabel("Unidad");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* Precio */
			JLabel nombre = new JLabel("Precio");
			/* (x, y, largo, ancho) */
			nombre.setBounds(10, 80, 80, 25);
			panel.add(nombre);

			JTextField nombreTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			nombreTexto.setBounds(100, 80, 165, 25);
			panel.add(nombreTexto);
			
			/* IVA */
			JLabel telefono = new JLabel("IVA");
			/* (x, y, largo, ancho) */
			telefono.setBounds(10, 110, 80, 25);
			panel.add(telefono);

			JTextField telefonoTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			telefonoTexto.setBounds(100, 110, 165, 25);
			panel.add(telefonoTexto);
			
			/* Actualizo el frame */
			panel.revalidate();
			panel.repaint();
		});
	}
	
	
	private void quitar() {
		/* Configuro la pantalla de agregar */
		agregarProducto.addActionListener(e -> {

			panel.removeAll();
			panel.setLayout(null);
			
			/* Cuit */
			JLabel usuario = new JLabel("Nombre");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Razon social */
			JLabel password = new JLabel("Unidad");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* NOMBRE */
			JLabel nombre = new JLabel("Precio");
			/* (x, y, largo, ancho) */
			nombre.setBounds(10, 80, 80, 25);
			panel.add(nombre);

			JTextField nombreTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			nombreTexto.setBounds(100, 80, 165, 25);
			panel.add(nombreTexto);
			
			/* TELEFONO */
			JLabel telefono = new JLabel("IVA");
			/* (x, y, largo, ancho) */
			telefono.setBounds(10, 110, 80, 25);
			panel.add(telefono);

			JTextField telefonoTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			telefonoTexto.setBounds(100, 110, 165, 25);
			panel.add(telefonoTexto);
			
			/* Actualizo el frame */
			panel.revalidate();
			panel.repaint();
		});
	}
	
	public JMenuItem getAgregar() {
		return agregarProducto;
	}
	public JMenuItem getQuitar() {
		return quitarProducto;
	}
}
