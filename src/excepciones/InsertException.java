package excepciones;

import java.io.IOException;

public class InsertException extends IOException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "No se pudo insertar en la base de datos";
	}
	
	

}
