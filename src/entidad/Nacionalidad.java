package entidad;

public class Nacionalidad {
	
	private int codigo;
	private String descripcion;
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Nacionalidad(int codigo) {
		this.codigo = codigo;
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
		return "Nacionalidad [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
