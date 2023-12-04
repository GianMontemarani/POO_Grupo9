package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
			listarProducto.addActionListener(e -> {
				agregar();
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void agregar() {
		/* Configuro la pantalla de agregar */
		agregarProducto.addActionListener(e -> {

			panel.removeAll();
			panel.setLayout(null);

			/* Nombre */
			JLabel usuario = new JLabel("Nombre");
			/* (x, y, largo, ancho) */
			usuario.setBounds(10, 20, 80, 25);
			panel.add(usuario);

			JTextField usuarioTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			usuarioTexto.setBounds(100, 20, 165, 25);
			panel.add(usuarioTexto);

			/* Unidad */
			JLabel password = new JLabel("Unidad");
			/* (x, y, largo, ancho) */
			password.setBounds(10, 50, 80, 25);
			panel.add(password);

			JPasswordField passwordText = new JPasswordField(20);
			/* (x, y, largo, ancho) */
			passwordText.setBounds(100, 50, 165, 25);
			panel.add(passwordText);

			/* Precio */
			JLabel nombre = new JLabel("Precio");
			/* (x, y, largo, ancho) */
			nombre.setBounds(10, 80, 80, 25);
			panel.add(nombre);

			JTextField nombreTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			nombreTexto.setBounds(100, 80, 165, 25);
			panel.add(nombreTexto);

			/* IVA */
			JLabel telefono = new JLabel("IVA");
			/* (x, y, largo, ancho) */
			telefono.setBounds(10, 110, 80, 25);
			panel.add(telefono);

			JTextField telefonoTexto = new JTextField(20);
			/* (x, y, largo, ancho) */
			telefonoTexto.setBounds(100, 110, 165, 25);
			panel.add(telefonoTexto);

			/* Actualizo el frame */
			panel.revalidate();
			panel.repaint();
		});
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
			datos[i][0] = productos.getNombre();
			datos[i][1] = productos.getUnidad();
			datos[i][2] = productos.getIva();
			datos[i][3] = productos.getPrecio();
		}
		// Creamos el array de columnas
		String[] nombresColumnas = { "Nombre", "Unidad", "IVA", "Precio", "Eliminar" };
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

				System.out.println("producto es: " + datos[selectedRow][0]);
				
				// productoController.eliminar();
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
