package entidad;

public class Administrador extends Persona {

	private int tipoUsuario;

	public Administrador() {
		
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Administrador [tipoUsuario=" + tipoUsuario + "]";
	}
}
