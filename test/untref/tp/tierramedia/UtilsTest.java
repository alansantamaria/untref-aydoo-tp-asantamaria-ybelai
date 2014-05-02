package untref.tp.tierramedia;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void ordenarAtraccionesPorPrecioTest() {
		Atraccion a1 = new Atraccion("Quinta", EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion("Primera", EnumTipoDeAtraccion.AVENTURA, 20, 100, new Coordenada(10,10), 100);
		Atraccion a3 = new Atraccion("Tercera", EnumTipoDeAtraccion.AVENTURA, 50, 100, new Coordenada(10,10), 100);
		Atraccion a4 = new Atraccion("Segunda", EnumTipoDeAtraccion.AVENTURA, 30, 100, new Coordenada(10,10), 100);
		Atraccion a5 = new Atraccion("Cuarta", EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(10,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		Utils.ordenarAtraccionesPorPrecio(atracciones);
		Assert.assertEquals("Primera", atracciones.get(0).getNombre());
		Assert.assertEquals("Segunda", atracciones.get(1).getNombre());
		Assert.assertEquals("Tercera", atracciones.get(2).getNombre());
		Assert.assertEquals("Cuarta", atracciones.get(3).getNombre());
		Assert.assertEquals("Quinta", atracciones.get(4).getNombre());
	}
	
	@Test
	public void laDistanciaDebeSerRaizDeDosParaLasCoordenadasX1Y1X2Y2() {
		Coordenada c1 = new Coordenada(1, 1);
		Coordenada c2 = new Coordenada(2, 2);
		Double distancia = 1.41;
		Assert.assertEquals(distancia, Utils.getDistanciaEntreCoordenadas(c1, c2), 001);
	}
	
}
