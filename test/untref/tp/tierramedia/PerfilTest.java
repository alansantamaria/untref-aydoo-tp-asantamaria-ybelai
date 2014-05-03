package untref.tp.tierramedia;

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
	

}
