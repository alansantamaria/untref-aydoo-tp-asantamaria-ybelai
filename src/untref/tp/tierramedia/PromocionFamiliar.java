package untref.tp.tierramedia;

import java.util.Date;

public class PromocionFamiliar extends Promocion {
	private final int umbralDeEntradas = 4;
	private final double descuentoUmbralDeEntrada = 10.0;
	private final double descuentoMasDelUmbralDeEntradas = 30.0;
	public PromocionFamiliar(Date vigencia) {
		super(vigencia);
	}

	public double aplicarDescuento(Atraccion atraccion, int cantidadDeEntradas) {
		if (cantidadDeEntradas == umbralDeEntradas) {
			return (atraccion.getCosto() * cantidadDeEntradas) - (umbralDeEntradas * (atraccion.getCosto() * descuentoUmbralDeEntrada) / 100 );
		}
		double precio = 0;
		if (cantidadDeEntradas > umbralDeEntradas) {
			precio = (atraccion.getCosto() * cantidadDeEntradas) - (umbralDeEntradas * (atraccion.getCosto() * descuentoUmbralDeEntrada) / 100 );
			for (int i = umbralDeEntradas + 1; i < cantidadDeEntradas; i++) {
				precio += precio - (atraccion.getCosto() - (atraccion.getCosto() * descuentoMasDelUmbralDeEntradas) / 100);
			}
		}
		if (cantidadDeEntradas < umbralDeEntradas) {
			precio = cantidadDeEntradas * atraccion.getCosto();
		}
		return precio;
	}

	public boolean seAplicaPromoción (Paquete paquete) {
		if (paquete.getCantidadEntradas() >= umbralDeEntradas) {
			return true;
		}else{
			return false;
		}
	}

}
