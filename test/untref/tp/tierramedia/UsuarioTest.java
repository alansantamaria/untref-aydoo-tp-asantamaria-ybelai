package untref.tp.tierramedia;


import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

	
	Coordenada ubicacion = new Coordenada(20, 30);
	Coordenada domicilio = new Coordenada(20, 30);
	EnumTipoDeAtraccion tipoDeAtraccionFavorita = EnumTipoDeAtraccion.DEGUSTACION;
	Perfil perfil = new Perfil(1000, 20, 100, tipoDeAtraccionFavorita,
			ubicacion, domicilio);
	Usuario usuario = new Usuario("Jose", "Perez", perfil);
	@Test
	public void deberiaDevolverJoseSiSeLlamaJose(){
				
		
		Assert.assertEquals("Jose", usuario.getNombreUsuario());
				
	}
	
	@Test
	public void deberiaDevolverPerezSiSuContraseniaEsPerez(){
		
		Assert.assertEquals("Perez", usuario.getContrasenia());
				
	}

	@Test
	public void deberiaDevolverPedroSiCambiaNombreAPedro(){
				
		usuario.setNombreUsuario("Pedro");
		Assert.assertEquals("Pedro", usuario.getNombreUsuario());
				
	}
	@Test
	public void deberiaDevolverDiazSiCambiacontraseniaADiaz(){
				
		usuario.setContrasenia("Diaz");
		Assert.assertEquals("Diaz", usuario.getContrasenia());
				
	}
}
