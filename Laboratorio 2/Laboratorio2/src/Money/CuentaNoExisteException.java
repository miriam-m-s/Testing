package Money;

public class CuentaNoExisteException extends Exception {
	static final long serialVersionUID = 1L; 
	
	public CuentaNoExisteException(String message)
    {
       super(message);
    }
}
