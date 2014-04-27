package untref.tp.tierramedia;

import org.junit.Assert;
import org.junit.Test;

public class AtraccionTest {

	@Test
	public void getTipoDebeDevolverElTipoDeAtraccionIngresadoEnElConstructor() {
		EnumTipoDeAtraccion tipo = EnumTipoDeAtraccion.AVENTURA;
		double costo = 10;
		int tiempo = 10;
		Coordenada coordenada = new Coordenada (5,5);
		int cupoDeVisitantesDiarios = 10;
		Atraccion atraccion = new Atraccion(tipo, costo, tiempo, coordenada, cupoDeVisitantesDiarios);
		Assert.assertEquals(tipo, atraccion.getTipo());
	}
	
	@Test
	public void getCostoDebeDevolverElCostoDeAtraccionIngresadoEnElConstructor() {
		EnumTipoDeAtraccion tipo = EnumTipoDeAtraccion.AVENTURA;
		double costo = 10;
		int tiempo = 10;
		Coordenada coordenada = new Coordenada (5,5);
		int cupoDeVisitantesDiarios = 10;
		Atraccion atraccion = new Atraccion(tipo, costo, tiempo, coordenada, cupoDeVisitantesDiarios);
		Assert.assertEquals(costo, atraccion.getCosto(), 000);
	}
	
	@Test
	public void getCoordenadaDebeDevolverLaCoordenadaDeAtraccionIngresadoEnElConstructor() {
		EnumTipoDeAtraccion tipo = EnumTipoDeAtraccion.AVENTURA;
		double costo = 10;
		int tiempo = 10;
		Coordenada coordenada = new Coordenada (5,5);
		int cupoDeVisitantesDiarios = 10;
		Atraccion atraccion = new Atraccion(tipo, costo, tiempo, coordenada, cupoDeVisitantesDiarios);
		Assert.assertEquals(coordenada, atraccion.getPosicionamiento());
	}
	
	@Test
	public void getCupoDeVisitantesDiariosDebeDevolverCupoDeVisitantesDiariosIngresadoEnElConstructor() {
		EnumTipoDeAtraccion tipo = EnumTipoDeAtraccion.AVENTURA;
		double costo = 10;
		int tiempo = 10;
		Coordenada coordenada = new Coordenada (5,5);
		int cupoDeVisitantesDiarios = 10;
		Atraccion atraccion = new Atraccion(tipo, costo, tiempo, coordenada, cupoDeVisitantesDiarios);
		Assert.assertEquals(cupoDeVisitantesDiarios, atraccion.getCupoDeVisitantesDiarios());
	}
	
	@Test
	public void getTiempoDebeDevolverElTiempoIngresadoEnElConstructor() {
		EnumTipoDeAtraccion tipo = EnumTipoDeAtraccion.AVENTURA;
		double costo = 10;
		int tiempo = 10;
		Coordenada coordenada = new Coordenada (5,5);
		int cupoDeVisitantesDiarios = 10;
		Atraccion atraccion = new Atraccion(tipo, costo, tiempo, coordenada, cupoDeVisitantesDiarios);
		Assert.assertEquals(tiempo, atraccion.getTiempo());
	}
}
