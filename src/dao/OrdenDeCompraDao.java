package dao;

import modelo.OrdenDeCompra;
import util.GenericDAO;

public class OrdenDeCompraDao extends GenericDAO<OrdenDeCompra>{
	public OrdenDeCompraDao(Class<OrdenDeCompra> clase, String file) throws Exception {
        super(clase, file);
    }
}
