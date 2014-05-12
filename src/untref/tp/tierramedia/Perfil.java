package untref.tp.tierramedia;

import java.util.List;

public class Perfil {
	private int presupuesto;
	private int tiempoDisponibleParaVisitas;
	private int velocidadDeTranslado;
	private EnumTipoDeAtraccion tipoDeAtraccionFavorita;
	private Coordenada ubicacion;
	private Coordenada domicilio;
	
	public Perfil(int presupuesto, int tiempoDisponibleParaVisitas,
			int velocidadDeTranslado,
			EnumTipoDeAtraccion tipoDeAtraccionFavorita, Coordenada ubicacion, Coordenada domicilio) {
		this.presupuesto = presupuesto;
		this.tiempoDisponibleParaVisitas = tiempoDisponibleParaVisitas;
		this.velocidadDeTranslado = velocidadDeTranslado;
		this.tipoDeAtraccionFavorita = tipoDeAtraccionFavorita;
		this.ubicacion = ubicacion;
		this.domicilio = domicilio;
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public int getTiempoDisponibleParaVisitas() {
		return tiempoDisponibleParaVisitas;
	}
	
	public void setTiempoDisponibleParaVisitas(int tiempoDisponibleParaVisitas) {
		this.tiempoDisponibleParaVisitas = tiempoDisponibleParaVisitas;
	}
	
	public int getVelocidadDeTranslado() {
		return velocidadDeTranslado;
	}
	
	public void setVelocidadDeTranslado(int velocidadDeTranslado) {
		this.velocidadDeTranslado = velocidadDeTranslado;
	}
	
	public EnumTipoDeAtraccion getTipoDeAtraccionFavorita() {
		return tipoDeAtraccionFavorita;
	}
	
	public void setTipoDeAtraccionFavorita(
			EnumTipoDeAtraccion tipoDeAtraccionFavorita) {
		this.tipoDeAtraccionFavorita = tipoDeAtraccionFavorita;
	}
	
	public Coordenada getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(Coordenada ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Coordenada getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Coordenada domicilio) {
		this.domicilio = domicilio;
	}
	
	public Double getDistanciaALaAtraccionMasCercanaAlDomicilio(List<Atraccion> atracciones) {
		double distanciaALaAtraccionMasCercana = 20000.0;
		for (Atraccion atraccion : atracciones) {
			if (distanciaALaAtraccionMasCercana > domicilio.getDistanciaEntreCoordenadas(atraccion.getPosicionamiento())) {
				distanciaALaAtraccionMasCercana = domicilio.getDistanciaEntreCoordenadas(atraccion.getPosicionamiento());
			}
		}
		return distanciaALaAtraccionMasCercana;
	}
}
