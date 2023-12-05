 package controladores;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import dao.ProveedorDao;
import dto.CuentaCorrienteProveedorDto;
import dto.PreciosProveedorDto;
import dto.ProveedorDto;
import modelo.CertificadoRetencion;
import modelo.Factura;
import modelo.OrdenDePago;
import modelo.Proveedor;

public class ProveedorController {
		private static ProveedorController INSTANCE = null;
		
		private static List<Proveedor> proveedoresList;
		
		private static ProveedorDao proveedorDao;
		
		private ProveedorController(List<Proveedor> proveedoresList) {ProveedorController.proveedoresList = proveedoresList;}
		
		private Proveedor getProveedorModel(int cuit) {
			try {
				for(Proveedor p: proveedorDao.getAll()) {
					if(p.getCuit() == cuit) {
						return p;
					}
				}
				return null;
			} catch (Exception e) {
				return null;
			}
		}
		
		public static synchronized ProveedorController getInstance() throws Exception{
			if(INSTANCE == null) {
				proveedorDao = new ProveedorDao(Proveedor.class,getPathOutModel(Proveedor.class.getSimpleName()));
				INSTANCE = new ProveedorController(initProvedores());
			}
			return INSTANCE;
		}

		public List<ProveedorDto> getAll() {
	        List<ProveedorDto> dtoList = new ArrayList<>();
	        for (Proveedor proveedor : proveedoresList) {
	            dtoList.add(toDto(proveedor));
	        }
	        return dtoList;
	    }
		
		public ProveedorDto getProveedor(int cuit) throws Exception {
	        for (Proveedor proveedor: proveedoresList) {
	            if (proveedor.getCuit() == cuit){
	                return toDto(proveedor);
	            }
	        }
	        return  null;
	    }
		
		public void addProveedor(ProveedorDto proveedorDto) {
			try {
				if(getProveedor(proveedorDto.getCuit()) == null){
			           proveedoresList.add(toModel(proveedorDto));
			           proveedorDao.save(toModel(proveedorDto));
			    }else {
			        System.out.println("El cuit del proveedor ingresado ya existe");	
			    }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void eliminarProveedor(int cuit) {
            try {
                for(Proveedor p: proveedoresList) {
                    if(p.getCuit() == cuit) {
                        proveedoresList.remove(p);
                        proveedorDao.saveAll(proveedoresList);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
		
		public float getDeudaXProveedor(int cuit) {
			float deuda = 0;
			for(Proveedor p: proveedoresList) {
				if(p.getCuit() == cuit) {
					for(Factura f: p.getFacturas()) {
						deuda += f.getDeuda();
					}
				}
			}
			return deuda;
		}
		
		public CuentaCorrienteProveedorDto getCuentaCorrientePorProveedor(int cuit) {
			for(Proveedor p: proveedoresList) {
				if(p.getCuit() == cuit) {
					CuentaCorrienteProveedorDto cuentaCorriente = new CuentaCorrienteProveedorDto(cuit);
					for(Factura f: p.getFacturas()) {
						float pago = 0;
						for(OrdenDePago op: f.getOrdenDePago()) {
							pago += op.getImporte();
						}
						if(pago < f.getImporte()) {
							cuentaCorriente.sumDeuda(f.getImporte() - pago);
							cuentaCorriente.addDocumentoImpago(f);
						}
					}
					return cuentaCorriente;
				}
			}
			return null;
		}
		
		public List<PreciosProveedorDto> getPrecioPorProducto(int id) {
			List<PreciosProveedorDto> preciosPorProveedor = new ArrayList<PreciosProveedorDto>();
			for(Proveedor p: proveedoresList) {
				if(p.tieneProducto(id)) {
					preciosPorProveedor.add(new PreciosProveedorDto(p.getCuit(), p.getRazonSocial(), p.getPrecioProducto(id)));
				}
			}
			return preciosPorProveedor;
		}
		
		public void agregarCertifiacado(int cuit, CertificadoRetencion cr) {
			this.getProveedorModel(cuit).addCertificado(cr);
			
		}
		
		public void eliminarCertificado(int cuit, int index) {
			this.getProveedorModel(cuit).deleteCertificado(index);
			
		}
		
		public static Proveedor toModel (ProveedorDto proveedorDto) {
			return new Proveedor(proveedorDto);
		}
		
		public static ProveedorDto toDto(Proveedor proveedor){
	        return new ProveedorDto(proveedor);
	    }
		
		private static String getPathOutModel(String name){
	        String dir = "./datos/";
	        return  new File(dir+name+".json").getPath();
	    }
		
		private static List<Proveedor> initProvedores(){
	        try {
	        	proveedoresList = proveedorDao.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return  proveedoresList;
	    }

}