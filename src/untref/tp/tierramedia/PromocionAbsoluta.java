package untref.tp.tierramedia;

import java.util.Date;


public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(Date vigencia, double descuento) {
		super(vigencia);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public void aplicarDescuento(Paquete paquete) {
		 paquete.setPrecio(paquete.getPrecio() - descuento);
	}

}
