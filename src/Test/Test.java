package Test;
import java.util.ArrayList;
import java.util.Date;

import controladores.ProveedorController;
import dto.ProveedorDTO;
import modelo.Rubro;

public class Test {

	public static void main(String[] args) throws Exception {
			ProveedorController proveedorController;
			proveedorController = ProveedorController.getInstance();
			
			Rubro rubro = Rubro.LIBRERIA;
			ArrayList<Rubro> rubros = new ArrayList<>();
			rubros.add(rubro);
			
			Date fechaInicio = new Date();
			ProveedorDTO proveedor = new ProveedorDTO(
	                123456789, "Nombre Empresa", "Contacto", 123456789, "correo@empresa.com",
	                fechaInicio, rubros, 5000.0f, "Calle Principal", 123, 12345,
	                "País", "Provincia", "Ciudad"
	        );
			proveedorController.addProveedor(proveedor);
	}
}
