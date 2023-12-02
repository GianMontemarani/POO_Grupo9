package controladores;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.management.modelmbean.ModelMBean;

import dao.ProveedorDao;
import dto.ProveedorDto;
import modelo.Direccion;
import modelo.Proveedor;

public class ProveedorController {
		private static ProveedorController INSTANCE = null;
		
		private static List<Proveedor> proveedoresList;
		
		private static ProveedorDao proveedorDao;
		
		private ProveedorController(List<Proveedor> modelList) {this.proveedoresList = modelList;}
		
		public static synchronized ProveedorController getInstance() throws Exception{
			if(INSTANCE == null) {
				proveedorDao = new ProveedorDao(Proveedor.class,getPathOutModel(Proveedor.class.getSimpleName()));
				INSTANCE = new ProveedorController(initModel());
			}
			return INSTANCE;
		}
		
		public List<ProveedorDto> getAll() throws Exception {
	        List<ProveedorDto> dtoList = new ArrayList<>();
	        for (Proveedor proveedor : proveedorDao.getAll(Proveedor.class)) {
	            dtoList.add(toDto(proveedor));
	        }
	        return dtoList;
	    }
		
		public ProveedorDto getByCuit(int cuit) throws Exception {
	        for (Proveedor proveedor: proveedoresList) {
	            if (proveedor.getCuit() == cuit){
	                return toDto(proveedor);
	            }
	        }
	        return  null;
	    }
		
		public void addProveedor(ProveedorDto proveedorDto) {
			try {
				if(getByCuit(proveedorDto.getCuit()) == null){
			           proveedorDao.save(toModel(proveedorDto));
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static Proveedor toModel (ProveedorDto proveedorDto) {
			Direccion direccion = new Direccion(proveedorDto.getCalle(), proveedorDto.getAltura(), proveedorDto.getCodigoPostal(), proveedorDto.getPais(), proveedorDto.getProvincia(), proveedorDto.getCiudad());
			Proveedor proveedor = new Proveedor(proveedorDto.getCuit(), proveedorDto.getRazonSocial(), proveedorDto.getNombre(), direccion, proveedorDto.getTelefono(), proveedorDto.getCorreoElectronico(), proveedorDto.getInicioActividades(), proveedorDto.getRubros(), proveedorDto.getMaxDeuda());
			return proveedor;
		}
		
		public static ProveedorDto toDto(Proveedor proveedor){
	        return new ProveedorDto(proveedor);
	    }
		
		private static String getPathOutModel(String name){
	        String dir = "./datos/";
	        return  new File(dir+name+".json").getPath();
	    }
		
		private static List<Proveedor> initModel(){
	        try {
	        	proveedoresList = proveedorDao.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return  proveedoresList;
	    }
}