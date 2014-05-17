package untref.tp.tierramedia;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PromocionAXBTest {
	@Test
	public void getAtraccionGratisConRequisitosCumplidosDebeDevolverLaAtraccionPrimera(){

		Atraccion atraccionGratis= new Atraccion("Primera", EnumTipoDeAtraccion.AVENTURA, 100, 100, new Coordenada(10,10), 100);
		Atraccion a2 = new Atraccion("Segunda", EnumTipoDeAtraccion.AVENTURA, 20, 100, new Coordenada(10,10), 100);
		Atraccion a3 = new Atraccion("Tercera", EnumTipoDeAtraccion.AVENTURA, 50, 100, new Coordenada(10,10), 100);
		Atraccion a4 = new Atraccion("Cuarta", EnumTipoDeAtraccion.AVENTURA, 30, 100, new Coordenada(10,10), 100);
		Atraccion a5 = new Atraccion("Quinta", EnumTipoDeAtraccion.AVENTURA, 60, 100, new Coordenada(10,10), 100);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);

		List<Atraccion> atraccionesRequeridas = new LinkedList<Atraccion>();
		atraccionesRequeridas.add(a2);
		atraccionesRequeridas.add(a3);

		PromocionAXB promocionAXB = new PromocionAXB(Calendar.getInstance().getTime(),atraccionesRequeridas, atraccionGratis);

		Assert.assertSame(atraccionGratis, promocionAXB.getAtraccionGratisConRequisitosCumplidos(atracciones));
	}

}
