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
import controladores.ImpuestoController;
import controladores.ProductoController;
import controladores.ProveedorController;
import dto.FacturaDto;
import dto.OrdenDeCompraDto;
import dto.PreciosProveedorDto;
import dto.ProveedorDto;
import ui.ProveedorView.ButtonEditor;

public class FunctionsView {
	private JMenuItem facturasPorDiaProveedor;
	private JMenuItem precioPorProducto;
	private JMenuItem obtenerOrdenesDePago;
	private JMenuItem deudaPorProveedor;
	private JMenuItem ImpuestosRetenidos;
	private JMenuItem LibroIVA;
	private JMenuItem CuentaCorrienteDeProveedores;
	
	private JPanel panel;
	
	public FunctionsView(JPanel panel) {
		this.panel = panel;
		
		DocumentoController dController;
        ProveedorController proveController;
        ImpuestoController iController;
        ProductoController productController;

        try {
            dController = DocumentoController.getInstance();
            proveController = ProveedorController.getInstance();
            productController = ProductoController.getInstance();
            iController = ImpuestoController.getInstance();


            facturasPorDiaProveedor = new JMenuItem("Facturas Por Dia Proveedor");
            facturasPorDiaProveedor.addActionListener(e -> {
                reporteFacturas(dController);
            });

            precioPorProducto = new JMenuItem("Precio Por Producto");
            precioPorProducto.addActionListener(e -> {
                precioPorProducto(proveController);
            });

            obtenerOrdenesDePago = new JMenuItem("Obtener Ordenes De Pago");
            obtenerOrdenesDePago.addActionListener(e -> {
            	listarOrdenesDePago(dController);
            });

            deudaPorProveedor = new JMenuItem("Deuda Por Proveedor");
            deudaPorProveedor.addActionListener(e -> {
            	mostrarDeudaPorProveedor(proveController);
            });
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
						datos[i][5] = factura.getProveedor();
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
	
	public void precioPorProducto(ProveedorController proveedorController) {
        JFrame framConsulta = new JFrame("Reporte Precio Por Producto");
        framConsulta.setSize(300, 150);

        JPanel panelConsulta = new JPanel();
        framConsulta.add(panelConsulta);
        panelConsulta.setLayout(null);

        JLabel cuit = new JLabel("ID Producto");
        cuit.setBounds(25, 25, 80, 25);
        panelConsulta.add(cuit);

        JTextField cuitTexto = new JTextField(20);
        cuitTexto.setBounds(100, 20, 165, 25);
        panelConsulta.add(cuitTexto);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(100, 60, 80, 25);
        panelConsulta.add(botonBuscar);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<PreciosProveedorDto> reporte = new ArrayList<PreciosProveedorDto>();

                if (cuitTexto.getText().length() > 0) {
                    reporte = proveedorController.getPrecioPorProducto(Integer.parseInt(cuitTexto.getText()));
                } else {
                    System.out.println("Campo CUIT vacío");
                }

                if (reporte.isEmpty()) {
                    panelConsulta.removeAll();
                    panelConsulta.setLayout(null);

                    Object[][] datos = new Object[reporte.size()][3];
                    for (int i = 0; i < reporte.size(); i++) {
                    	PreciosProveedorDto fila = reporte.get(i);
                        datos[i][0] = fila.getCuit();
                        datos[i][1] = fila.getRazonSocial();
                        datos[i][2] = fila.getPrecio();
                    }

                    String[] nombresColumnas = { "CUIT", "Razon Social", "Precio",  };

                    DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

                    JTable tabla = new JTable(modeloTabla) {
                        private static final long serialVersionUID = 1L;

                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    JScrollPane scrollPane = new JScrollPane(tabla);
                    framConsulta.setSize(800, 600);
                    panelConsulta.add(scrollPane, BorderLayout.CENTER);

                    panelConsulta.revalidate();
                    panelConsulta.repaint();
                }
            }
        });

        framConsulta.setVisible(true);
    }
	
	public void listarOrdenesDePago(DocumentoController dController) {
        JFrame framConsulta = new JFrame("Listar Ordenes de Pago");
        framConsulta.setSize(300, 150);

        JPanel panelConsulta = new JPanel();
        framConsulta.add(panelConsulta);
        panelConsulta.setLayout(null); 
          
                List<OrdenDeCompraDto> reporte = dController.getOrdenesDeComrpra();


     

                if (reporte.isEmpty()) {
                    panelConsulta.removeAll();
                    panelConsulta.setLayout(null);

                    Object[][] datos = new Object[reporte.size()][4];
                    for (int i = 0; i < reporte.size(); i++) {
                    	OrdenDeCompraDto fila = reporte.get(i);
                        datos[i][0] = fila.getNumero();
                        datos[i][1] = fila.getImporte();
                        datos[i][2] = fila.getFecha();
                        datos[i][3] = fila.getProveedor();
                    }

                    String[] nombresColumnas = { "CUIT", "Razon Social", "Precio",  };

                    DefaultTableModel modeloTabla = new DefaultTableModel(datos, nombresColumnas);

                    JTable tabla = new JTable(modeloTabla) {
                        private static final long serialVersionUID = 1L;

                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    JScrollPane scrollPane = new JScrollPane(tabla);
                    framConsulta.setSize(800, 600);
                    panelConsulta.add(scrollPane, BorderLayout.CENTER);

                    panelConsulta.revalidate();
                    panelConsulta.repaint();
                }
            
        

        framConsulta.setVisible(true);
    }
	
	
	
	public void mostrarDeudaPorProveedor(ProveedorController proveedorController) {
        JFrame framConsulta = new JFrame("Obtener Deuda por Proveedor");
        framConsulta.setSize(300, 150);

        JPanel panelConsulta = new JPanel();
        framConsulta.add(panelConsulta);
        panelConsulta.setLayout(null);

        JLabel cuit = new JLabel("CUIT");
        cuit.setBounds(25, 25, 80, 25);
        panelConsulta.add(cuit);

        JTextField cuitTexto = new JTextField(20);
        cuitTexto.setBounds(100, 20, 165, 25);
        panelConsulta.add(cuitTexto);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(100, 60, 80, 25);
        panelConsulta.add(botonBuscar);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               float deuda = 0;
               
                if (cuitTexto.getText().length() > 0) {
                    deuda = proveedorController.getDeudaXProveedor(Integer.parseInt(cuitTexto.getText()));
                } else {
                    System.out.println("Campo CUIT vacío");
                }
                
                panelConsulta.removeAll();
                
                JLabel deudaLabel = new JLabel("DEUDA:");
                deudaLabel.setBounds(50, 25, 80, 25);
                panelConsulta.add(deudaLabel);
                
                JLabel deudaMonto = new JLabel(String.valueOf(deuda));
                deudaMonto.setBounds(100, 25, 80, 25);
                panelConsulta.add(deudaMonto);
                
                panelConsulta.revalidate();
                panelConsulta.repaint();
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
	public JMenuItem obtenerOrdenesDePago() {
		return obtenerOrdenesDePago;
	}
	public JMenuItem deudaPorProveedor() {
		return deudaPorProveedor;
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
