package AgendaBreak;

public class Dia {

	    public static final int PRIMERA_CITA = 9;
	    public static final int ULTIMA_CITA = 17;
	    public static final int MAX_CITAS_POR_DIA =	ULTIMA_CITA - PRIMERA_CITA ;
	    

	    private int diaNumero;
	    private Cita[] citas;

	    /**
	     * @param diaNumero numero del dia del año (1-365), si es correcto
	     */
	    public Dia(int diaNumero) throws DatoException{
	    
	    	if (diaNumero < 0 || diaNumero > 365){
	    		
	    		throw new DatoException("El dia debe tomar valor entre 1 y 365");
	    	}
	    	
	        this.diaNumero = diaNumero;
	        citas = new Cita[MAX_CITAS_POR_DIA];
	    }

	    /**
	     * Busca hueco para una cita
	     * @param duración de la cita para la que se busca hueco
	     * @return Hora más temprana para adjudicar la cita
	     *         Devuelve -1 si no es posible encontrar hueco
	     */ 
	    public int buscaSlot(int duracion)
	    
	    {   int hora;    
	    	int slot = 0, sigSlot;
	    	while (slot < MAX_CITAS_POR_DIA){ 
	    		if(citas[slot] == null) {
	            	hora = slot;
	                if(duracion == 1) {
	                	
	                      return hora;
	                }
	                else {
	                   
	                	int numSlots = duracion;
	                	sigSlot= slot + 1;
	                	
	                	while (numSlots > 0 && sigSlot < MAX_CITAS_POR_DIA && citas[sigSlot] == null ) { 
	                		
	                		numSlots--; 
	                	}

	                    if(numSlots == 0) {
	                      
	                    	return hora;
	                    }
	                    else {
	                    	
	                    	slot= sigSlot+1;
	                    }
	                }
	             }
	    	 slot++;
	        }
	    	
	    	return -1;
	    }
	        
	        

	    /**
	     * asignarCita.
	     * @param hora Inicio
	     * @param cita
	     * @return true si se asigno la cita,
	     *         false en otro caso.
	     */
	    public boolean asignarCita(int hora, Cita cita)
	    {
	    	int duracion = cita.getDuracion();
	        if(validaHora(hora) && huecoLibre(hora, duracion)) {
	        	
	            int horaIni = hora - PRIMERA_CITA;
        	    for(int i = 0; i < duracion; i++) {
	               citas[horaIni + i] = cita;
	            }
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	    
	    /**
	     * @param hora de inicio de cita
	     * @return La cita asignada a esa hora. Devuelve null si la hora no 
	     *         es valida o no existe cita en la hora indicada
	     */
	    public Cita getCita(int hora)
	    {
	        if(validaHora(hora)) {
	            return citas[hora - PRIMERA_CITA];
	        }
	        else {
	            return null;
	        }
	    }

	    /**
	     * String que devuelve la descripción de la cita asignada a la hora indicada.
	     */
	    
	    public String muestraCita(int hora){      
	    	
	    	if (validaHora(hora)) { 
	    	    int horaIni = hora - PRIMERA_CITA; 
	            if(citas[diaNumero] != null) {
	                return hora + ":00 " + citas[hora].getDescripcion();
	            }
	    	
	            else {
	                return "No existe";
	            }
	        }
	    	else {
                return "Hora valida";
            }
	    }

	    /**
	     * @return Numero de dia dentro del año (1-365).
	     */
	    public int getDiaNumero()
	    {
	        return diaNumero;
	    }
	    
	    /**
	     * @param hora 
	     * @return true si la hora está en el intervalo válido
	     *         false en otro caso.
	     */
	    public boolean validaHora(int hora)
	    {
	        return hora >= PRIMERA_CITA && hora <= ULTIMA_CITA;
	    }
	    /**
	     * @param hora de inicio de cita la cita
	     * @param duración de la cita
	     * @return true si hay hueco libre a partir de la hora indicada y de la duración requerida
	     *         false en otro caso.
	     */
	    public boolean huecoLibre(int hora, int duracion) {
	    	
	    	if (validaHora(hora)) {
		    	int horaIni = hora - PRIMERA_CITA;
	            if(citas[horaIni] == null) {
	            	duracion--;
		            for(int slot=horaIni; duracion > 0 && slot < MAX_CITAS_POR_DIA ; slot++) {
		          	  if (citas[slot] == null) {duracion--;}
	
		          	}
	   
		            return true;
	            }
	            else {return false;}
		    }
	    	else {return false;}
	    
	    }   
}
