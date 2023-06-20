package entidad;

public class Medico extends Persona {

	private Especialidad especialidad;
	private DiaSemana diaAtencion;
	private String horarioInicioAtencion;
	private String horarioFinAtencion;
	
	public Medico() {
		super();
	}
	

	public Medico(Especialidad especialidad, DiaSemana diaAtencion, String horarioInicioAtencion,
			String horarioFinAtencion) {
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

	public String getHorarioInicioAtencion() {
		return horarioInicioAtencion;
	}

	public void setHorarioInicioAtencion(String horarioInicioAtencion) {
		this.horarioInicioAtencion = horarioInicioAtencion;
	}

	public String getHorarioFinAtencion() {
		return horarioFinAtencion;
	}

	public void setHorarioFinAtencion(String horarioFinAtencion) {
		this.horarioFinAtencion = horarioFinAtencion;
	}

	@Override
	public String toString() {
		return "Medico [especialidad=" + especialidad + ", diaAtencion=" + diaAtencion + ", horarioInicioAtencion="
				+ horarioInicioAtencion + ", horarioFinAtencion=" + horarioFinAtencion + "]";
	}

	

	
	
}
