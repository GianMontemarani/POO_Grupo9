package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class login {

	
	private JPanel panel;
	
	

	public login(JPanel panel) {
		this.panel = panel;

		loginUI();

	}

	private void loginUI() {
		// Configuración del submenú, como agregar acciones, etc.

			// Agregar la tabla al panel principal al hacer clic en el submenú
			panel.removeAll(); // Limpiar el panel antes de agregar la tabla
			
			
			panel.setLayout(null);
			
			/* Usuarios */
			JLabel usuario = new JLabel("Usuario");
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
			
			

	}

	public JPanel getSubMenu() {
		return panel;
	}

}