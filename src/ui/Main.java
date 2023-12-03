package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controladores.ProveedorController;
import controladores.UsuarioController;
import dto.UsuarioDto;

public class Main {
	public static void main(String[] args) throws Exception {
		UsuarioController usuarioController = UsuarioController.getInstance();
		
		// Creo el JFrame
		JFrame frame = new JFrame("Programa");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Creo un """"Div"""" */
		JPanel panel = new JPanel(new CardLayout());
		frame.add(panel);

		/* login logUI = new login(panel); */

		// Configuración del submenú, como agregar acciones, etc.

		// Agregar la tabla al panel principal al hacer clic en el submenú

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
		botonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usuarioTexto.getText();
				char[] passwordChars = passwordText.getPassword();
				String password = new String(passwordChars);

				System.out.println(username + " " + password);
				
				UsuarioDto user = usuarioController.login(new UsuarioDto(username, password));
				
				if (user != null) {
					System.out.println("good");
					panel.removeAll(); 
					panel.setLayout(null);
					menu menus = new menu();
					JMenuBar menuBar = new JMenuBar();
					menuBar.add(menus.menuLogin(panel));
					menuBar.add(menus.menuProveedor(panel));

					frame.setJMenuBar(menuBar);
					frame.setVisible(true);
				} else {
					System.out.println("bad");
				}

			}
		});

		frame.setVisible(true);
	}

}
