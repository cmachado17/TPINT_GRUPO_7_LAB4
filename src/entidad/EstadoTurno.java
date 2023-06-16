package entidad;

public class EstadoTurno {
	
	private int codigo;
	private String descripcion;
	
	public EstadoTurno() {

	}

	public EstadoTurno(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoTurno [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
