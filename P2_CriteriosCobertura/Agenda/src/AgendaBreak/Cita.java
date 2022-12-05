package AgendaBreak;

public class Cita {

	    
	    private String descripcion;
	    private int duracion;

	    /**
	     * Crea una cita de una duración determinada
	     * @param descripcion de la cita.
	     * @param duracion de la cita en horas.
	     */
	    public Cita(String descripcion, int duracion)
	    {
	        this.descripcion = descripcion;
	        this.duracion = duracion;
	    }

	    /**
	     * @return descripcion de la cita.
	     */
	    public String getDescripcion()
	    {
	        return descripcion;
	    }
	    
	    /**
	     * @return duracion de la cita en horas
	     */
	    public int getDuracion()
	    {
	        return duracion;
	    }
	}
