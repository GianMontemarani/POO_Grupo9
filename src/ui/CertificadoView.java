package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controladores.ProveedorController;
import dto.ProveedorDto;
import modelo.CertificadoRetencion;

public class CertificadoView {
	private JFrame popupFrame;

	public CertificadoView(JPanel panel, int cuit, ProveedorController proveedorController) {
		popupFrame = new JFrame("Certificados");
		popupFrame.setLayout(new BorderLayout());

		popupFrame.setVisible(true);
		popupFrame.setSize(1000, 750);

		popupFrame.setLocationRelativeTo(panel);
		popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			listar(popupFrame, cuit, proveedorController);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listar(JFrame popupFrame, int cuit, ProveedorController proveedorController) {
		
		ProveedorDto proveedorDto = proveedorController.getProveedor(cuit);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		List<CertificadoRetencion> certificadoRetencion = proveedorDto.getCertificados();
		if(certificadoRetencion != null) {
			Object[][] datos = new Object[certificadoRetencion.size()][3];
			for (int i = 0; i < certificadoRetencion.size(); i++) {
				CertificadoRetencion certificados = certificadoRetencion.get(i);
				datos[i][0] = certificados.getFechaInicio();
				datos[i][1] = certificados.getFechaVencimiento();
				datos[i][2] = certificados.getImpuesto();
			}

			// Creamos el array de columnas
			String[] nombresColumnas = { "Fecha de Inicio", "Fecha Vencimiento", "Impuesto", "Eliminar" };
			// Creamos la tabla a partir de los datos y las columnas
			DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);
			// Hcemos que la tabla no se pueda editar
			JTable tabla = new JTable(modeloTabla) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					int[] editableColumns = { 3 };
					for (int editableColumn : editableColumns) {
						if (column == editableColumn) {
							return true;
						}
					}
					return false;
				};
			};

			JScrollPane scrollPane = new JScrollPane(tabla);
			popupFrame.add(scrollPane, BorderLayout.CENTER);

			// Boton de eliminar
			BotonEliminar botonEliminar = new BotonEliminar();
			TableColumn columnaBoton = tabla.getColumnModel().getColumn(3);
			columnaBoton.setCellRenderer(botonEliminar);
			columnaBoton.setCellEditor(new ButtonEditor(new JTextField(), botonEliminar, tabla, datos, certificadoRetencion, this, cuit));
			
			panel.add(scrollPane, BorderLayout.CENTER);
		}else {
			JLabel label = new JLabel("No hay certificados para mostrar");
			label.setBounds(50, 50, 100, 100);
			panel.add(label);
		}
		
		JButton agregar = new JButton("AGREGAR");
		agregar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	CertificadoAgregarView certificadoAgregarView = new CertificadoAgregarView(panel,cuit);
		    }
		});
		panel.add(agregar, BorderLayout.SOUTH);

		popupFrame.add(panel, BorderLayout.CENTER);
		
		
		/* Actualizo el frame */
		popupFrame.revalidate();
		popupFrame.repaint();
	}

	static class ButtonEditor extends DefaultCellEditor {
		private BotonEliminar button;

		public ButtonEditor(JTextField textField, BotonEliminar button, JTable table, Object[][] datos, List<CertificadoRetencion> CertificadoRetencion, CertificadoView view, int cuit) {
			super(textField);
			this.button = button;

			
			button.addActionListener(e -> {
				fireEditingStopped();
				int selectedRow = table.getSelectedRow();
				try {
					ProveedorController proveedorController = ProveedorController.getInstance();
					proveedorController.eliminarCertificado(cuit , selectedRow);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			button.setText("Eliminado");
			return button;
		}
	}

	public JFrame getFrame() {
		return popupFrame;
	}
}
