package untref.tp.tierramedia;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeSugerenciasTest {
	@Test
	public void ordenarAtraccionesPorPrecioTest() {
		Atraccion a1 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 20, 100, new Coordenada(10,10), 100);
		Atraccion a3 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 50, 100, new Coordenada(10,10), 100);
		Atraccion a4 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 30, 100, new Coordenada(10,10), 100);
		Atraccion a5 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(10,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		CreadorDeSugerencias CDS = new CreadorDeSugerencias (atracciones,  null);
		CDS.ordenarAtraccionesPorPrecio(atracciones);
		Assert.assertEquals(20, atracciones.get(0).getCosto(), 000);
		Assert.assertEquals(30, atracciones.get(1).getCosto(), 000);
		Assert.assertEquals(50, atracciones.get(2).getCosto(), 000);
		Assert.assertEquals(60, atracciones.get(3).getCosto(), 000);
		Assert.assertEquals(100, atracciones.get(4).getCosto(), 000);
	}
	
	@Test
	public void generarSugerenciaTest() {
		Atraccion a1 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 20, 150, new Coordenada(12,10), 100);
		Atraccion a3 = new Atraccion(EnumTipoDeAtraccion.DEGUSTACION, 50, 100, new Coordenada(10,14), 100);
		Atraccion a4 = new Atraccion(EnumTipoDeAtraccion.PAISAJE, 30, 100, new Coordenada(16,14), 100);
		Atraccion a5 = new Atraccion(EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(50,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		
		Perfil perfil = new Perfil(200, 300, 0, EnumTipoDeAtraccion.AVENTURA,new Coordenada(9, 9));
		Usuario usuario = new Usuario("test", "123", perfil);
		
		List<Atraccion> atraccionesConDescuento = new LinkedList<Atraccion>();
		atraccionesConDescuento.add(a1);
		Promocion p1 = new PromocionPorcentual(10, atraccionesConDescuento, 10);
		List<Promocion> promociones = new LinkedList<Promocion>();
		promociones.add(p1);
		CreadorDeSugerencias CDS = new CreadorDeSugerencias (atracciones,  promociones);
		List<Atraccion> sugerencia =  CDS.generarSugerencia(usuario); 
		List<Atraccion> atraccionesControl = new LinkedList<Atraccion>();
		atraccionesControl.add(a1);
		atraccionesControl.add(a2);
		Assert.assertSame(a1,sugerencia.get(0));
		Assert.assertSame(a2,sugerencia.get(1));
	}
	
}
