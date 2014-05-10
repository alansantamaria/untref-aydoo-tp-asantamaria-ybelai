package untref.tp.tierramedia;

import java.util.Date;
import java.util.List;

public class PromocionAXB extends Promocion {
	private List<Atraccion> atraccionesRequeridas;
	private Atraccion atraccionGratis;

	public PromocionAXB(Date vigencia, List<Atraccion> atraccionesRequeridas, Atraccion atraccionGratis) {
		super(vigencia);
		this.atraccionesRequeridas = atraccionesRequeridas;
		this.atraccionGratis = atraccionGratis;
	}

	public List<Atraccion> getAtraccionesRequeridas() {	
		return atraccionesRequeridas;
	}

	public void setAtraccionesRequeridas(List<Atraccion> atraccionesRequeridas) {
		this.atraccionesRequeridas = atraccionesRequeridas;
	}

	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	public void setAtraccionGratis(Atraccion atraccionGratis) {
		this.atraccionGratis = atraccionGratis;
	}

	public boolean tieneDescuento(List<Atraccion> atracciones) {
		return atracciones.containsAll(this.atraccionesRequeridas);
	}

	public Atraccion getAtraccionGratisConRequisitosCumplidos(List<Atraccion> atracciones) {
		if (tieneDescuento(atracciones)) {
			atraccionGratis.setCosto(0);
			return atraccionGratis;
		}else{
			return null;
		}
	}

}
