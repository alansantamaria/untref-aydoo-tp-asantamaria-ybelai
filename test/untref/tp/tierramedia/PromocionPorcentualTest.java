package untref.tp.tierramedia;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class PromocionPorcentualTest {
	@Test
	public void calcularDescuentoDebeDevolverUnaAtraccionConCosto90CuandoElDescuentoEs10YElCostoDeLaAtraccionEs100(){
		Atraccion atraccion = new Atraccion(null, null, 100, 0, null, 0);
		
		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(Calendar.getInstance().getTime(), null, 10);
		
		Double costoEsperado = 90d;
		
		Assert.assertEquals(costoEsperado, promocionPorcentual.calcularDescuento(atraccion).getCosto(), 0.1);

	}

}
