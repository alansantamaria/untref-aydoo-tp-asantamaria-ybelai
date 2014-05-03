package untref.tp.tierramedia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class CreadorDeSugerencias {
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	private final int distanciaMaxima = 10;

	/*
	 * @param  atracciones lista con todas las atracciones disponibles
	 * @param  promociones lista con todas las promociones vigentes
	 */
	public CreadorDeSugerencias (List<Atraccion> atracciones, List<Promocion> promociones) {
		this.atracciones = atracciones;
		this.promociones = promociones;
	}
	
	/*La sugerencia se genera de la siguiente manera:
	 *1) se ordenan las atracciones de menor a mayor precio.
	 *2) se descartan aquellas atracciones que no son preferidas por el usuario.
	 *3) se descartan aquellas atracciones que se encuentran fuera de una distancia establecida respecto a la ubicacion del usuario.
	 *4) se separan las atracciones restantes en dos grupos: las que tienen descuento por promocion y las que no. 
	 *5) se agregan primero las atracciones con descuento controlando que la sumatoria no sobrepase el presupuesto del usuario y el tiempo disponible.
	 *6) si aun hay presupuesto y tiempo disponible se siguen agregando atracciones sin descuentos a la sugerencia.
	 */
	public List<Atraccion> generarSugerencia(Usuario usuario) {
		List<Atraccion> atraccionesPreSeleccionadas = atracciones;
		Utils.ordenarAtraccionesPorPrecio(atraccionesPreSeleccionadas);
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
			if (distanciaMaxima < Utils.getDistanciaEntreCoordenadas(ubicacion, atraccion.getPosicionamiento())) {
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
	
}
