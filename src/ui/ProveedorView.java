package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import controladores.ProveedorController;
import dto.ProveedorDto;
import modelo.Rubro;

public class ProveedorView {

	private JMenuItem listarProveedores;
	private JMenuItem agregarProveedor;
	private JMenuItem quitarProveedor;
	private JPanel panel;

	public ProveedorView(JPanel panel) {
		this.panel = panel;
		ProveedorController proveedorController;
		try {
			proveedorController = ProveedorController.getInstance();

			listarProveedores = new JMenuItem("Listar");
			listarProveedores.addActionListener(e -> {
				listar(proveedorController);
			});

			agregarProveedor = new JMenuItem("Agregar");
			agregarProveedor.addActionListener(e -> {
				agregar(proveedorController);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listar(ProveedorController proveedorController) {
		// Configuro la pantalla de listar
		panel.removeAll();
		panel.setLayout(new BorderLayout());

		// Conseguimos la lista de proveedores
		List<ProveedorDto> listaProveedores = proveedorController.getAll();
		Object[][] datos = new Object[listaProveedores.size()][7];
		for (int i = 0; i < listaProveedores.size(); i++) {
			ProveedorDto proveedor = listaProveedores.get(i);
			datos[i][0] = proveedor.getCuit();
			datos[i][1] = proveedor.getRazonSocial();
			datos[i][2] = proveedor.getNombre();
			datos[i][3] = proveedor.getTelefono();
			datos[i][4] = proveedor.getCorreoElectronico();
			datos[i][5] = proveedor.getInicioActividades();
			datos[i][6] = proveedor.getMaxDeuda();
		}
		// Creamos el array de columnas
		String[] nombresColumnas = { "Cuit", "Razón Social", "Nombre", "Telefono", "Correo", "Inicio Actividades",
				"Max Deuda", "Eliminar" };
		// Creamos la tabla a partir de los datos y las columnas
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

		// Hcemos que la tabla no se pueda editar
		JTable tabla = new JTable(modeloTabla) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return column == 7;
			};
		};

		// Boton de eliminar
		BotonEliminar botonEliminar = new BotonEliminar();
		TableColumn columnaBoton = tabla.getColumnModel().getColumn(7);
		columnaBoton.setCellRenderer(botonEliminar);
		columnaBoton.setCellEditor(new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, proveedorController, this));

		JScrollPane scrollPane = new JScrollPane(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();
	}

	private void agregar(ProveedorController proveedorController) {
		// Configuro la pantalla de agregar

		panel.removeAll();
		panel.setLayout(null);

		/* CUIT */
		JLabel cuit = new JLabel("Cuit");
		cuit.setBounds(10, 20, 80, 25);
		panel.add(cuit);
		JTextField cuitText = new JTextField(20);
		cuitText.setBounds(100, 20, 165, 25);
		panel.add(cuitText);

		/* RAZON SOCIAL */
		JLabel razonSocial = new JLabel("Razon social");
		razonSocial.setBounds(10, 50, 80, 25);
		panel.add(razonSocial);
		JTextField razonSocialText = new JTextField(20);
		razonSocialText.setBounds(100, 50, 165, 25);
		panel.add(razonSocialText);

		/* NOMBRE */
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(10, 80, 80, 25);
		panel.add(nombre);
		JTextField nombreTexto = new JTextField(20);
		nombreTexto.setBounds(100, 80, 165, 25);
		panel.add(nombreTexto);

		/* TELEFONO */
		JLabel telefono = new JLabel("Teléfono");
		telefono.setBounds(10, 110, 80, 25);
		panel.add(telefono);
		JTextField telefonoTexto = new JTextField(20);
		telefonoTexto.setBounds(100, 110, 165, 25);
		panel.add(telefonoTexto);

		/* CORREO ELECTRONICO */
		JLabel correo = new JLabel("Correo");
		correo.setBounds(10, 140, 120, 25);
		panel.add(correo);
		JTextField correoTexto = new JTextField(20);
		correoTexto.setBounds(140, 140, 165, 25);
		panel.add(correoTexto);

		/* INICIO DE ACTIVIDAD */
		JLabel inicioActividad = new JLabel("Inicio de Actividad");
		inicioActividad.setBounds(10, 170, 120, 25);
		panel.add(inicioActividad);
		JFormattedTextField dateTextField = createDateTextField();
		/*
		 * dateTextField.addFocusListener(new FocusAdapter() {
		 * 
		 * @Override public void focusLost(FocusEvent e) { validateDate(dateTextField);
		 * } });
		 */
		panel.add(dateTextField);

		/* Rubros */
		Map<JCheckBox, Rubro> checkBoxesMap = new HashMap<>(); // Este map es para vincular los checkbox con los
																// enum
		/* Medicina Prepaga */
		JCheckBox checkBox1 = new JCheckBox("Medicina Prepaga");
		checkBox1.setBounds(10, 200, 150, 50);
		panel.add(checkBox1);
		checkBoxesMap.put(checkBox1, Rubro.MEDICINA);
		/* Viaticos y Movilidad */
		JCheckBox checkBox2 = new JCheckBox("Viaticos y Movilidad");
		checkBox2.setBounds(170, 200, 150, 50);
		panel.add(checkBox2);
		checkBoxesMap.put(checkBox2, Rubro.VIATICOS);
		/* Mantenimiento */
		JCheckBox checkBox3 = new JCheckBox("Mantenimiento");
		checkBox3.setBounds(10, 235, 150, 50);
		panel.add(checkBox3);
		checkBoxesMap.put(checkBox3, Rubro.MANTENIMIENTO);
		/* Librería */
		JCheckBox checkBox4 = new JCheckBox("Librería");
		checkBox4.setBounds(170, 235, 150, 50);
		panel.add(checkBox4);
		checkBoxesMap.put(checkBox4, Rubro.LIBRERIA);
		/* Papelería */
		JCheckBox checkBox5 = new JCheckBox("Papelería");
		checkBox5.setBounds(10, 270, 150, 50);
		panel.add(checkBox5);
		checkBoxesMap.put(checkBox5, Rubro.PAPELERIA);
		/* Productos Reventa */
		JCheckBox checkBox6 = new JCheckBox("Productos Reventa");
		checkBox6.setBounds(170, 270, 150, 50);
		panel.add(checkBox6);
		checkBoxesMap.put(checkBox6, Rubro.PRODUCTOS);
		/* Fin checkbox rubros */

		/* DEUDA MAXIMA */
		JLabel deudaMaxima = new JLabel("Deuda Máxima");
		deudaMaxima.setBounds(10, 330, 120, 25);
		panel.add(deudaMaxima);
		JTextField deudaMaximaTexto = new JTextField(20);
		deudaMaximaTexto.setBounds(140, 330, 165, 25);
		panel.add(deudaMaximaTexto);

		/* CALLE */
		JLabel calle = new JLabel("Calle");
		calle.setBounds(10, 360, 120, 25);
		panel.add(calle);
		JTextField calleTexto = new JTextField(20);
		calleTexto.setBounds(140, 360, 165, 25);
		panel.add(calleTexto);

		/* ALTURA */
		JLabel altura = new JLabel("Altura");
		altura.setBounds(10, 390, 120, 25);
		panel.add(altura);
		JTextField alturaTexto = new JTextField(20);
		alturaTexto.setBounds(140, 390, 165, 25);
		panel.add(alturaTexto);

		/* CODIGO POSTAL */
		JLabel codigoPostal = new JLabel("Código Postal");
		codigoPostal.setBounds(10, 420, 120, 25);
		panel.add(codigoPostal);
		JTextField codigoPostalTexto = new JTextField(6);
		codigoPostalTexto.setBounds(140, 420, 165, 25);
		panel.add(codigoPostalTexto);

		/* PAIS */
		JLabel pais = new JLabel("País");
		pais.setBounds(10, 450, 120, 25);
		panel.add(pais);
		JTextField paisTexto = new JTextField(20);
		paisTexto.setBounds(140, 450, 165, 25);
		panel.add(paisTexto);

		/* PROVINCIA */
		JLabel provincia = new JLabel("Provincia");
		provincia.setBounds(10, 480, 120, 25);
		panel.add(provincia);
		JTextField provinciaTexto = new JTextField(20);
		provinciaTexto.setBounds(140, 480, 165, 25);
		panel.add(provinciaTexto);

		/* CIUDAD */
		JLabel ciudad = new JLabel("Ciudad");
		ciudad.setBounds(10, 510, 120, 25);
		panel.add(ciudad);
		JTextField ciudadTexto = new JTextField(20);
		ciudadTexto.setBounds(140, 510, 165, 25);
		panel.add(ciudadTexto);

		/* Boton Agregar */
		JButton botonAgregar = new JButton("Agregar");
		/* (x, y, largo, ancho) */
		botonAgregar.setBounds(10, 550, 120, 25);
		panel.add(botonAgregar);

		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date parsedDate = validateDate(dateTextField); // Valido la fecha, si es correcta se guarda en
																// parsedDate, sino se muestra el eror en consola
				if (parsedDate == null) {
					System.out.println("Fecha Invalida");
					return;
				}

				// Segun los checkbox seleccionados guardo los enum vinculados en la lista
				List<Rubro> rubrosSeleccionados = new ArrayList<>();
				for (Map.Entry<JCheckBox, Rubro> entry : checkBoxesMap.entrySet()) {
					JCheckBox checkBox = entry.getKey();
					Rubro opcionEnum = entry.getValue();
					if (checkBox.isSelected()) {
						rubrosSeleccionados.add(opcionEnum);
					}
				}

				ProveedorDto pDto = new ProveedorDto(Integer.parseInt(cuitText.getText()), razonSocialText.getText(),
						nombreTexto.getText(), Integer.parseInt(telefonoTexto.getText()), correoTexto.getText(),
						parsedDate, rubrosSeleccionados, Float.parseFloat(deudaMaximaTexto.getText()),
						calleTexto.getText(), Integer.parseInt(alturaTexto.getText()),
						Integer.parseInt(codigoPostalTexto.getText()), paisTexto.getText(), provinciaTexto.getText(),
						ciudadTexto.getText());
				proveedorController.addProveedor(pDto);
			}
		});

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();
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

	public class BotonEliminar extends JButton implements TableCellRenderer, ActionListener {
		public BotonEliminar() {
			// Initialize your button properties if needed
			// For example, setOpaque(true) to make sure it's painted
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// Customize the button based on the cell value or other parameters
			setText("Click me"); // Set the button text
			// Add any other customization based on the cell value or other parameters

			return this; // Return the button as the rendering component
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// This method will be called when the button is clicked
			// Perform your action here
			System.out.println("Button clicked!");
			// Add your custom action code here
		}
	}

	static class ButtonEditor extends DefaultCellEditor {
		private BotonEliminar button;
		
		
		public ButtonEditor(JTextField textField, BotonEliminar button, JTable table, Object[][] datos, ProveedorController proveedorController,ProveedorView view) {
			super(textField);
			this.button = button;
			
			// @gian aca esta lo que pasa al clickear el boton xd
			button.addActionListener(e -> {
				
				fireEditingStopped();
				int selectedRow = table.getSelectedRow();
				
				System.out.println("cuit es: " + datos[selectedRow][0]);
				int cuit = (int) datos[selectedRow][0];
				proveedorController.eliminarByCuit(cuit);
				view.listar(proveedorController);
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setText("Click me");
			return button;
		}
	}

	public JMenuItem getListar() {
		return listarProveedores;
	}

	public JMenuItem getAgregar() {
		return agregarProveedor;
	}
}