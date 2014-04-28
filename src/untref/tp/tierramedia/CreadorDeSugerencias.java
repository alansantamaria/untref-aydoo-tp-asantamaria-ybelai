package untref.tp.tierramedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class CreadorDeSugerencias {
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	private int distanciaMaxima = 10;

	/*
	 * @param  atracciones lista con todas las atracciones disponibles
	 * @param  promociones lista con todas las promociones vigentes
	 */
	public CreadorDeSugerencias (List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promociones = promociones;
	}

	public List<Atraccion> generarSugerencia(Usuario usuario) {
		List<Atraccion> atraccionesPreSeleccionadas = atracciones;
		ordenarAtraccionesPorPrecio(atraccionesPreSeleccionadas);
		filtrarPorTipoDeAtraccionPreferidaDelUsuario(usuario.getPerfil().getTipoDeAtraccionFavorita(), atraccionesPreSeleccionadas);
		filtrarPorCercania(usuario.getPerfil().getUbicacion(), atraccionesPreSeleccionadas);
		List<Atraccion> atraccionesConDescuento = getAtraccionesConDescuento(atraccionesPreSeleccionadas);
		atraccionesPreSeleccionadas.removeAll(atraccionesConDescuento);
		List<Atraccion> atraccionesSeleccionadas = new LinkedList<Atraccion>();
		double precioSum = 0;
		int tiempoSum = 0;
		for (Atraccion atraccion : atraccionesConDescuento) {
			precioSum = precioSum + atraccion.getCosto();
			tiempoSum = tiempoSum + atraccion.getTiempo();
			if (precioSum < usuario.getPerfil().getPresupuesto() && tiempoSum < usuario.getPerfil().getTiempoDisponibleParaVisitas()) {
				atraccionesSeleccionadas.add(atraccion);
			}else{
				break;
			}
		}

		for (Atraccion atraccion : atraccionesPreSeleccionadas) {
			precioSum = precioSum + atraccion.getCosto();
			tiempoSum = tiempoSum + atraccion.getTiempo();
			if (precioSum < usuario.getPerfil().getPresupuesto() && tiempoSum < usuario.getPerfil().getTiempoDisponibleParaVisitas()) {
				atraccionesSeleccionadas.add(atraccion);
			}else{
				break;
			}
		}


		return atraccionesSeleccionadas;
	}

	public void ordenarAtraccionesPorPrecio(List<Atraccion> atracciones) {
		Collections.sort(atracciones, new Comparator<Atraccion>() {
			public int compare(Atraccion o1, Atraccion o2) {
				if (o1.getCosto() == o2.getCosto())
					return 0;
				else if (o1.getCosto() < o2.getCosto()) {
					return -1;
				}else{
					return 1;
				}
			}
		});	

	}

	private void filtrarPorTipoDeAtraccionPreferidaDelUsuario(EnumTipoDeAtraccion tipo, List<Atraccion> atracciones) {
		Iterator<Atraccion> iter = atracciones.iterator();
		while (iter.hasNext()) {
			Atraccion atraccion = iter.next();
			if (atraccion.getTipo() != tipo) {
				iter.remove();
			}
		}
	}

	private void filtrarPorCercania(Coordenada ubicacion, List<Atraccion> atracciones) {
		Iterator<Atraccion> iter = atracciones.iterator();
		while (iter.hasNext()) {
			Atraccion atraccion = iter.next();
			if (distanciaMaxima < Math.abs(atraccion.getPosicionamiento().getX() - ubicacion.getX()) && distanciaMaxima < Math.abs(atraccion.getPosicionamiento().getX() - ubicacion.getX())) {
				iter.remove();
			}
		}
	}

	private List<Atraccion> getAtraccionesConDescuento(List<Atraccion> atracciones) {
		List<Atraccion> atraccionesConDescuento = new LinkedList<Atraccion>();
		for (Promocion promocion : promociones) {
			if (promocion instanceof PromocionPorcentual) {
				for (Atraccion atraccion : atracciones) {
					if (((PromocionPorcentual) promocion).tieneDescuento(atraccion)) {
						atraccionesConDescuento.add(atraccion);
					}
				}
			}
		}
		return atraccionesConDescuento;
	}

	/*private void getAtraccionesGratisYLasRequeridasSegunPromocion(List<Atraccion> atracciones) {
	List<Atraccion> atraccionesConPromocionesAxB = new LinkedList<Atraccion>();
	for (Promocion promocion : promociones) {
		if (promocion instanceof PromocionAXB) {
			for (Atraccion atraccion : atracciones) {
				if (((PromocionAXB) promocion).getAtraccionesRequeridas().contains(atraccion)) {
					atraccionesConPromocionesAxB.add(atraccion);
					atraccionesConPromocionesAxB.addAll(((PromocionAXB) promocion).getAtraccionesRequeridas());
				}
			}
		}
	}
}*/


}
