package dao;

import java.util.ArrayList;

import entidad.Nacionalidad;
import excepciones.ReadAllException;

public interface NacionalidadDao {

	public ArrayList<Nacionalidad> obtenerNacionalidades()throws ReadAllException;
}
