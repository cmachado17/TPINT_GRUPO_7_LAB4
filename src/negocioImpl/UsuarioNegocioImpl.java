package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao uDao = new UsuarioDaoImpl();

	@Override
	public Usuario Login(Usuario usuario) {
		return uDao.Login(usuario);
	}

}
