package dao;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Turno;
import excepciones.InsertException;
import excepciones.ReadAllException;


public interface TurnosDao {
	public boolean insert(Medico medico)throws InsertException;
	public ArrayList<Turno> readAll()throws ReadAllException;
	public ArrayList<Turno> turnosMedico(String dni)throws ReadAllException;
}
