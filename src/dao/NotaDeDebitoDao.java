package dao;

import modelo.NotaDeDebito;
import util.GenericDAO;

public class NotaDeDebitoDao extends GenericDAO<NotaDeDebito>{
	public NotaDeDebitoDao(Class<NotaDeDebito> clase, String file) throws Exception {
        super(clase, file);
    }
}
