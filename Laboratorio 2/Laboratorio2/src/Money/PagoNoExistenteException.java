package Money;

public class PagoNoExistenteException extends Exception {
	static final long serialVersionUID = 1L; 
	
	public PagoNoExistenteException(String message)
    {
       super(message);
    }
}
