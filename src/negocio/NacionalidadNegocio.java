package negocio;

import java.util.ArrayList;

import entidad.Nacionalidad;
import excepciones.ReadAllException;

public interface NacionalidadNegocio {

	public ArrayList<Nacionalidad> obtenerNacionalidades() throws ReadAllException;
}
