package untref.tp.tierramedia;

import org.junit.Assert;
import org.junit.Test;

import untref.tp.tierramedia.excepciones.VelocidadDeTrasladoCeroException;



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
	
	@Test
	public void laDistanciaDebeSerRaizDeDosParaLasCoordenadasX1Y1X2Y2() {
		Coordenada c1 = new Coordenada(1, 1);
		Coordenada c2 = new Coordenada(2, 2);
		Double distancia = 1.41;
		Assert.assertEquals(distancia, c1.getDistanciaEntreCoordenadas(c2), 001);
	}
	
	@Test (expected = VelocidadDeTrasladoCeroException.class)  
	public void siLaVelocidadDeTrasladoEsCeroElMetodoGetTiempoTrasladoEntreCoordenadasDebeDevolverUnaExcepcionDelTipoVelocidadDeTrasladoCeroException() throws VelocidadDeTrasladoCeroException {
		Coordenada c1 = new Coordenada (1, 1);
		Coordenada c2 = new Coordenada (2, 2);
		int velocidadTraslado = 0;
		c1.getTiempoTrasladoEntreCoordenadas(c2, velocidadTraslado);
	}
	
	@Test 
	public void siLaVelocidadDeTrasladoNoEsCeroElMetodoGetTiempoTrasladoEntreCoordenadasDebeDevolver1ParaVelocidadDeTraslado2() throws VelocidadDeTrasladoCeroException {
		Coordenada c1 = new Coordenada (1, 1);
		Coordenada c2 = new Coordenada (2, 2);
		int velocidadTraslado = 2;
		double tiempoTrasladoEntreCoordenadas = 0.7;
		Assert.assertEquals(tiempoTrasladoEntreCoordenadas, c1.getTiempoTrasladoEntreCoordenadas(c2, velocidadTraslado), 0.1);
	}

}

