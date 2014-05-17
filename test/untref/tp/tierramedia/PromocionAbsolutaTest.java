package untref.tp.tierramedia;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class PromocionAbsolutaTest {
	@Test
	public void aplicar10PorcientoDeDescuentoA100Devuelve90(){

		double precio = 100;
		Paquete paquete = new Paquete();
		paquete.setPrecio(precio);

		double descuento = 10;
		PromocionAbsoluta promocion = new PromocionAbsoluta(Calendar.getInstance().getTime(), descuento);

		double precioLuegoDelDescuento = 90;
		promocion.aplicarDescuento(paquete);
		Assert.assertEquals(precioLuegoDelDescuento, paquete.getPrecio(), 001);
	}

	@Test
	public void aplicar0PorcientoDeDescuentoA100Devuelve100(){

		double precio = 100;
		Paquete paquete = new Paquete();
		paquete.setPrecio(precio);

		double descuento = 0;
		PromocionAbsoluta promocion = new PromocionAbsoluta(Calendar.getInstance().getTime(), descuento);

		double precioLuegoDelDescuento = 100;
		promocion.aplicarDescuento(paquete);
		Assert.assertEquals(precioLuegoDelDescuento, paquete.getPrecio(), 001);
	}

}
