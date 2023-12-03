package controladores;

import modelo.Usuario;
import util.GenericDAO;

public class UsuarioDao extends GenericDAO<Usuario>{
	public UsuarioDao(Class<Usuario> clase, String file) throws Exception {
        super(clase, file);
    }
}