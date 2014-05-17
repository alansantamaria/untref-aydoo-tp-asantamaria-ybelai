package untref.tp.tierramedia;

import java.util.Date;

public class PromocionFamiliar extends Promocion {
	private final int umbralDeEntradas = 4;
	private final double descuentoUmbralDeEntradas = 10.0;
	private final double descuentoMasDelUmbralDeEntradas = 30.0;
	public PromocionFamiliar(Date vigencia) {
		super(vigencia);
	}

	public double aplicarDescuento(Atraccion atraccion, int cantidadDeEntradas) {
		if (cantidadDeEntradas == umbralDeEntradas) {
			return (atraccion.getCosto() * cantidadDeEntradas) - (umbralDeEntradas * (atraccion.getCosto() * descuentoUmbralDeEntradas) / 100 );
		}
		double precio = 0;
		if (cantidadDeEntradas > umbralDeEntradas) {
			precio = (atraccion.getCosto() * umbralDeEntradas) - (umbralDeEntradas * (atraccion.getCosto() * descuentoUmbralDeEntradas) / 100 );
			for (int i = umbralDeEntradas; i < cantidadDeEntradas; i++) {
				precio += (atraccion.getCosto() - (atraccion.getCosto() * descuentoMasDelUmbralDeEntradas) / 100);
			}
		}
		if (cantidadDeEntradas < umbralDeEntradas) {
			precio = cantidadDeEntradas * atraccion.getCosto();
		}
		return precio;
	}

	public boolean seAplicaPromocion (Paquete paquete) {
		if (paquete.getCantidadEntradas() >= umbralDeEntradas) {
			return true;
		}else{
			return false;
		}
	}

}
