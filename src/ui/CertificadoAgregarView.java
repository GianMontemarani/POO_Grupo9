package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controladores.ProveedorController;
import dto.ProductoDto;
import modelo.CertificadoRetencion;
import modelo.TipoImpuesto;

public class CertificadoAgregarView {
	private JFrame popupFrame;

	public CertificadoAgregarView(JPanel panel, int cuit) {
		popupFrame = new JFrame("Popup Frame");
		popupFrame.setLayout(new FlowLayout());

		popupFrame.setVisible(true);
		popupFrame.setSize(200, 300);

		popupFrame.setLocationRelativeTo(panel);
		popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			agregar(popupFrame, cuit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void agregar(JFrame popupFrame, int cuit) {
		// Configuro la pantalla de agregar

		/* Fecha Inicio */
		JLabel fechaInicio = new JLabel("Fecha Inicio");
		fechaInicio.setBounds(10, 20, 80, 25);
		popupFrame.add(fechaInicio);
		JFormattedTextField fechaInicioText = createDateTextField();
		fechaInicioText.setBounds(140, 20, 50, 25);
		popupFrame.add(fechaInicioText);

		/* Fecha Vencimiento */
		JLabel fechaVencimiento = new JLabel("Fecha Vencimiento");
		fechaVencimiento.setBounds(10, 50, 120, 25);
		popupFrame.add(fechaVencimiento);
		JFormattedTextField fechaVencimientoText = createDateTextField();
		fechaVencimientoText.setBounds(140, 50, 50, 25);
		popupFrame.add(fechaVencimientoText);

		/* Tipo */
		JLabel impuesto = new JLabel("Tipo");
		/* (x, y, largo, ancho) */
		impuesto.setBounds(10, 50, 80, 25);
		popupFrame.add(impuesto);

		String[] options = { "IIBB", "GANANCIAS" };
		JComboBox<String> impuestoBox = new JComboBox<>(options);
		popupFrame.add(impuestoBox);
		impuestoBox.setBounds(10, 110, 50, 25);

		/* Boton Agregar */
		JButton botonAgregar = new JButton("Agregar");
		/* (x, y, largo, ancho) */
		botonAgregar.setBounds(100, 150, 120, 25);
		popupFrame.add(botonAgregar);

		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) impuestoBox.getSelectedItem();
				TipoImpuesto tipoImpuesto = null;
				if (selectedOption.equals("IIBB")) {
					tipoImpuesto = TipoImpuesto.IIBB;
				} else {
					tipoImpuesto = TipoImpuesto.GANANCIAS;
				}

				Date fechaInicioParsedDate = validateDate(fechaInicioText);
				Date fechaVencimientoParsedDate = validateDate(fechaVencimientoText);
				if (fechaInicioParsedDate == null || fechaVencimientoParsedDate == null) {
					System.out.println("Fecha Invalida");
					return;
				}
				// TODO @Gian do you
				CertificadoRetencion cr = new CertificadoRetencion(fechaInicioParsedDate, fechaVencimientoParsedDate,
						tipoImpuesto);

				// ProveedorController proveedorController = ProveedorController.getInstance();

				// proveedorController.agregarCertifiacado(cuit, cr);

			}
		});

		popupFrame.revalidate();
		popupFrame.repaint();
	}

	private static JFormattedTextField createDateTextField() {
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JFormattedTextField dateTextField = new JFormattedTextField(maskFormatter);
		dateTextField.setColumns(10);
		dateTextField.setBounds(140, 170, 120, 25);
		return dateTextField;
	}

	private static Date validateDate(JFormattedTextField dateTextField) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String inputDate = dateTextField.getText();
		dateFormat.setLenient(false);
		try {
			Date parsedDate = dateFormat.parse(inputDate);
			return parsedDate;
		} catch (ParseException e) {
			return null;
		}
	}

}
