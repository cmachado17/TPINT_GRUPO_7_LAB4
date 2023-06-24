package negocioImpl;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidad.Persona;
import entidad.Usuario;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	UsuarioDao uDao = new UsuarioDaoImpl();

	@Override
	public Usuario Login(Usuario usuario) throws ReadAllException {
		return uDao.Login(usuario);
	}
	
	@Override
	public boolean insert(Usuario usuario) throws InsertException {
		return uDao.insert(usuario);
	}
	
	@Override
	public boolean update(Usuario usuario) throws UpdateException {
		return uDao.update(usuario);
	}

}
