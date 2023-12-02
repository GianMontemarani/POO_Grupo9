package dao;

import modelo.Producto;
import util.GenericDAO;

public class ProductoDao extends GenericDAO<Producto>{
	public ProductoDao(Class<Producto> clase, String file) throws Exception {
        super(clase, file);
    }
}
