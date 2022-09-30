package Money;

public class CuentaExisteException extends Exception {
	static final long serialVersionUID = 1L; 
	
	public CuentaExisteException(String message)
    {
       super(message);
    }
}
