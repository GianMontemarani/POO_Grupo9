package controladores;

import java.io.File;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ChequeDao;
import dao.FacturaDao;
import dao.NotaDeCreditoDao;
import dao.NotaDeDebitoDao;
import dao.OrdenDeCompraDao;
import dto.ChequeDto;
import dto.FacturaDto;
import dto.ImpuestoRetenidoDto;
import dto.LibroIvaDto;
import dto.NotaDto;
import dto.OrdenDeCompraDto;
import dto.OrdenesDePagoDto;
import modelo.Cheque;
import modelo.Documento;
import modelo.Factura;
import modelo.ItemDeFactura;
import modelo.NotaDeCredito;
import modelo.NotaDeDebito;
import modelo.OrdenDeCompra;
import modelo.OrdenDePago;

public class DocumentoController {
	private static DocumentoController INSTANCE = null;
	
	private static List<Factura> facturas;
	private static List<NotaDeCredito> notasDeCredito;
	private static List<NotaDeDebito> notasDeDebito;
	private static List<OrdenDeCompra> ordenesDeCompra;
	private static List<Cheque> cheques;
	
	private static FacturaDao facturaDao;
	private static NotaDeCreditoDao notaDeCreditoDao;
	private static NotaDeDebitoDao notaDeDebitoDao;
	private static OrdenDeCompraDao ordenDeCompraDao;
	private static ChequeDao chequeDao;
	
	private DocumentoController(List<Factura> facturas, List<NotaDeCredito> notasDeCredito,List<NotaDeDebito> notasDeDebitos,List<OrdenDeCompra> ordenesDeCompras, List<Cheque> cheques) {
		DocumentoController.facturas = facturas;
		DocumentoController.notasDeCredito = notasDeCredito;
		DocumentoController.notasDeDebito = notasDeDebitos;
		DocumentoController.ordenesDeCompra = ordenesDeCompras;
		DocumentoController.cheques = cheques;
		syncOcEnFacturas(this);
		syncNotasEnOp(this);
	}
	
	public OrdenDeCompra getOcModel(int id) {
		for(OrdenDeCompra oc: ordenesDeCompra) {
			if(oc.getNumero() == id) {
				return oc;
			}
		}
		return null;
	}
	
	public Factura getFacturaModel(int id) {
		for(Factura factura: facturas) {
			if(factura.getNumero() == id) {
				return factura;
			}
		}
		return null;
	}
	
	public Cheque getChequeModel(int id) {
		for(Cheque chq: cheques) {
			if(chq.getNumero() == id) {
				return chq;
			}
		}
		return null;
	}
	
	public NotaDeCredito getNCModel(int id) {
		for(NotaDeCredito nc: notasDeCredito) {
			if(nc.getNumero() == id) {
				return nc;
			}
		}
		return null;
	}
	
	public NotaDeDebito getNDModel(int id) {
		for(NotaDeDebito nd: notasDeDebito) {
			if(nd.getNumero() == id) {
				return nd;
			}
		}
		return null;
	}

	public static synchronized DocumentoController getInstance() {
		if (INSTANCE == null) {
			try {
				facturaDao = new FacturaDao(Factura.class,getPathOutModel(Factura.class.getSimpleName()));
				notaDeCreditoDao = new NotaDeCreditoDao(NotaDeCredito.class,getPathOutModel(NotaDeCredito.class.getSimpleName()));
				notaDeDebitoDao = new NotaDeDebitoDao(NotaDeDebito.class,getPathOutModel(NotaDeDebito.class.getSimpleName()));
				ordenDeCompraDao = new OrdenDeCompraDao(OrdenDeCompra.class,getPathOutModel(OrdenDeCompra.class.getSimpleName()));
				chequeDao = new ChequeDao(Cheque.class,getPathOutModel(Cheque.class.getSimpleName()));
				INSTANCE = new DocumentoController(initFacturas(), initNotasDeCredito(), initNotasDeDebito(), initOrdenesDeCompra(), initCheques());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return INSTANCE;
	}
	
	public List<FacturaDto> getFacturas(){
		List<FacturaDto> dtoList = new ArrayList<>();
        for (Factura factura : facturas) {
            dtoList.add(toDto(factura));
        }
        return dtoList;
	}
	
	public List<FacturaDto> getFacturasByFilter(Date fecha) {
		List<FacturaDto> dtoList = new ArrayList<>();
        for (Factura factura : facturas) {
        	if(factura.getFecha().equals(fecha)) {
        		dtoList.add(toDto(factura));
        	}
        }
        return dtoList;
	}
	
	public List<FacturaDto> getFacturasByFilter(int cuit) {
		List<FacturaDto> dtoList = new ArrayList<>();
        for (Factura factura : facturas) {
        	if(factura.getProveedor() == cuit) {
        		dtoList.add(toDto(factura));
        	}
        }
        return dtoList;
	}
	
	public List<FacturaDto> getFacturasByFilter(Date fecha, int cuit) {
		List<FacturaDto> dtoList = new ArrayList<>();
        for (Factura factura : facturas) {
        	if(factura.getFecha().equals(fecha) && factura.getProveedor() == cuit) {
        		dtoList.add(toDto(factura));
        	}
        }
        return dtoList;
	}
	
	public List<NotaDto> getNotasDeCredito(){
		List<NotaDto> dtoList = new ArrayList<>();
        for (NotaDeCredito notaDeCredito : notasDeCredito) {
            dtoList.add(toDto(notaDeCredito));
        }
        return dtoList;
	}
	
	public List<NotaDto> getNotasDeDebito(){
		List<NotaDto> dtoList = new ArrayList<>();
        for (NotaDeDebito notaDeDebito : notasDeDebito) {
            dtoList.add(toDto(notaDeDebito));
        }
        return dtoList;
	}
	
	public List<OrdenDeCompraDto> getOrdenesDeComrpra(){
		List<OrdenDeCompraDto> dtoList = new ArrayList<>();
        for (OrdenDeCompra ordenDeCompra : ordenesDeCompra) {
            dtoList.add(toDto(ordenDeCompra));
        }
        return dtoList;
	}
	
	public List<ChequeDto> getCheques(){
		List<ChequeDto> dtoList = new ArrayList<>();
        for (Cheque cheque : cheques) {
            dtoList.add(toDto(cheque));
        }
        return dtoList;
	}
	
	public List<ImpuestoRetenidoDto> getImpuestosRetenidos(){
		List<ImpuestoRetenidoDto> impuestosRetenidos = new ArrayList<>();
		for(Factura f: facturas) {
			impuestosRetenidos.add(new ImpuestoRetenidoDto(f.getNumero(), f.getTotalARetener(), f.getImpuestos()));
		}
		return impuestosRetenidos;
	}
	
	public List<LibroIvaDto> getLibroIva(){
		try {
			ProveedorController pController = ProveedorController.getInstance();
			List<LibroIvaDto> libroIva = new ArrayList<>();
			for(Factura f: facturas) {
				for(ItemDeFactura item: f.getProductos()) {
					libroIva.add(new LibroIvaDto(f.getProveedor(), pController.getProveedor(f.getProveedor()).getNombre(), f.getFecha(), item.getImpuesto().getPorcentaje(), (item.getImpuesto().getPorcentaje()*item.getImporte())/100 ));
				}
			}
			return libroIva;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<OrdenesDePagoDto> getOrdenesDePago(){
		List<OrdenesDePagoDto> dtoList = new ArrayList<>();
        for (Factura f: facturas) {
            dtoList.add(new OrdenesDePagoDto(f.getNumero(), f.getOrdenDePago())); 
        }
        return dtoList;
	}
	
	public void addFactura(FacturaDto facturaDto) {
		try {
			Factura facturaNueva = new Factura(facturaDto, facturas.size()+1);
			facturas.add(facturaNueva);
			facturaDao.save(facturaNueva);
			addDocumentToProveedor(facturaNueva.getProveedor(), facturaNueva);
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	public void addNotaCredito(NotaDto notaDto) {
		try {
			NotaDeCredito notaDeCredito = new NotaDeCredito(notaDto, notasDeCredito.size()+1);
			notasDeCredito.add(notaDeCredito);
			notaDeCreditoDao.save(notaDeCredito);
			addDocumentToProveedor(notaDeCredito.getProveedor(), notaDeCredito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNotaDebito(NotaDto notaDto) {
		try {
			NotaDeDebito notaDeDebito = new NotaDeDebito(notaDto, notasDeDebito.size()+1);
			notasDeDebito.add(notaDeDebito);
			notaDeDebitoDao.save(notaDeDebito);
			addDocumentToProveedor(notaDeDebito.getProveedor(), notaDeDebito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addOrdenDeCompra(OrdenDeCompraDto ordenDeCompraDto) {
		try {
			OrdenDeCompra ordenDeCompra = new OrdenDeCompra(ordenDeCompraDto, ordenesDeCompra.size()+1);
			ordenesDeCompra.add(ordenDeCompra);
			ordenDeCompraDao.save(ordenDeCompra);
			addDocumentToProveedor(ordenDeCompra.getProveedor(), ordenDeCompra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addCheque(ChequeDto chequeDto) {
		try {
			Cheque cheque = new Cheque(chequeDto, cheques.size()+1);
			cheques.add(cheque);
			chequeDao.save(cheque);
			addDocumentToProveedor(cheque.getProveedor(), cheque);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarFactura(int id) {
        try {
            for(Factura f: facturas) {
                if(f.getNumero() == id) {
                	facturas.remove(f);
                    facturaDao.saveAll(facturas);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void elimiarNotasDeCredito(int id) {
		try {
			for(NotaDeCredito n: notasDeCredito) {
				if(n.getNumero() == id) {
					notasDeCredito.remove(n);
					notaDeCreditoDao.saveAll(notasDeCredito);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void elimiarNotasDeDebito(int id) {
		try {
			for(NotaDeDebito n: notasDeDebito) {
				if(n.getNumero() == id) {
					notasDeDebito.remove(n);
					notaDeDebitoDao.saveAll(notasDeDebito);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarOrdenDeCompra(int id) {
		try {
			for(OrdenDeCompra o: ordenesDeCompra) {
				if(o.getNumero() == id) {
					ordenesDeCompra.remove(o);
					ordenDeCompraDao.saveAll(ordenesDeCompra);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarCheque(int id) {
		try {
			for(Cheque c: cheques) {
				if(c.getNumero() == id) {
					cheques.remove(c);
					chequeDao.saveAll(cheques);
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getPathOutModel(String name){
        String dir = "./datos/";
        return  new File(dir+name+".json").getPath();
    }
	
	public static FacturaDto toDto(Factura factura){
        return new FacturaDto(factura);
    }
	
	public static NotaDto toDto(NotaDeDebito notaDeDebito){
        return new NotaDto(notaDeDebito);
    }
	
	public static NotaDto toDto(NotaDeCredito notaDeCredito){
        return new NotaDto(notaDeCredito);
    }
	
	public static OrdenDeCompraDto toDto(OrdenDeCompra ordenDeCompra){
        return new OrdenDeCompraDto(ordenDeCompra);
    }
	
	public static ChequeDto toDto(Cheque cheque){
        return new ChequeDto(cheque);
    }
	
	private static List<Factura> initFacturas(){
        try {
        	facturas = facturaDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return  facturas;
    }

	private static List<NotaDeCredito> initNotasDeCredito(){
		try {
			notasDeCredito = notaDeCreditoDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  notasDeCredito;
	}

	private static List<NotaDeDebito> initNotasDeDebito(){
		try {
			notasDeDebito = notaDeDebitoDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  notasDeDebito;
	}

	private static List<OrdenDeCompra> initOrdenesDeCompra(){
		try {
			ordenesDeCompra = ordenDeCompraDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  ordenesDeCompra;
	}

	private static List<Cheque> initCheques(){
		try {
			cheques = chequeDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  cheques;
	}
	
	private static void syncOcEnFacturas(DocumentoController dc) {
		try {
			for(Factura f: facturas) {
				OrdenDeCompra ordenDeCompraSync = dc.getOcModel(f.getNumero());
				f.setOrdenCompra(ordenDeCompraSync);
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void syncNotasEnOp(DocumentoController dc) {
		try {
			for(Factura f: facturas) {
				List<OrdenDePago> ordenesPago = f.getOrdenDePago();
				if(ordenesPago != null) {
					for(OrdenDePago op: ordenesPago) {
						List<Cheque> chqSync = new ArrayList<Cheque>();
						for(Cheque chq: op.getCheques()) {
							chqSync.add(dc.getChequeModel(chq.getNumero()));
						}
						op.setCheques(chqSync);
						
						List<NotaDeCredito> ncSync = new ArrayList<NotaDeCredito>();
						for(NotaDeCredito nc: op.getNotasCredito()) {
							ncSync.add(dc.getNCModel(nc.getNumero()));
						}
						op.setNotasCredito(ncSync);
						
						List<NotaDeDebito> ndSync = new ArrayList<NotaDeDebito>();
						for(NotaDeDebito nd: op.getNotasDebito()) {
							ndSync.add(dc.getNDModel(nd.getNumero()));
						}
						op.setNotasDebito(ndSync);
					}
				}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void addDocumentToProveedor(int cuit, Documento d) {
		ProveedorController pController;
		try {
			pController = ProveedorController.getInstance();
			pController.agregarDocumento(cuit, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
