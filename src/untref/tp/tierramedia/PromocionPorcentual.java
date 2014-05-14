package untref.tp.tierramedia;

import java.util.Date;
import java.util.List;

public class PromocionPorcentual extends Promocion {
	private double porcentaje;
	private List<Atraccion> atracciones;

	public PromocionPorcentual(Date vigencia, List<Atraccion> atracciones, double porcentaje) {
		super(vigencia);
		this.atracciones = atracciones;
		this.porcentaje = porcentaje;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public boolean tieneDescuento(Atraccion atraccion) {
		return this.atracciones.contains(atraccion);
	}

	public Atraccion calcularDescuento(Atraccion atraccion) {
		atraccion.setCosto((atraccion.getCosto()) - ((atraccion.getCosto() * porcentaje) / 100));
		atraccion.setSeAplicoPromocion(true);
		return atraccion;
	}
}
