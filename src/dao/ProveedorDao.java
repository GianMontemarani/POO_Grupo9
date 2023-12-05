package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Proveedor;
import util.GenericDAO;

public class ProveedorDao extends GenericDAO<Proveedor>{
	public ProveedorDao(Class<Proveedor> clase, String file) throws Exception {
        super(clase, file);
    }

    @Override
    public void saveAll(List<Proveedor> proveedores) throws Exception {
    	List<Proveedor> proveedoresSinDocumentos = new ArrayList<Proveedor>();
    	for(Proveedor proveedor: proveedores) {
    		proveedoresSinDocumentos.add(new Proveedor(proveedor.getCuit(), proveedor.getRazonSocial(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getTelefono(), proveedor.getCorreoElectronico(), proveedor.getInicioActividades(), proveedor.getRubros(), proveedor.getMaxDeuda()));
    	}
    	
		
    	super.saveAll(proveedoresSinDocumentos);
    }
}
