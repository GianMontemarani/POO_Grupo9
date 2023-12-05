package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import controladores.DocumentoController;
import controladores.ImpuestoController;
import controladores.ProductoController;
import controladores.ProveedorController;
import dto.FacturaDto;
import dto.OrdenDeCompraDto;
import dto.ProductoDto;
import modelo.Factura;
import ui.ProductoView.ButtonEditor;

public class DocumentosView {

	private JPanel panel;
	private JMenuItem facturaItem;
	private JMenuItem ordenDePagoItem;
	private JMenuItem ordenDeCompraItem;

	public DocumentosView(JPanel panel) {
		this.panel = panel;
		DocumentoController documentoController = DocumentoController.getInstance();

		try {

			facturaItem = new JMenuItem("Factura");
			facturaItem.addActionListener(e -> {
				factura(documentoController);
			});

			ordenDePagoItem = new JMenuItem("Orden de pago");
			ordenDePagoItem.addActionListener(e -> {
				/* ordenDePago(documentoController); */
			});

			ordenDeCompraItem = new JMenuItem("Orden de compra");
			ordenDeCompraItem.addActionListener(e -> {
				ordenDeCompra(documentoController); 
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private void ordenDeCompra(DocumentoController documentoController) {
		panel.removeAll();
		panel.setLayout(new BorderLayout());        
        
		List<OrdenDeCompraDto> listaFacturas = documentoController.getOrdenesDeComrpra();
		Object[][] datos = new Object[listaFacturas.size()][4];

		for (int i = 0; i < listaFacturas.size(); i++) {
			OrdenDeCompraDto compras = listaFacturas.get(i);
			datos[i][0] = compras.getNumero();
			datos[i][1] = compras.getImporte();
			datos[i][2] = compras.getFecha();
		}

		// Creamos el array de columnas
		String[] nombresColumnas = { "Numero", "Importe", "Fecha", "Detalle", "Eliminar" };
		// Creamos la tabla a partir de los datos y las columnas
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

		// Hcemos que la tabla no se pueda editar
		JTable tabla = new JTable(modeloTabla) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return column == 4;
			}
		};
		

		// Boton de eliminar
		BotonEliminar botonEliminar = new BotonEliminar();
		TableColumn columnaBoton = tabla.getColumnModel().getColumn(4);
		columnaBoton.setCellRenderer(botonEliminar);
		columnaBoton.setCellEditor(
				new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, documentoController, this));

		
		JScrollPane scrollPane = new JScrollPane(tabla);
		JPanel tableCard = new JPanel(new BorderLayout());
		tableCard.add(scrollPane, BorderLayout.CENTER);
		
		/* Boton Agregar */
		JPanel buttonCard = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton botonAgregar = new JButton("AGREGAR");
		buttonCard.add(botonAgregar);
		botonAgregar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	OrdenDeCompraAgregarView ordenDeCompraAgregarView = new OrdenDeCompraAgregarView(buttonCard, 0);
		    }
		});
		
		panel.add(tableCard, BorderLayout.CENTER);
        panel.add(buttonCard, BorderLayout.SOUTH);		


		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();

	}

	private void factura(DocumentoController documentoController) {
		panel.removeAll();
		panel.setLayout(new BorderLayout());
		
        
        
		List<FacturaDto> listaFacturas = documentoController.getFacturas();
		Object[][] datos = new Object[listaFacturas.size()][4];

		for (int i = 0; i < listaFacturas.size(); i++) {
			FacturaDto productos = listaFacturas.get(i);
			datos[i][0] = productos.getTotalARetener();
			datos[i][1] = productos.getNumero();
			datos[i][2] = productos.getFecha();
			datos[i][3] = productos.getImporte();
		}

		// Creamos el array de columnas
		String[] nombresColumnas = { "getTotalARetener", "getNumero", "getFecha", "getImporte", "Eliminar" };
		// Creamos la tabla a partir de los datos y las columnas
		DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

		// Hcemos que la tabla no se pueda editar
		JTable tabla = new JTable(modeloTabla) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return column == 4;
			}
		};
		

		// Boton de eliminar
		BotonEliminar botonEliminar = new BotonEliminar();
		TableColumn columnaBoton = tabla.getColumnModel().getColumn(4);
		columnaBoton.setCellRenderer(botonEliminar);
		columnaBoton.setCellEditor(
				new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, documentoController, this));

		
		JScrollPane scrollPane = new JScrollPane(tabla);
		JPanel tableCard = new JPanel(new BorderLayout());
		tableCard.add(scrollPane, BorderLayout.CENTER);
		
		/* Boton Agregar */
		JPanel buttonCard = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton botonAgregar = new JButton("AGREGAR");
		buttonCard.add(botonAgregar);
		botonAgregar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("Soon...");
		    }
		});
		
		panel.add(tableCard, BorderLayout.CENTER);
        panel.add(buttonCard, BorderLayout.SOUTH);		


		/* Actualizo el frame */
		panel.revalidate();
		panel.repaint();

	}

	static class ButtonEditor extends DefaultCellEditor {
		private BotonEliminar button;

		public ButtonEditor(JTextField textField, BotonEliminar button, JTable table, Object[][] datos,
				DocumentoController documentoController, DocumentosView view) {
			super(textField);
			this.button = button;

			// @gian aca esta lo que pasa al clickear el boton xd
			button.addActionListener(e -> {

				fireEditingStopped();
				int selectedRow = table.getSelectedRow();

				int id = (int) datos[selectedRow][0];
				System.out.println(id);

			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setText("Eliminado");
			return button;
		}
	}

	public JMenuItem getFactura() {
		return facturaItem;
	}

	public JMenuItem getOrdenDePago() {
		return ordenDePagoItem;
	}

	public JMenuItem getOrdenDeCompra() {
		return ordenDeCompraItem;
	}
}
