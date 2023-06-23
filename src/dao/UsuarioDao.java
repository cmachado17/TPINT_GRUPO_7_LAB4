package dao;

import entidad.Usuario;
import excepciones.ReadAllException;

public interface UsuarioDao {
	
	public Usuario Login(Usuario usuario) throws ReadAllException;
}
