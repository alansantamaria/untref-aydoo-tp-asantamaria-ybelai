package untref.tp.tierramedia;

public class Usuario {

	private String nombreUsuario;
	private String contrasenia;
	private Perfil perfil;

	public Usuario(String nombreUsuario, String contrasenia, Perfil perfil) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.perfil = perfil;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
