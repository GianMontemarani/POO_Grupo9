package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class proveedor {

	private JMenuItem agregarProveedor;
	private JMenuItem quitarProveedor;
	private JPanel panel;

	public proveedor(JPanel panel) {
		this.panel = panel;

		agregarProveedor = new JMenuItem("Agregar");
		agregar();

		quitarProveedor = new JMenuItem("Quitar");
		quitar();
	}

	private void agregar() {
		// Configuración del submenú, como agregar acciones, etc.
		agregarProveedor.addActionListener(e -> {
			// Agregar la tabla al panel principal al hacer clic en el submenú
			panel.removeAll(); // Limpiar el panel antes de agregar la tabla

			panel.setLayout(null);

			/* Usuarios */
			JLabel usuario = new JLabel("agregar");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Contraseña */
			JLabel password = new JLabel("Contraseña");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* boton que triggerea el revisar user y pw */
			JButton botonLogin = new JButton("entrar");
			/* (x, y, largo, ancho) */
			botonLogin.setBounds(100, 80, 80, 25);
			panel.add(botonLogin);

			panel.revalidate(); // Actualizar la interfaz
			panel.repaint();
		});
	}

	private void quitar() {
		// Configuración del submenú, como agregar acciones, etc.
		quitarProveedor.addActionListener(e -> {
			// Agregar la tabla al panel principal al hacer clic en el submenú
			panel.removeAll(); // Limpiar el panel antes de agregar la tabla

			panel.setLayout(null);

			/* Usuarios */
			JLabel usuario = new JLabel("quitar");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Contraseña */
			JLabel password = new JLabel("Contraseña");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* boton que triggerea el revisar user y pw */
			JButton botonLogin = new JButton("entrar");
			/* (x, y, largo, ancho) */
			botonLogin.setBounds(100, 80, 80, 25);
			panel.add(botonLogin);

			panel.revalidate(); // Actualizar la interfaz
			panel.repaint();
		});
	}

	public JMenuItem getAgregar() {
		return agregarProveedor;
	}

	public JMenuItem getQuitar() {
		return quitarProveedor;
	}

}