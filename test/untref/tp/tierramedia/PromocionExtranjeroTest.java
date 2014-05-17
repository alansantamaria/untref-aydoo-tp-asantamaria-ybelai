package untref.tp.tierramedia;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class PromocionExtranjeroTest {
	@Test
	public void seAplicaPromocionDebeDevolverTrueSiLaDistanciaEsMayorA200(){

		double distancia = 300;
		PromocionExtranjero promocionExtranjero = new PromocionExtranjero(Calendar.getInstance().getTime());
		Assert.assertTrue(promocionExtranjero.seAplicaPromocion(distancia));
	}

	@Test
	public void seAplicaPromocionDebeDevolverFalseSiLaDistanciaEsMenorA200(){

		double distancia = 100;
		PromocionExtranjero promocionExtranjero = new PromocionExtranjero(Calendar.getInstance().getTime());
		Assert.assertFalse(promocionExtranjero.seAplicaPromocion(distancia));
	}
}
