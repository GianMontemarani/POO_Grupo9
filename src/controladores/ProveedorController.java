package controladores;
import java.util.Collection;
import modelo.Proveedor;

public class ProveedorController {
	private Collection<Proveedor> proveedores;

	
	
	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Collection<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	
}
