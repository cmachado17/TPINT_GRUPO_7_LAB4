package dao;

import java.util.ArrayList;

import entidad.Medico;
import entidad.Turno;


public interface TurnosDao {
	public boolean insert(Medico medico);
	public ArrayList<Turno> readAll();
	public ArrayList<Turno> turnosMedico(String dni);
}
