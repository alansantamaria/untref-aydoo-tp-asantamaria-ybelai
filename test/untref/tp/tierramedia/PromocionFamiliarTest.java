package untref.tp.tierramedia;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class PromocionFamiliarTest {

	@Test
	public void aplicarDescuentoDebeDevolver10Para3EntradasDeUnaAtraccionDeCosto10(){

		Atraccion atraccion = new Atraccion(null, null, 10, 0 , null, 0);
		int cantidadDeEntradas = 3;

		PromocionFamiliar promocionFamiliar = new PromocionFamiliar(Calendar.getInstance().getTime());
		Double precioEsperado = 30d;

		Assert.assertEquals(precioEsperado, promocionFamiliar.aplicarDescuento(atraccion, cantidadDeEntradas), 0.1);

	}

	@Test
	public void aplicarDescuentoDebeDevolver36Para4EntradasDeUnaAtraccionDeCosto10(){

		Atraccion atraccion = new Atraccion(null, null, 10, 0 , null, 0);
		int cantidadDeEntradas = 4;

		PromocionFamiliar promocionFamiliar = new PromocionFamiliar(Calendar.getInstance().getTime());
		Double precioEsperado = 36d;

		Assert.assertEquals(precioEsperado, promocionFamiliar.aplicarDescuento(atraccion, cantidadDeEntradas), 0.1);

	}

	@Test
	public void aplicarDescuentoDebeDevolver43Para5EntradasDeUnaAtraccionDeCosto10(){

		Atraccion atraccion = new Atraccion(null, null, 10, 0 , null, 0);
		int cantidadDeEntradas = 5;

		PromocionFamiliar promocionFamiliar = new PromocionFamiliar(Calendar.getInstance().getTime());
		Double precioEsperado = 43d;

		Assert.assertEquals(precioEsperado, promocionFamiliar.aplicarDescuento(atraccion, cantidadDeEntradas), 0.1);

	}

	@Test
	public void aplicarDescuentoDebeDevolver50Para6EntradasDeUnaAtraccionDeCosto10(){

		Atraccion atraccion = new Atraccion(null, null, 10, 0 , null, 0);
		int cantidadDeEntradas = 6;

		PromocionFamiliar promocionFamiliar = new PromocionFamiliar(Calendar.getInstance().getTime());
		Double precioEsperado = 50d;

		Assert.assertEquals(precioEsperado, promocionFamiliar.aplicarDescuento(atraccion, cantidadDeEntradas), 0.1);

	}
}
