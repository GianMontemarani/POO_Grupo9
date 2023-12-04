package ui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controladores.ImpuestoController;
import controladores.ProductoController;
import dto.ImpuestoDto;
import dto.ProductoDto;
import modelo.TipoImpuesto;
import ui.ProductoView.ButtonEditor;

public class ImpuestosView {
	private JMenuItem agregarImpuesto;
	private JMenuItem listarImpuesto;
	private JPanel panel;

	public ImpuestosView(JPanel panel) {
		this.panel = panel;
		ImpuestoController impuestoController;

		try {
			impuestoController = ImpuestoController.getInstance();

			listarImpuesto = new JMenuItem("Listar");
			listarImpuesto.addActionListener(e -> {
				 listar(impuestoController); 
			});

			agregarImpuesto = new JMenuItem("Agregar");
			agregarImpuesto.addActionListener(e -> {
				agregar(impuestoController);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void agregar(ImpuestoController impuestoController) {
		/* Configuro la pantalla de agregar */

		panel.removeAll();
		panel.setLayout(null);

		/* Nombre */
		JLabel nombre = new JLabel("Nombre");
		/* (x, y, largo, ancho) */
		nombre.setBounds(10, 20, 80, 25);
		panel.add(nombre);

		JTextField nombreTexto = new JTextField(20);
		/* (x, y, largo, ancho) */
		nombreTexto.setBounds(100, 20, 165, 25);
		panel.add(nombreTexto);

		/* Tipo */
		JLabel tipo = new JLabel("Tipo");
		/* (x, y, largo, ancho) */
		tipo.setBounds(10, 50, 80, 25);
		panel.add(tipo);

		String[] options = { "IVA", "IIBB", "GANANCIAS" };
		JComboBox<String> comboBox = new JComboBox<>(options);
		panel.add(comboBox);
		comboBox.setBounds(100, 50, 165, 25);

		/* porcentaje */
		JLabel porcentaje = new JLabel("Porcentaje");
		/* (x, y, largo, ancho) */
		porcentaje.setBounds(10, 80, 80, 25);
		panel.add(porcentaje);

		JTextField porcentajeTexto = new JTextField(20);
		/* (x, y, largo, ancho) */
		porcentajeTexto.setBounds(100, 80, 165, 25);
		panel.add(porcentajeTexto);

		/* Boton Agregar */
		JButton botonAgregar = new JButton("Agregar");
		/* (x, y, largo, ancho) */
		botonAgregar.setBounds(100, 110, 120, 25);
		panel.add(botonAgregar);

		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				TipoImpuesto tipo = null;
				if (selectedOption.equals("IVA")) {
					tipo = TipoImpuesto.IVA;
				} else if (selectedOption.equals("IIBB")) {
					tipo = TipoImpuesto.IIBB;
				} else {
					tipo = TipoImpuesto.GANANCIAS;
				}
				System.out.println(selectedOption);

				ImpuestoDto iDto = new ImpuestoDto(nombreTexto.getText(), Float.parseFloat(porcentajeTexto.getText()),
						tipo);

				impuestoController.addImpuesto(iDto);

			}
		});

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();

	}

	private void listar(ImpuestoController impuestoController) {
		// Configuro la pantalla de listar
		panel.removeAll();
		panel.setLayout(new BorderLayout());

		// Conseguimos la lista de proveedores
		List<ImpuestoDto> listaImpuestos = impuestoController.getAll();
		Object[][] datos = new Object[listaImpuestos.size()][7];
		for (int i = 0; i < listaImpuestos.size(); i++) {
			ImpuestoDto impuesto = listaImpuestos.get(i);
			datos[i][0] = impuesto.getId();
			datos[i][1] = impuesto.getNombre();
			datos[i][2] = impuesto.getPorcentaje();
			datos[i][3] = impuesto.getTipoImpuesto();
		}
		// Creamos el array de columnas
		String[] nombresColumnas = { "ID", "Nombre", "Porcentaje", "Tipo", "Eliminar" };
		// Creamos la tabla a partir de los datos y las columnas
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

		// Hcemos que la tabla no se pueda editar
		JTable tabla = new JTable(modeloTabla) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return column == 4;
			};
		};

		// Boton de eliminar
		BotonEliminar botonEliminar = new BotonEliminar();
		TableColumn columnaBoton = tabla.getColumnModel().getColumn(4);
		columnaBoton.setCellRenderer(botonEliminar);
		columnaBoton.setCellEditor(
				new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, impuestoController, this));

		JScrollPane scrollPane = new JScrollPane(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();
	}
	
	
	static class ButtonEditor extends DefaultCellEditor {
		private BotonEliminar button;

		public ButtonEditor(JTextField textField, BotonEliminar button, JTable table, Object[][] datos,
				ImpuestoController impuestoController, ImpuestosView view) {
			super(textField);
			this.button = button;

			// @gian aca esta lo que pasa al clickear el boton xd
			button.addActionListener(e -> {

				fireEditingStopped();
				int selectedRow = table.getSelectedRow();

				int id = (int) datos[selectedRow][0];
				/* impuestoController.eliminarById(id); */
				System.out.println("Elimina el Impuesto: "+id);
				view.listar(impuestoController);
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setText("Eliminado");
			return button;
		}
	}

	public JMenuItem getAgregar() {
		return agregarImpuesto;
	}

	public JMenuItem getListar() {
		return listarImpuesto;
	}
}
