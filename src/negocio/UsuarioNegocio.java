package negocio;

import entidad.Usuario;
import excepciones.InsertException;
import excepciones.ReadAllException;
import excepciones.UpdateException;

public interface UsuarioNegocio {

	public Usuario Login(Usuario usuario) throws ReadAllException;
	public boolean insert(Usuario usuario) throws InsertException;
	public boolean update(Usuario usuario) throws UpdateException;
}
