package Test;
import java.util.List;

import controladores.ProveedorController;
import dto.ProveedorDto;

public class Test {

	public static void main(String[] args) throws Exception {
			ProveedorController proveedorController;
			proveedorController = ProveedorController.getInstance();
			
			try {
				List<ProveedorDto> proveedores = proveedorController.getAll();
				for(ProveedorDto p: proveedores) {
					System.out.println(p.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
