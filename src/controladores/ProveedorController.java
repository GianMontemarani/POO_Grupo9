package controladores;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import dao.ProveedorDao;
import dto.ProveedorDto;
import modelo.Proveedor;

public class ProveedorController {
		private static ProveedorController INSTANCE = null;
		
		private static List<Proveedor> proveedoresList;
		
		private static ProveedorDao proveedorDao;
		
		private ProveedorController(List<Proveedor> proveedoresList) {ProveedorController.proveedoresList = proveedoresList;}
		
		public static synchronized ProveedorController getInstance() throws Exception{
			if(INSTANCE == null) {
				proveedorDao = new ProveedorDao(Proveedor.class,getPathOutModel(Proveedor.class.getSimpleName()));
				INSTANCE = new ProveedorController(initModel());
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
			           proveedoresList.add(toModel(proveedorDto));
			           proveedorDao.save(toModel(proveedorDto));
			    }else {
			        System.out.println("El cuit del proveedor ingresado ya existe");	
			    }
			} catch (Exception e) {
				e.printStackTrace();
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
		
		private static List<Proveedor> initModel(){
	        try {
	        	proveedoresList = proveedorDao.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return  proveedoresList;
	    }
}