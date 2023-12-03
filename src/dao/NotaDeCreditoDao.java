package dao;

import modelo.NotaDeCredito;
import util.GenericDAO;

public class NotaDeCreditoDao extends GenericDAO<NotaDeCredito>{
	public NotaDeCreditoDao(Class<NotaDeCredito> clase, String file) throws Exception {
        super(clase, file);
    }
}
