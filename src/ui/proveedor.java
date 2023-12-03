package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
		/* Configuro la pantalla de agregar */
		agregarProveedor.addActionListener(e -> {

			panel.removeAll();
			panel.setLayout(null);

			/* Cuit */
			JLabel usuario = new JLabel("Cuit");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Razon social */
			JLabel password = new JLabel("Razon social");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* NOMBRE */
			JLabel nombre = new JLabel("Nombre");
			/* (x, y, largo, ancho) */
			nombre.setBounds(10, 80, 80, 25);
			panel.add(nombre);

			JTextField nombreTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			nombreTexto.setBounds(100, 80, 165, 25);
			panel.add(nombreTexto);
			

			/* TELEFONO */
			JLabel telefono = new JLabel("Teléfono");
			/* (x, y, largo, ancho) */
			telefono.setBounds(10, 110, 80, 25);
			panel.add(telefono);

			JTextField telefonoTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			telefonoTexto.setBounds(100, 110, 165, 25);
			panel.add(telefonoTexto);
			

			/* CORREO ELECTRONICO */
			JLabel correo = new JLabel("Correo");
			/* (x, y, largo, ancho) */
			correo.setBounds(10, 140, 120, 25);
			panel.add(correo);

			JTextField correoTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			correoTexto.setBounds(140, 140, 165, 25);
			panel.add(correoTexto);
			

			/* INICIO DE ACTIVIDAD */
			JLabel inicioActividad = new JLabel("Inicio de Actividad");
			/* (x, y, largo, ancho) */
			inicioActividad.setBounds(10, 170, 120, 25);
			panel.add(inicioActividad);

			JTextField inicioActividadTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			inicioActividadTexto.setBounds(140, 170, 165, 25);
			panel.add(inicioActividadTexto);

			
			
			/* Rubro */
			JCheckBox checkBox1 = new JCheckBox("Medicina Prepaga");
			/* (x, y, largo, ancho) */
			checkBox1.setBounds(10, 200, 150, 50);
			panel.add(checkBox1);
			/* Viaticos y Movilidad */
			JCheckBox checkBox2 = new JCheckBox("Viaticos y Movilidad");
			/* (x, y, largo, ancho) */
			checkBox2.setBounds(170, 200, 150, 50);
			panel.add(checkBox2);
			/* Mantenimiento */
			JCheckBox checkBox3 = new JCheckBox("Mantenimiento");
			/* (x, y, largo, ancho) */
			checkBox3.setBounds(10, 235, 150, 50);
			panel.add(checkBox3);
			/* Librería */
			JCheckBox checkBox4 = new JCheckBox("Librería");
			/* (x, y, largo, ancho) */
			checkBox4.setBounds(170, 235, 150, 50);
			panel.add(checkBox4);
			/* Papelería */
			JCheckBox checkBox5 = new JCheckBox("Papelería");
			/* (x, y, largo, ancho) */
			checkBox5.setBounds(10, 270, 150, 50);
			panel.add(checkBox5);
			/* Productos Reventa */
			JCheckBox checkBox6 = new JCheckBox("Productos Reventa");
			/* (x, y, largo, ancho) */
			checkBox6.setBounds(170, 270, 150, 50);
			panel.add(checkBox6);
			
			
			
			/* DEUDA MAXIMA */
			JLabel deudaMaxima = new JLabel("Deuda Máxima");
			/* (x, y, largo, ancho) */
			deudaMaxima.setBounds(10, 330, 120, 25);
			panel.add(deudaMaxima);

			JTextField deudaMaximaTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			deudaMaximaTexto.setBounds(140, 330, 165, 25);
			panel.add(deudaMaximaTexto);
			

			/* CALLE */
			JLabel calle = new JLabel("Calle");
			/* (x, y, largo, ancho) */
			calle.setBounds(10, 360, 120, 25);
			panel.add(calle);

			JTextField calleTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			calleTexto.setBounds(140, 360, 165, 25);
			panel.add(calleTexto);
			

			/* ALTURA */
			JLabel altura = new JLabel("Altura");
			/* (x, y, largo, ancho) */
			altura.setBounds(10, 390, 120, 25);
			panel.add(altura);

			JTextField alturaTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			alturaTexto.setBounds(140, 390, 165, 25);
			panel.add(alturaTexto);
			

			/* CODIGO POSTAL */
			JLabel codigoPostal = new JLabel("Código Postal");
			/* (x, y, largo, ancho) */
			codigoPostal.setBounds(10, 420, 120, 25);
			panel.add(codigoPostal);

			JTextField codigoPostalTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			codigoPostalTexto.setBounds(140, 420, 165, 25);
			panel.add(codigoPostalTexto);
			

			/* PAIS */
			JLabel pais = new JLabel("País");
			/* (x, y, largo, ancho) */
			pais.setBounds(10, 450, 120, 25);
			panel.add(pais);

			JTextField paisTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			paisTexto.setBounds(140, 450, 165, 25);
			panel.add(paisTexto);
			

			/* PROVINCIA */
			JLabel provincia = new JLabel("Provincia");
			/* (x, y, largo, ancho) */
			provincia.setBounds(10, 480, 120, 25);
			panel.add(provincia);

			JTextField provinciaTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			provinciaTexto.setBounds(140, 480, 165, 25);
			panel.add(provinciaTexto);
			

			/* CIUDAD */
			JLabel ciudad = new JLabel("Ciudad");
			/* (x, y, largo, ancho) */
			ciudad.setBounds(10, 510, 120, 25);
			panel.add(ciudad);

			JTextField ciudadTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			ciudadTexto.setBounds(140, 510, 165, 25);
			panel.add(ciudadTexto);
			
			/* Actualizo el frame */
			panel.revalidate();
			panel.repaint();
		});
	}

	private void quitar() {
		/* Configuro la pantalla de quitar */
		quitarProveedor.addActionListener(e -> {
			
			panel.removeAll();
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

			/* Actualizo el frame */
			panel.revalidate();
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