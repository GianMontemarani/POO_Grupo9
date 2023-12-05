package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import controladores.DocumentoController;
import dto.FacturaDto;
import dto.ProveedorDto;
import ui.ProveedorView.ButtonEditor;

public class FunctionsView {
	private JMenuItem facturasPorDiaProveedor;
	private JMenuItem precioPorProducto;
	private JMenuItem ObtenerOrdenesDePago;
	private JMenuItem DeudaPorProveedor;
	private JMenuItem ImpuestosRetenidos;
	private JMenuItem LibroIVA;
	private JMenuItem CuentaCorrienteDeProveedores;
	
	private JPanel panel;
	
	public FunctionsView(JPanel panel) {
		this.panel = panel;
		
		DocumentoController dController;
		try {
			dController = DocumentoController.getInstance();
			
			facturasPorDiaProveedor = new JMenuItem("Facturas Por Dia Proveedor");
			facturasPorDiaProveedor.addActionListener(e -> {
				reporteFacturas(dController);
			});
			
			precioPorProducto = new JMenuItem("Precio Por Producto");
			ObtenerOrdenesDePago = new JMenuItem("Obtener Ordenes De Pago");
			DeudaPorProveedor = new JMenuItem("Deuda Por Proveedor");
			ImpuestosRetenidos = new JMenuItem("Impuestos Retenidos");
			LibroIVA = new JMenuItem("Libro IVA");
			CuentaCorrienteDeProveedores = new JMenuItem("Cuenta Corriente De Proveedores");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
	public void reporteFacturas(DocumentoController documetnController) {
		JFrame framConsulta = new JFrame("Reporte Facturas");
		framConsulta.setSize(300, 200);
		framConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelConsulta = new JPanel(new CardLayout());
		framConsulta.add(panelConsulta);
		panelConsulta.setLayout(null);
		
		JLabel cuit = new JLabel("Cuit");
		cuit.setBounds(25, 25, 80, 25);
		panelConsulta.add(cuit);
		JTextField cuitTexto = new JTextField(20);
		cuitTexto.setBounds(100, 20, 165, 25);
		panelConsulta.add(cuitTexto);
		
		JLabel fecha = new JLabel("Fecha");
		fecha.setBounds(25, 50, 80, 25);
		panelConsulta.add(fecha);
		JFormattedTextField dateTextField = createDateTextField();
		dateTextField.setColumns(10);
		dateTextField.setBounds(100, 50, 120, 25);
		panelConsulta.add(dateTextField);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setBounds(100, 80, 80, 25);
		panelConsulta.add(botonBuscar);
		
		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date fecha = validateDate(dateTextField);
				
				List<FacturaDto> reporte = new ArrayList<FacturaDto>();
				
				if(cuitTexto.getText().length() > 0 && fecha != null) {
					reporte = documetnController.getFacturasByFilter(fecha, Integer.parseInt(cuitTexto.getText()));
				}else if(cuitTexto.getText().length() > 0) {
					reporte = documetnController.getFacturasByFilter(Integer.parseInt(cuitTexto.getText()));
				}else if(fecha != null) {
					reporte = documetnController.getFacturasByFilter(fecha);
				}else {
					System.out.println("campos vacios");
				}
				
				
				if(reporte.isEmpty()) {
					panelConsulta.removeAll();
					panelConsulta.setLayout(null);
					
					Object[][] datos = new Object[reporte.size()][7];
					for (int i = 0; i < reporte.size(); i++) {
						FacturaDto factura = reporte.get(i);
						datos[i][0] = factura.getNumero();
						datos[i][1] = factura.getFecha();
						datos[i][2] = factura.getImporte();
						datos[i][3] = factura.getOrdenCompra().getNumero();
						datos[i][4] = factura.estaPaga();
						datos[i][5] = factura.getProveedor().getNombre();
						datos[i][6] = factura.getTotalARetener();
					}
					// Creamos el array de columnas
					String[] nombresColumnas = { "Numero", "Fecha", "Importe", "N Orden de compra", "Paga", "Nombre proveedor",
							"Total retencion"};
					// Creamos la tabla a partir de los datos y las columnas
					DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

					// Hcemos que la tabla no se pueda editar
					JTable tabla = new JTable(modeloTabla) {
						private static final long serialVersionUID = 1L;
						public boolean isCellEditable(int row, int column) {
							return column == 7;
						};
					};
					
					JScrollPane scrollPane = new JScrollPane(tabla);
					framConsulta.setSize(1000, 750);
					panelConsulta.add(scrollPane, BorderLayout.CENTER);					

					/* Actualizo el frame */
					panelConsulta.revalidate();
					panelConsulta.repaint();
				}
			}
		});
		framConsulta.setVisible(true);
	}
	
	private static JFormattedTextField createDateTextField() {
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JFormattedTextField dateTextField = new JFormattedTextField(maskFormatter);
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
	
	public JMenuItem facturasPorDiaProveedor() {
		return facturasPorDiaProveedor;
	}
	public JMenuItem precioPorProducto() {
		return precioPorProducto;
	}
	public JMenuItem ObtenerOrdenesDePago() {
		return ObtenerOrdenesDePago;
	}
	public JMenuItem DeudaPorProveedor() {
		return DeudaPorProveedor;
	}
	public JMenuItem ImpuestosRetenidos() {
		return ImpuestosRetenidos;
	}
	public JMenuItem LibroIVA() {
		return LibroIVA;
	}
	public JMenuItem CuentaCorrienteDeProveedores() {
		return CuentaCorrienteDeProveedores;
	}
}
