package untref.tp.tierramedia;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PerfilTest {
	
	Coordenada ubicacion = new Coordenada(20, 30);
	Coordenada domicilio = new Coordenada(20, 30);
	EnumTipoDeAtraccion tipoDeAtraccionFavorita = EnumTipoDeAtraccion.DEGUSTACION;
	Perfil perfil1 = new Perfil(1000, 20, 100, tipoDeAtraccionFavorita,
			ubicacion, domicilio);

	@Test
	public void deberiaDevolver20SiTiempoDisponibleParaVisitasEs20() {

		int tiempoDisponibleParaVisitas = perfil1
				.getTiempoDisponibleParaVisitas();
		Assert.assertEquals(20, tiempoDisponibleParaVisitas);

	}

	@Test
	public void deberiaDevolver100SiVelocidadDeTransladoEs100() {

		int velocidadDeTraslado = perfil1.getVelocidadDeTranslado();
		Assert.assertEquals(100, velocidadDeTraslado);

	}

	@Test
	public void deberiaDevolverDegustacionSiTipoDeAtraccionFavoritaEsDegustacion() {

		Assert.assertEquals(tipoDeAtraccionFavorita,
				perfil1.getTipoDeAtraccionFavorita());

	}
	@Test
	public void deberiaDevolver1000SiElPresupuestoEs1000() {

		Assert.assertEquals(1000,
				perfil1.getPresupuesto());
	}
	
	@Test
	public void getDistanciaALaAtraccionMasCercanaAlDomicilioDebeDevolverLaDistanciaDeLaAtraccionConNombrePrimera() {
		Perfil perfil = new Perfil(0, 0, 0, null, null, new Coordenada(10,10));
		
		Atraccion a1 = new Atraccion("Primera", EnumTipoDeAtraccion.AVENTURA, 0, 0, new Coordenada(9,9), 0);
		Atraccion a2 = new Atraccion("Segunda", EnumTipoDeAtraccion.AVENTURA, 0, 0, new Coordenada(3,3), 0);
		Atraccion a3 = new Atraccion("Tercera", EnumTipoDeAtraccion.AVENTURA, 0, 0, new Coordenada(5,5), 0);
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		
		double distanciaALaAtraccionMasCercana = 1.4;
		Assert.assertEquals(distanciaALaAtraccionMasCercana, perfil.getDistanciaALaAtraccionMasCercanaAlDomicilio(atracciones), 0.1);
	}
}
