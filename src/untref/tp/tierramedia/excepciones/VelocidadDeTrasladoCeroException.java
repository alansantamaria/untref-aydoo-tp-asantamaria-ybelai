package untref.tp.tierramedia.excepciones;

public class VelocidadDeTrasladoCeroException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "La velocidad de translado no puede ser cero.";
	}
}
