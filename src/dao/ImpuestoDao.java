package dao;

import modelo.Impuesto;
import util.GenericDAO;

public class ImpuestoDao extends GenericDAO<Impuesto>{
	public ImpuestoDao(Class<Impuesto> clase, String file) throws Exception {
        super(clase, file);
    }
}
