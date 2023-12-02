package dao;

import modelo.Proveedor;
import util.GenericDAO;

public class ProveedorDao extends GenericDAO<Proveedor>{
	public ProveedorDao(Class<Proveedor> clase, String file) throws Exception {
        super(clase, file);
    }
}
