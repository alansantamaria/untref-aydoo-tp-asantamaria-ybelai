package untref.tp.tierramedia;


public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(int vigencia, double descuento) {
		super(vigencia);
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public double calcularDescuento(double precioPaquete) {
		 return precioPaquete - descuento;
	}

}
