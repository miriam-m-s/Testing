package Money;

public class PagoExistenteException extends Exception {
	static final long serialVersionUID = 1L; 
	
	public PagoExistenteException(String message)
    {
       super(message);
    }
}
