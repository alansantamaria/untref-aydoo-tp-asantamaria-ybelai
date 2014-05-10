package untref.tp.tierramedia;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CreadorDeSugerenciasTest {
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
		CreadorDeSugerencias CDS = new CreadorDeSugerencias(atracciones, null, null, null);
		CDS.ordenarAtraccionesPorPrecio(atracciones);
		Assert.assertEquals("Primera", atracciones.get(0).getNombre());
		Assert.assertEquals("Segunda", atracciones.get(1).getNombre());
		Assert.assertEquals("Tercera", atracciones.get(2).getNombre());
		Assert.assertEquals("Cuarta", atracciones.get(3).getNombre());
		Assert.assertEquals("Quinta", atracciones.get(4).getNombre());
	}
	
	@Test
	public void getSugerenciasParaVisitarTest() {
		Atraccion a1 = new Atraccion("Ultima", EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion("Primera", EnumTipoDeAtraccion.AVENTURA, 20, 150, new Coordenada(10,10), 100);
		Atraccion a3 = new Atraccion("Tercera", EnumTipoDeAtraccion.AVENTURA, 50, 50, new Coordenada(10,10), 100);
		Atraccion a4 = new Atraccion("Segunda", EnumTipoDeAtraccion.DEGUSTACION, 30, 100, new Coordenada(10,10), 100);
		Atraccion a5 = new Atraccion("Cuarta", EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(10,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);

		Perfil perfil = new Perfil(200, 300, 0, EnumTipoDeAtraccion.AVENTURA, new Coordenada(1, 9), new Coordenada(1, 9));
		Usuario usuario = new Usuario("test", "123", perfil);

		List<Atraccion> atraccionesConDescuento1 = new LinkedList<Atraccion>();
		atraccionesConDescuento1.add(a1);
		atraccionesConDescuento1.add(a2);
		List<Atraccion> atraccionesConDescuento2 = new LinkedList<Atraccion>();
		atraccionesConDescuento2.add(a3);
		atraccionesConDescuento2.add(a4);
		PromocionPorcentual p1 = new PromocionPorcentual(Calendar.getInstance().getTime(), atraccionesConDescuento1, 10.0);
		PromocionPorcentual p2 = new PromocionPorcentual(Calendar.getInstance().getTime(), atraccionesConDescuento2, 10.0);
		List<PromocionPorcentual> promocionesPorcentuales = new LinkedList<PromocionPorcentual>();
		promocionesPorcentuales.add(p1);
		promocionesPorcentuales.add(p2);
		CreadorDeSugerencias CDS = new CreadorDeSugerencias (atracciones, null, promocionesPorcentuales, null);
		List<Atraccion> sugerencia =  CDS.getSugerenciasParaVisitar(usuario); 
		List<Atraccion> atraccionesControl = new LinkedList<Atraccion>();
		atraccionesControl.add(a1);
		atraccionesControl.add(a2);
		Assert.assertSame(a2,sugerencia.get(0));
		Assert.assertSame(a3,sugerencia.get(1));
		Assert.assertSame(a1,sugerencia.get(2));
	}

	@Test
	public void getPaqueteTest() {
		Atraccion a1 = new Atraccion("Ultima", EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion("Primera", EnumTipoDeAtraccion.AVENTURA, 20, 150, new Coordenada(10,10), 100);
		Atraccion a3 = new Atraccion("Tercera", EnumTipoDeAtraccion.AVENTURA, 50, 50, new Coordenada(10,10), 100);
		Atraccion a4 = new Atraccion("Segunda", EnumTipoDeAtraccion.DEGUSTACION, 30, 100, new Coordenada(10,10), 100);
		Atraccion a5 = new Atraccion("Cuarta", EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(10,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);

		Perfil perfil = new Perfil(200, 500, 0, EnumTipoDeAtraccion.AVENTURA, new Coordenada(1, 9), new Coordenada(1, 9));
		Usuario usuario = new Usuario("test", "123", perfil);

		List<Atraccion> atraccionesConDescuento1 = new LinkedList<Atraccion>();
		atraccionesConDescuento1.add(a1);
		atraccionesConDescuento1.add(a2);
		List<Atraccion> atraccionesConDescuento2 = new LinkedList<Atraccion>();
		atraccionesConDescuento2.add(a3);
		atraccionesConDescuento2.add(a4);
		PromocionPorcentual p1 = new PromocionPorcentual(Calendar.getInstance().getTime(), atraccionesConDescuento1, 10.0);
		PromocionPorcentual p2 = new PromocionPorcentual(Calendar.getInstance().getTime(), atraccionesConDescuento2, 10.0);
		List<PromocionPorcentual> promocionesPorcentuales = new LinkedList<PromocionPorcentual>();
		promocionesPorcentuales.add(p1);
		promocionesPorcentuales.add(p2);
		PromocionAbsoluta promAbs = new PromocionAbsoluta(Calendar.getInstance().getTime(), 100.0);
		PromocionAXB promAXB = new PromocionAXB(Calendar.getInstance().getTime(), atraccionesConDescuento1, a5);
		List<PromocionAXB> promocionesAXB = new LinkedList<PromocionAXB>();
		promocionesAXB.add(promAXB);
		CreadorDeSugerencias CDS = new CreadorDeSugerencias (atracciones, promAbs, promocionesPorcentuales, promocionesAXB);
		Paquete paquete = CDS.getPaquete(usuario);
		Paquete paqueteControl = new Paquete();
		List<Atraccion> atraccionesControl = new LinkedList<Atraccion>();
		atraccionesControl.add(a2);
		atraccionesControl.add(a3);
		atraccionesControl.add(a1);
		atraccionesControl.add(a5);
		paqueteControl.setAtracciones(atraccionesControl);
		
		Assert.assertEquals(53.0, paquete.getPrecio(), 0001);
		Assert.assertEquals(400.0, paquete.getDuracion(), 0001);
		Assert.assertSame(atraccionesControl.get(0), paquete.getAtracciones().get(0));
		Assert.assertSame(atraccionesControl.get(1), paquete.getAtracciones().get(1));
		Assert.assertSame(atraccionesControl.get(2), paquete.getAtracciones().get(2));
		Assert.assertSame(atraccionesControl.get(3), paquete.getAtracciones().get(3));
		
	}
	
}
