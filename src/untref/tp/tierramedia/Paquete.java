package untref.tp.tierramedia;

import java.util.LinkedList;
import java.util.List;

public class Paquete {
	private List<Atraccion> atracciones;
	private Double duracion;
	private Double precio;
	private int cantidadEntradas;
	private double costoUltimaAtraccionAgregada = 0;
	private double duracionUltimaAtraccionAgregada = 0;

	public Paquete(List<Atraccion> atracciones, Double duracion, Double precio, int cantidadEntradas) {
		this.atracciones = atracciones;
		this.duracion = duracion;
		this.precio = precio;
	}

	public Paquete() {
		this.duracion = 0.0;
		this.precio = 0.0;
		this.atracciones = new LinkedList<Atraccion>();
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(double d) {
		this.duracion = d;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(double d) {
		this.precio = d;
	}

	public int getCantidadEntradas() {
		return cantidadEntradas;
	}

	public void setCantidadEntradas(int cantidadEntradas) {
		this.cantidadEntradas = cantidadEntradas;
	}

	public void addAtraccion(Atraccion atraccion, double duracionViaje, PromocionFamiliar promocionFamiliar, Perfil perfil) {
		if (promocionFamiliar != null) {
			precio += promocionFamiliar.aplicarDescuento(atraccion, perfil.getCandidadDeEntradas());
			costoUltimaAtraccionAgregada = promocionFamiliar.aplicarDescuento(atraccion, perfil.getCandidadDeEntradas());
		}else{
			precio += atraccion.getCosto() * perfil.getCandidadDeEntradas();
			costoUltimaAtraccionAgregada = atraccion.getCosto() * perfil.getCandidadDeEntradas();
		}
		duracion += duracionViaje;
		duracion += atraccion.getTiempo();
		duracionUltimaAtraccionAgregada = atraccion.getTiempo() + duracionViaje;
		this.atracciones.add(atraccion);
	}

	public void removeAtraccion(Atraccion atraccion, double duracionViaje) {
		atracciones.remove(atraccion);
		precio -= costoUltimaAtraccionAgregada;
		duracion -= duracionUltimaAtraccionAgregada;
	}
}
