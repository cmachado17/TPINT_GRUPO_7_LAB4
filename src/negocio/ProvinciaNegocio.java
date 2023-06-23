package negocio;

import java.util.ArrayList;

import entidad.Provincia;
import excepciones.ReadAllException;

public interface ProvinciaNegocio {

	public ArrayList<Provincia> obtenerProvincias() throws ReadAllException;
	
}
