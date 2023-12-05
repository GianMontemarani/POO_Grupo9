package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controladores.ProductoController;
import dto.ProductoDto;

public class ProductoView {

	private JMenuItem agregarProducto;
	private JMenuItem listarProducto;
	private JPanel panel;

	public ProductoView(JPanel panel) {
		this.panel = panel;
		ProductoController productoController;

		try {
			productoController = ProductoController.getInstance();

			listarProducto = new JMenuItem("Listar");
			listarProducto.addActionListener(e -> {
				listar(productoController);
			});

			agregarProducto = new JMenuItem("Agregar");
			agregarProducto.addActionListener(e -> {
				agregar(productoController);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void agregar(ProductoController productoController) {
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

		/* Unidad */
		JLabel unidad = new JLabel("Unidad");
		/* (x, y, largo, ancho) */
		unidad.setBounds(10, 50, 80, 25);
		panel.add(unidad);

		JTextField unidadText = new JTextField(20);
		/* (x, y, largo, ancho) */
		unidadText.setBounds(100, 50, 165, 25);
		panel.add(unidadText);

		/* Precio */
		JLabel precio = new JLabel("Precio");
		/* (x, y, largo, ancho) */
		precio.setBounds(10, 80, 80, 25);
		panel.add(precio);

		JTextField precioTexto = new JTextField(20);
		/* (x, y, largo, ancho) */
		precioTexto.setBounds(100, 80, 165, 25);
		panel.add(precioTexto);

		/* IVA */
		JLabel iva = new JLabel("IVA");
		/* (x, y, largo, ancho) */
		iva.setBounds(10, 110, 80, 25);
		panel.add(iva);

		JTextField ivaTexto = new JTextField(20);
		/* (x, y, largo, ancho) */
		ivaTexto.setBounds(100, 110, 165, 25);
		panel.add(ivaTexto);

		/* Boton Agregar */
		JButton botonAgregar = new JButton("Agregar");
		/* (x, y, largo, ancho) */
		botonAgregar.setBounds(100, 150, 120, 25);
		panel.add(botonAgregar);

		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ProductoDto pDto = new ProductoDto(unidadText.getText(), Float.parseFloat(precioTexto.getText()),
						Integer.parseInt(ivaTexto.getText()), nombreTexto.getText());

				productoController.addProducto(pDto);
			}
		});

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();

	}

	private void listar(ProductoController productoController) {
		// Configuro la pantalla de listar
		panel.removeAll();
		panel.setLayout(new BorderLayout());

		// Conseguimos la lista de proveedores
		List<ProductoDto> listaProductos = productoController.getAll();
		Object[][] datos = new Object[listaProductos.size()][7];
		for (int i = 0; i < listaProductos.size(); i++) {
			ProductoDto productos = listaProductos.get(i);
			datos[i][0] = productos.getId();
			datos[i][1] = productos.getNombre();
			datos[i][2] = productos.getUnidad();
			datos[i][3] = productos.getIva();
			datos[i][4] = productos.getPrecio();
		}
		// Creamos el array de columnas
		String[] nombresColumnas = { "ID", "Nombre", "Unidad", "IVA", "Precio", "Eliminar" };
		// Creamos la tabla a partir de los datos y las columnas
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

		// Hcemos que la tabla no se pueda editar
		JTable tabla = new JTable(modeloTabla) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return column == 5;
			}
		};

		// Boton de eliminar
		BotonEliminar botonEliminar = new BotonEliminar();
		TableColumn columnaBoton = tabla.getColumnModel().getColumn(5);
		columnaBoton.setCellRenderer(botonEliminar);
		columnaBoton.setCellEditor(
				new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, productoController, this));

		JScrollPane scrollPane = new JScrollPane(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);

		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();
	}

	static class ButtonEditor extends DefaultCellEditor {
		private BotonEliminar button;

		public ButtonEditor(JTextField textField, BotonEliminar button, JTable table, Object[][] datos,
				ProductoController productoController, ProductoView view) {
			super(textField);
			this.button = button;

			// @gian aca esta lo que pasa al clickear el boton xd
			button.addActionListener(e -> {

				fireEditingStopped();
				int selectedRow = table.getSelectedRow();

				int id = (int) datos[selectedRow][0];
				productoController.eliminarProducto(id);
				System.out.println("Elimina el producto");
				view.listar(productoController);
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
		return agregarProducto;
	}

	public JMenuItem getListar() {
		return listarProducto;
	}
}
