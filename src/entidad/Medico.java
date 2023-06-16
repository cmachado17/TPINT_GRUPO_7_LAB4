package entidad;

import java.sql.Time;

public class Medico extends Persona {

	private Especialidad especialidad;
	private DiaSemana diaAtencion;
	private Time horarioInicioAtencion;
	private Time horarioFinAtencion;
	
	public Medico() {
		super();
	}

	public Medico(Especialidad especialidad, DiaSemana diaAtencion, Time horarioInicioAtencion,
			Time horarioFinAtencion) {
		super();
		this.especialidad = especialidad;
		this.diaAtencion = diaAtencion;
		this.horarioInicioAtencion = horarioInicioAtencion;
		this.horarioFinAtencion = horarioFinAtencion;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public DiaSemana getDiaAtencion() {
		return diaAtencion;
	}

	public void setDiaAtencion(DiaSemana diaAtencion) {
		this.diaAtencion = diaAtencion;
	}

	public Time getHorarioInicioAtencion() {
		return horarioInicioAtencion;
	}

	public void setHorarioInicioAtencion(Time horarioInicioAtencion) {
		this.horarioInicioAtencion = horarioInicioAtencion;
	}

	public Time getHorarioFinAtencion() {
		return horarioFinAtencion;
	}

	public void setHorarioFinAtencion(Time horarioFinAtencion) {
		this.horarioFinAtencion = horarioFinAtencion;
	}

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", diaAtencion=" + diaAtencion + ", horarioInicioAtencion="
				+ horarioInicioAtencion + ", horarioFinAtencion=" + horarioFinAtencion + "]";
	}

	

	
	
}
