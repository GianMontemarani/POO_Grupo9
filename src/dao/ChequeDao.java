package dao;

import modelo.Cheque;
import util.GenericDAO;

public class ChequeDao extends GenericDAO<Cheque>{
	public ChequeDao(Class<Cheque> clase, String file) throws Exception {
        super(clase, file);
    }
}
