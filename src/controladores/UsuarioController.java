package controladores;

import java.io.File;
import java.util.List;

import dto.UsuarioDto;
import modelo.Usuario;

public class UsuarioController {
	private static UsuarioController INSTANCE = null;
	
	private static List<Usuario> usuarios;
	
	private static UsuarioDao usuariosDao;
	
	private UsuarioController(List<Usuario> usuarios) {UsuarioController.usuarios = usuarios;}
	
	public static synchronized UsuarioController getInstance() throws Exception{
		if(INSTANCE == null) {
			usuariosDao = new UsuarioDao(Usuario.class,getPathOutModel(Usuario.class.getSimpleName()));
			INSTANCE = new UsuarioController(initUsuario());
		}
		return INSTANCE;
	}
	
	public void addUsuario(UsuarioDto usuarioDto) {
		try {
			Usuario usuarioNuevo = new Usuario(usuarioDto, usuarios.size()+1);
			usuarios.add(usuarioNuevo);
			usuariosDao.save(usuarioNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UsuarioDto login(UsuarioDto usuarioDto) {
		try {
			for(Usuario usuario: usuarios) {
				if( usuarioDto.getUser().equals(usuario.getUser()) && usuarioDto.getPassword().equals(usuario.getPassword())) {
					return new UsuarioDto(usuario);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static UsuarioDto toDto(Usuario usuario){
        return new UsuarioDto(usuario);
    }
	
	private static String getPathOutModel(String name){
        String dir = "./datos/";
        return  new File(dir+name+".json").getPath();
    }
	
	private static List<Usuario> initUsuario(){
        try {
        	usuarios = usuariosDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return  usuarios;
    }
}
