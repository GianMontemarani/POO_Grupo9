package dao;

import modelo.Factura;
import util.GenericDAO;

public class FacturaDao extends GenericDAO<Factura>{
	public FacturaDao(Class<Factura> clase, String file) throws Exception {
        super(clase, file);
    }
}
