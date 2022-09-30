package Money;

public class SaldoInsuficienteException extends Exception {
		static final long serialVersionUID = 1L; 
		
		public SaldoInsuficienteException(String message)
	    {
	       super(message);
	    }
}
