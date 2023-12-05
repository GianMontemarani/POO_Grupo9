package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import modelo.Producto;
import modelo.TipoImpuesto;

public class OrdenDeCompraAgregarView {
	private JFrame popupFrame;
	private JPanel panel;
	private JPanel panel2;

	public OrdenDeCompraAgregarView(JPanel panel, int cuit) {
		popupFrame = new JFrame("Agregar Certificado");

		popupFrame.setVisible(true);
		popupFrame.setSize(500, 500);
		popupFrame.setLocationRelativeTo(panel);
		popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			agregar(popupFrame, cuit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void agregar(JFrame popupFrame, int cuit) throws Exception {

		panel = new JPanel(new CardLayout());
		popupFrame.add(panel);
		panel.setLayout(null);

		ProveedorController proveedorController = ProveedorController.getInstance();
		List<ProveedorDto> listaProveedoresDto = proveedorController.getAll();
		Integer[] options = new Integer[listaProveedoresDto.size()];
		for (int i = 0; i < listaProveedoresDto.size(); i++) {
			ProveedorDto proveedorDto = listaProveedoresDto.get(i);
			options[i] = proveedorDto.getCuit();
		}
		JComboBox<Integer> proveedoresBox = new JComboBox<>(options);
		proveedoresBox.setBounds(10, 20, 165, 25);
		panel.add(proveedoresBox);

		proveedoresBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer selectedCuit = (Integer) proveedoresBox.getSelectedItem();
				
				try {
					datosPorProveedor(selectedCuit);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		popupFrame.revalidate();
		popupFrame.repaint();
	}

	private void datosPorProveedor(int cuit) throws Exception {
		System.out.println(cuit);
		JComboBox<String> impuestoBox = new JComboBox<>();
		panel.remove(impuestoBox);
		impuestoBox.removeAllItems();
		
		ProveedorController proveedorController = ProveedorController.getInstance();
		ProveedorDto proveedorDto = proveedorController.getProveedor(cuit);
		List<Producto> listaProductos = proveedorDto.getProductos();
		String[] options = new String[listaProductos.size()];
		int[] ids = new int[listaProductos.size()];
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto productoDto = listaProductos.get(i);
			options[i] = productoDto.getNombre();
		}
	    
	    
	    for (String option : options) {
	    	System.out.println(option);
	        impuestoBox.addItem(option);
	    }
		

		impuestoBox.setBounds(10, 50, 165, 25);
		panel.add(impuestoBox);
		

		impuestoBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Handle the action, e.g., get the selected item
				String selectedProveedor = (String) impuestoBox.getSelectedItem();

				// Do something with the selected item and ID
				System.out.println("Selected Producto: " + selectedProveedor);

			}
		});

		
		popupFrame.revalidate();
		popupFrame.repaint();
	}

}
