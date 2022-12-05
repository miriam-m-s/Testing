package AgendaBreak;


public class Semana {

	    // Representa una semana de lunes a viernes.
	
	    public static final int DIAS_RESERVABLES = 5;
	    
	    // Numero de la semana en el año 20201 (1-53).
	    
	    private final int numeroSemana;
	    private final Dia[] dias;

	    /**
	      * @param numeroSemana (1-53).
	     */
	    public Semana(int numeroSemana) throws DatoException
	    {
	    	int diaDelAnio, numDia, diasPrimeraSemana;
	    	
	    	if (numeroSemana < 1 || numeroSemana > 53) {
				
				throw new DatoException("La semana debe tomar valor entre 1 y 53");
			}
	    	
	        this.numeroSemana = numeroSemana;
	        dias = new Dia[DIAS_RESERVABLES];
	        
	        numDia=Zeller(1,1,2020)-1;
        	diasPrimeraSemana= 7 - numDia;
        	diaDelAnio=1;
        	
	        if (numeroSemana > 1) {
	        	numDia=0;
	        	diaDelAnio = diasPrimeraSemana + (numeroSemana-1) * 7 + 1;
	        }
	        	
	        
	        for(int dia = numDia; dia < DIAS_RESERVABLES && diaDelAnio <= 366; dia++) {
	            dias[dia] = new Dia(diaDelAnio);
	            diaDelAnio++;
	        }
	    }

	    /**
	     * @param hora de la cita
	     * @param dia de la cita(1-5)
	     * @return Cita de un dia a una hora .
	     */
	    public String mostrarCita(int hora, int diaSemana) { 
	    	
	    	if (validoDia(diaSemana)) {
	    		
	    		if (getDia(diaSemana)!=null) {
	    		    return getDia(diaSemana).muestraCita(hora);
	    		}
	    		else  return "Dia no citable";
	    	
	    	}
	    
	    	else
	    		
	    		return "Dia no valido";
	    		
	    }

	    /**
	     * @param dia de la semana (1..DIAS_RESERVABLES).
	     * @return El Dia asociado, o null si dia de la semana
	     *         esta fuera de rango.
	     */
	    public Dia getDia(int diaSemana)
	    {
	        if(validoDia(diaSemana)) {
	            return dias[diaSemana];
	        }
	        else {
	            return null;
	        }
	    }

	    /**
	     * @return Numero de semana 
	     */
	    public int getNumeroSemana()
	    {
	        return numeroSemana;
	    }
	    
	   	    
	    public String primerHueco(int duracion) {
	    	
	    	String disponible;
	    	
	    	for(int dia = 1; dia < DIAS_RESERVABLES; dia++) {
	    		if (dias[dia] != null) {
		    		int hueco=dias[dia].buscaSlot(duracion);
		    		if (hueco!=-1)
		             { disponible= diaSemana(dia+1) + " " + hueco + ":00";
		    			return disponible;
		             }
	    		}
	    	}
	             
	    	return "No hay disponibilidad";
	    }
	    
	    /**
	     * @return Nombre Dia de la semana
	     */
	    public String diaSemana(int dia) {
	    
	    	String diaNombre;
	    	
	    	switch(dia) {
	    	 case 1: 
	    		 diaNombre="Lunes";
	    	     break;
	    	 case 2: 
	    		 diaNombre="Martes";
	    	     break;
	    	 case 3: 
	    		 diaNombre="Miercoles";
	    	     break;
	    	 case 4: 
	    		 diaNombre="Jueves";
	    	     break;
	    	 case 5: 
	    		 diaNombre="Viernes";

	    	 default: 
	    		 diaNombre="No citable";
	    	     break;
	    	 }
		    
		    return diaNombre;
	    }
	    
	    public boolean validoDia(int diaSemana){      
	    	
	    	return diaSemana >= 1 && diaSemana <= DIAS_RESERVABLES;
	    }
	    
	    public int Zeller (int q, int m, int y) {
	    	
	        final int[] DAYS_OF_WEEK = {6, 7, 1, 2, 3, 4, 5};

	        if (m < 3) {
	            m += 12;
	            y -= 1;
	        }

            int k = y % 100;
            int j = y / 100;

            int day = ((q + (((m + 1) * 26) / 10) + k + (k / 4) + (j / 4)) + (5 * j)) % 7;

	         return DAYS_OF_WEEK[day];
	     }
	    
	}
