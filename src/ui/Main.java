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
		
		//Creo el JFrame
		JFrame frame = new JFrame("Gestion Proveedores");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Panel Login
		JPanel panel = new JPanel(new CardLayout());
		frame.add(panel);
		panel.setLayout(null);

		
		//Usuario label y field
		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(25, 25, 80, 25);
		panel.add(usuario);
		JTextField usuarioTexto = new JTextField(20);
		usuarioTexto.setBounds(100, 20, 165, 25);
		panel.add(usuarioTexto);

		//Contraseña label y field
		JLabel password = new JLabel("Contraseña");
		password.setBounds(10, 50, 80, 25);
		panel.add(password);
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		//Boton login
		JButton botonLogin = new JButton("Entrar");
		botonLogin.setBounds(100, 80, 80, 25);
		panel.add(botonLogin);
		
		
		//Maneja la validacion de credenciales en el LOGIN
		botonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usuarioTexto.getText();
				char[] passwordChars = passwordText.getPassword();
				String password = new String(passwordChars);

				System.out.println("Intento de login:");
				System.out.println("Usuario:" + username + ", Password: " + password);
				
				UsuarioDto user = usuarioController.login(new UsuarioDto(username, password));
				
				if (user != null) {
					System.out.println("Login exitoso");
					try {
						ProveedorController pController = ProveedorController.getInstance();
						ProveedorView pView = new ProveedorView(panel);
						
						panel.removeAll();
						panel.setLayout(null);
						MenuApp menu = new MenuApp();
						JMenuBar menuBar = new JMenuBar();
						
						/* Menu bars */
						menuBar.add(menu.menuProveedor(panel));
						menuBar.add(menu.menuProducto(panel));
						menuBar.add(menu.menuImpuestos(panel));
						menuBar.add(menu.menuDocumentos(panel));
						menuBar.add(menu.menuFunctions(panel));
						
						pView.listar(pController);
						
						frame.setSize(1000, 750);
						frame.setJMenuBar(menuBar);
						frame.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				} else {
					System.out.println("bad");
				}

			}
		});

		frame.setVisible(true);
	}

}
