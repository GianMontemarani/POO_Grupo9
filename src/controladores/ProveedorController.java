 package controladores;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import dao.ProveedorDao;
import dto.CuentaCorrienteProveedorDto;
import dto.FacturaDto;
import dto.PreciosProveedorDto;
import dto.ProveedorDto;
import modelo.CertificadoRetencion;
import modelo.Documento;
import modelo.Factura;
import modelo.OrdenDePago;
import modelo.Producto;
import modelo.Proveedor;

public class ProveedorController {
		private static ProveedorController INSTANCE = null;
		
		private static List<Proveedor> proveedoresList;
		
		private static ProveedorDao proveedorDao;
		
		private ProveedorController(List<Proveedor> proveedoresList) {ProveedorController.proveedoresList = proveedoresList;}
		
		public Proveedor getProveedorModel(int cuit) {
			try {
				for(Proveedor p: proveedoresList) {
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
		

		public ProveedorDto getProveedor(int cuit){
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
        }
		
		public float getDeudaXProveedor(int cuit) {
			float deuda = 0;
			Proveedor p = this.getProveedorModel(cuit);
			if(p != null) {
				for(Factura f: p.getFacturas()) {
					deuda += f.getDeuda();
				}
				return deuda;
			}else {
				return 0;
			}
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
			List<PreciosProveedorDto> preciosPorProveedor = new ArrayList<>();
			for(Proveedor p: proveedoresList) {
				if(p.tieneProducto(id)) {
					preciosPorProveedor.add(new PreciosProveedorDto(p.getCuit(), p.getRazonSocial(), p.getPrecioProducto(id)));
				}
			}
			return preciosPorProveedor;
		}
		
		public void agregarCertifiacado(int cuit, CertificadoRetencion cr) {
			try {
				this.getProveedorModel(cuit).addCertificado(cr);
				proveedorDao.saveAll(proveedoresList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void eliminarCertificado(int cuit, int index) {
			try {
				this.getProveedorModel(cuit).deleteCertificado(index);
				proveedorDao.saveAll(proveedoresList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void agregarProducto(int cuit, int id) {
			try {
				ProductoController productoController = ProductoController.getInstance();
				Producto p = productoController.getProductoModel(id);
				this.getProveedorModel(cuit).addProducto(p);
				proveedorDao.saveAll(proveedoresList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void eliminarProducto(int cuit, int id) {
			try {
				ProductoController productoController = ProductoController.getInstance();
				Producto p = productoController.getProductoModel(id);
				this.getProveedorModel(cuit).deleteProducto(p);
				proveedorDao.saveAll(proveedoresList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void agregarDocumento(int cuit, Documento d) {
			Proveedor p = this.getProveedorModel(cuit);
			if(p != null) {
				try {
					p.addDocumento(d);
					proveedorDao.saveAll(proveedoresList);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
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
	        	syncProductos();
	        } catch (Exception e) {
				e.printStackTrace();
			}
	        return  proveedoresList;
		}
		
		private static void syncProductos() {
			ProductoController pController;
			try {
				pController = ProductoController.getInstance();
				for(Proveedor p: proveedoresList) {
	        		List<Producto> productos = p.getProductos();
	        		List<Producto> productosSync = new ArrayList<Producto>();
	        		if(productos !=null) {
	        			if(productos.size() > 0) {
		        			for(Integer i: p.getProductosId()) {
		        				productosSync.add(pController.getProductoModel(i));
		        			}
		        		}
	        			p.setProductos(productosSync);
	        		}
	        	}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}