package untref.tp.tierramedia;

import org.junit.Assert;
import org.junit.Test;



public class CoordenadaTest {
	
	@Test
	public void getXDebeDevolverValorIngresadoEnElConstructor() {
		int valorX = 5;
		int valorY = 5;
		Coordenada coordenada = new Coordenada (valorX, valorY);
		Assert.assertEquals(valorX, coordenada.getX());
	}
	
	@Test
	public void getYDebeDevolverValorIngresadoEnElConstructor() {
		int valorX = 5;
		int valorY = 5;
		Coordenada coordenada = new Coordenada (valorX, valorY);
		Assert.assertEquals(valorX, coordenada.getY());
	}
	
	@Test
	public void getXDebeDevolverValorIngresadoEnSetX() {
		int valorX = 5;
		int valorY = 5;
		int valorXCambiado = 6;
		Coordenada coordenada = new Coordenada (valorX, valorY);
		coordenada.setX(valorXCambiado);
		Assert.assertEquals(valorXCambiado, coordenada.getX());
	}
	
	@Test
	public void getYDebeDevolverValorIngresadoEnSetY() {
		int valorX = 5;
		int valorY = 5;
		int valorYCambiado = 6;
		Coordenada coordenada = new Coordenada (valorX, valorY);
		coordenada.setY(valorYCambiado);
		Assert.assertEquals(valorYCambiado, coordenada.getY());
	}
	
	@Test
	public void equalsDebeDevolverFalseSiDosCoordenadasSonDistintas() {
		Coordenada coordenada1 = new Coordenada(5,5);
		Coordenada coordenada2 = new Coordenada(1,5);
		Assert.assertFalse(coordenada1.equals(coordenada2));
	}
	
	@Test
	public void equalsDebeDevolverTrueSiDosCoordenadasSonIguales() {
		Coordenada coordenada1 = new Coordenada(5,5);
		Coordenada coordenada2 = new Coordenada(5,5);
		Assert.assertTrue(coordenada1.equals(coordenada2));
	}
}
