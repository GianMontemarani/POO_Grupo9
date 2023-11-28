package controladores;
import java.util.ArrayList;
import java.util.List;

import dto.ProveedorDTO;
import modelo.Direccion;
import modelo.Proveedor;

public class ProveedorController {
		private static ProveedorController INSTANCE = null;
		
		private List<Proveedor> proveedoresList;
		
		private ProveedorController() {}
		
		public static synchronized ProveedorController getInstance() throws Exception{
			if(INSTANCE == null) {
				INSTANCE = new ProveedorController();
				INSTANCE.proveedoresList = new ArrayList<>();
			}
			return INSTANCE;
		}
		
		public void addProveedor(ProveedorDTO proveedorDto) {
			proveedoresList.add(toModel(proveedorDto));
			System.out.println("asdasdasda");
		}
		
		public static Proveedor toModel (ProveedorDTO proveedorDto) {
			Direccion direccion = new Direccion(proveedorDto.getCalle(), proveedorDto.getAltura(), proveedorDto.getCodigoPostal(), proveedorDto.getPais(), proveedorDto.getProvincia(), proveedorDto.getCiudad());
			Proveedor proveedor = new Proveedor(proveedorDto.getCuit(), proveedorDto.getRazonSocial(), proveedorDto.getNombre(), direccion, proveedorDto.getTelefono(), proveedorDto.getCorreoElectronico(), proveedorDto.getInicioActividades(), proveedorDto.getRubros(), proveedorDto.getMaxDeuda());
			return proveedor;
		}
}