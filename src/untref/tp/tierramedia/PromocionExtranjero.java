package untref.tp.tierramedia;

import java.util.Date;
import java.util.List;

public class PromocionExtranjero extends Promocion {
	private final int distanciaRequerida = 200;
	private final double descuento = 50;
	public PromocionExtranjero(Date vigencia) {
		super(vigencia);
	}
	
	public boolean seAplicaPromocion(double distanciaDelDomicilioALaAtraccionMasCercana) {
		return distanciaDelDomicilioALaAtraccionMasCercana >= distanciaRequerida;
	}
	
	public void aplicarDescuento(List<Atraccion> atracciones) {
		for (Atraccion atraccion : atracciones) {
			atraccion.setCosto((atraccion.getCosto() * descuento) / 100);
		}
	}
}
