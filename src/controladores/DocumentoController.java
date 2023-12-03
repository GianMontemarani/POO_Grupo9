package controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.ChequeDao;
import dao.FacturaDao;
import dao.NotaDeCreditoDao;
import dao.NotaDeDebitoDao;
import dao.OrdenDeCompraDao;
import dto.FacturaDto;
import dto.NotaDto;
import modelo.Cheque;
import modelo.Factura;
import modelo.NotaDeCredito;
import modelo.NotaDeDebito;
import modelo.OrdenDeCompra;

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
	
	public List<FacturaDto> getFacturas() throws Exception{
		List<FacturaDto> dtoList = new ArrayList<>();
        for (Factura factura : facturas) {
            dtoList.add(toDto(factura));
        }
        return dtoList;
	}
	
	public void addFactura(FacturaDto facturaDto) {
		try {
			Factura facturaNueva = new Factura(facturaDto, facturas.size()+1);
			facturas.add(facturaNueva);
			facturaDao.save(facturaNueva);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<NotaDto> geNotasDeCredito() throws Exception{
		List<NotaDto> dtoList = new ArrayList<>();
        for (NotaDeCredito notaDeCredito : notasDeCredito) {
            dtoList.add(toDto(notaDeCredito));
        }
        return dtoList;
	}
	
	public List<NotaDto> geNotasDeDebito() throws Exception{
		List<NotaDto> dtoList = new ArrayList<>();
        for (NotaDeDebito notaDeDebito : notasDeDebito) {
            dtoList.add(toDto(notaDeDebito));
        }
        return dtoList;
	}
	
	public void addNotaCredito(NotaDto notaDto) {
		try {
			NotaDeCredito notaDeCredito = new NotaDeCredito(notaDto, notasDeCredito.size()+1);
			notasDeCredito.add(notaDeCredito);
			notaDeCreditoDao.save(notaDeCredito);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNotaDebito(NotaDto notaDto) {
		try {
			NotaDeDebito notaDeDebito = new NotaDeDebito(notaDto, notasDeDebito.size()+1);
			notasDeDebito.add(notaDeDebito);
			notaDeDebitoDao.save(notaDeDebito);
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
}
