package dao;

import java.util.ArrayList;
import entidad.Paciente;


public interface PacienteDao {

	public boolean insert(Paciente paciente);
	public boolean delete(Paciente paciente_a_eliminar);
	public boolean update(Paciente paciente);
	public ArrayList<Paciente> readAll();
	public int dniNoExiste(Paciente paciente);
}
