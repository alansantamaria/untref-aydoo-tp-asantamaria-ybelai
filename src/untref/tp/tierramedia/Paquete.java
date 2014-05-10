package untref.tp.tierramedia;

import java.util.LinkedList;
import java.util.List;

public class Paquete {
	private List<Atraccion> atracciones;
	private Double duracion;
	private Double precio;
	
	public Paquete(List<Atraccion> atracciones, Double duracion, Double precio) {
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
	
	public void addAtraccion(Atraccion atraccion, double duracionViaje) {
		precio += atraccion.getCosto();
		duracion += atraccion.getTiempo();
		duracion += duracionViaje;
		this.atracciones.add(atraccion);
	}
	
}
