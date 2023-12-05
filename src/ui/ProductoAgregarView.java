package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import controladores.ProductoController;
import controladores.ProveedorController;
import dto.ProductoDto;
import dto.ProveedorDto;
import modelo.CertificadoRetencion;
import modelo.TipoImpuesto;

public class ProductoAgregarView {
	private JFrame popupFrame;

	public ProductoAgregarView(JPanel panel, int cuit, ProveedorController proveedorController) {
		popupFrame = new JFrame("Agregar Producto");
		popupFrame.setLayout(new FlowLayout());

		popupFrame.setVisible(true);
		popupFrame.setSize(200, 600);

		popupFrame.setLocationRelativeTo(panel);
		popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			agregar(popupFrame, cuit, proveedorController);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void agregar(JFrame popupFrame, int cuit, ProveedorController proveedorController) throws Exception{
		// Configuro la pantalla de agregar

		// Consigo la lista de todos los productos
		ProductoController productoController = ProductoController.getInstance();
		List<ProductoDto> listaProductoDtos = productoController.getAll();
		String[] options = new String[listaProductoDtos.size()];
		int[] ids = new int[listaProductoDtos.size()];
		for (int i = 0; i < listaProductoDtos.size(); i++) {
			ProductoDto productoDto = listaProductoDtos.get(i);
			options[i] = productoDto.getNombre();
			ids[i] = productoDto.getId();
		}
		
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
				int index = (int) impuestoBox.getSelectedIndex();
				proveedorController.agregarProducto(cuit, ids[index]);
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
