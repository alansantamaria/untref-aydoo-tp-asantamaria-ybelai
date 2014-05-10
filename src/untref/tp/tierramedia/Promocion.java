package untref.tp.tierramedia;

import java.util.Calendar;
import java.util.Date;


public abstract class Promocion {
	private Date vigencia;
	
	public Promocion(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	
	public boolean estaVigente() {
		return Calendar.getInstance().getTime().after(vigencia) ;
	}
}
