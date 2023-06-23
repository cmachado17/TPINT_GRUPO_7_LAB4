package negocio;

import entidad.Usuario;
import excepciones.ReadAllException;

public interface UsuarioNegocio {

	public Usuario Login(Usuario usuario) throws ReadAllException;
}
