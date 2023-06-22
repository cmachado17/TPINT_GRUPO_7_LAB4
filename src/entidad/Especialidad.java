package entidad;

public class Especialidad {
	
	private int codigo;
	private String descripcion;
	
	public Especialidad() {
		
	}
	
	public Especialidad(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public Especialidad(int codigo) {
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
		return "Especialidad [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
