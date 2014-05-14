package untref.tp.tierramedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import untref.tp.tierramedia.excepciones.VelocidadDeTrasladoCeroException;


public class CreadorDeSugerencias {
	private List<Atraccion> atracciones;
	private PromocionAbsoluta promocionAbsoluta;
	private PromocionFamiliar promocionFamiliar;
	private PromocionExtranjero promocionExtranjero;
	private List<PromocionPorcentual> promocionesPorcentuales;
	private List<PromocionAXB> promocionesAXB;
	private final int distanciaMaxima = 10;


	public CreadorDeSugerencias(List<Atraccion> atracciones,
			PromocionAbsoluta promocionAbsoluta,
			List<PromocionPorcentual> promocionesPorcentuales,
			List<PromocionAXB> promocionesAXB, PromocionExtranjero promocionExtranjero, PromocionFamiliar promocionFamiliar) {
		this.atracciones = atracciones;
		this.promocionAbsoluta = promocionAbsoluta;
		this.promocionesPorcentuales = promocionesPorcentuales;
		this.promocionesAXB = promocionesAXB;
		this.promocionExtranjero = promocionExtranjero;
		this.promocionFamiliar = promocionFamiliar;
	}

	public Paquete getPaquete(Usuario usuario) throws Exception {

		Paquete paquete = new Paquete();
		paquete.setCantidadEntradas(usuario.getPerfil().getCandidadDeEntradas());

		List<Atraccion> atraccionesSugeridas = getSugerenciasParaVisitar(usuario);

		if (promocionExtranjero == null || 
				!promocionExtranjero.seAplicaPromocion(usuario.getPerfil().getDistanciaALaAtraccionMasCercanaAlDomicilio(atracciones))) {

			aplicarDescuentoPorcentualAAtracciones(atraccionesSugeridas);
			List<Atraccion> atraccionesGratisPorPromocionAXB = getPromocionesGratisPorAXB(atraccionesSugeridas);
			agregarAtraccionesSugeridasAlPaquete(paquete, atraccionesSugeridas, usuario.getPerfil());
			agregarAtraccionesGratisPorPromocionesAXB(paquete, atraccionesGratisPorPromocionAXB, usuario.getPerfil());
			if (promocionAbsoluta != null) {
				promocionAbsoluta.aplicarDescuento(paquete);
			}
		}else{
			promocionExtranjero.aplicarDescuento(atraccionesSugeridas);
			agregarAtraccionesSugeridasAlPaquete(paquete, atraccionesSugeridas, usuario.getPerfil());
		}

		return paquete;
	}

	/*La lista de atracciones sugeridas se genera de la siguiente manera:
	 *1) se ordenan las atracciones de menor a mayor precio.
	 *2) se descartan aquellas atracciones que no son preferidas por el usuario.
	 *3) se descartan aquellas atracciones que se encuentran fuera de una distancia establecida respecto a la ubicacion del usuario.
	 *4) en el caso que no se aplique la promocion por extranjero se seleccionan aquellas que tienen descuentos porcentuales por promocion 
	 */
	public List<Atraccion> getSugerenciasParaVisitar(Usuario usuario) {
		List<Atraccion> atraccionesPreSeleccionadas = atracciones;


		filtrarPorTipoDeAtraccionPreferidaDelUsuario(usuario.getPerfil().getTipoDeAtraccionFavorita(), atraccionesPreSeleccionadas);

		filtrarPorCercania(usuario.getPerfil().getUbicacion(), atraccionesPreSeleccionadas);

		if (promocionExtranjero == null || 
				!promocionExtranjero.seAplicaPromocion(usuario.getPerfil().getDistanciaALaAtraccionMasCercanaAlDomicilio(atracciones))) {

			List<Atraccion> atraccionesConDescuento = getAtraccionesConDescuentoPorcentual(atraccionesPreSeleccionadas);
			ordenarAtraccionesPorPrecio(atraccionesConDescuento);
			return atraccionesConDescuento;
		}else{
			ordenarAtraccionesPorPrecio(atraccionesPreSeleccionadas);
			return atraccionesPreSeleccionadas;
		}


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
			if (distanciaMaxima < ubicacion.getDistanciaEntreCoordenadas(atraccion.getPosicionamiento())) {
				iter.remove();
			}
		}
	}

	private List<Atraccion> getAtraccionesConDescuentoPorcentual(List<Atraccion> atracciones) {
		List<Atraccion> atraccionesConDescuento = new LinkedList<Atraccion>();
		for (PromocionPorcentual promocion : promocionesPorcentuales) {
			for (Atraccion atraccion : atracciones) {
				if (promocion.tieneDescuento(atraccion) && promocion.estaVigente()) {
					atraccionesConDescuento.add(atraccion);
				}
			}
		}
		return atraccionesConDescuento;
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
	private void aplicarDescuentoPorcentualAAtracciones(List<Atraccion> atracciones) {
		for (PromocionPorcentual promocion : promocionesPorcentuales) {
			for (Atraccion atraccion : atracciones) {
				if (promocion.tieneDescuento(atraccion) && promocion.estaVigente() && !atraccion.seAplicoPromocion()) {
					promocion.calcularDescuento(atraccion);
				}
			}
		}
	}

	private List<Atraccion> getPromocionesGratisPorAXB(
			List<Atraccion> atraccionesSugeridas) {
		List<Atraccion> atraccionesGratis = new LinkedList<Atraccion>();
		for (PromocionAXB promocion : promocionesAXB) {
			if (promocion.getAtraccionGratisConRequisitosCumplidos(atraccionesSugeridas) != null) {
				atraccionesGratis.add(promocion.getAtraccionGratisConRequisitosCumplidos(atraccionesSugeridas));
			}
		}
		return atraccionesGratis;
	}

	private void agregarAtraccionesSugeridasAlPaquete(Paquete paquete, List<Atraccion> atraccionesSugeridas, Perfil perfil) throws VelocidadDeTrasladoCeroException {
		ListIterator<Atraccion> iter = atraccionesSugeridas.listIterator();
		while (iter.hasNext()) {
			Atraccion atraccion = iter.next();
			if (!paquete.getAtracciones().isEmpty()) {
				paquete.addAtraccion(atraccion, atraccion.getPosicionamiento().getTiempoTrasladoEntreCoordenadas(paquete.getAtracciones().get(paquete.getAtracciones().size() - 1).getPosicionamiento(), perfil.getVelocidadDeTranslado()), promocionFamiliar, perfil);
			}else{
				paquete.addAtraccion(atraccion, 0.0, promocionFamiliar, perfil);
			}


			if (paquete.getDuracion() > perfil.getTiempoDisponibleParaVisitas() || paquete.getPrecio() > perfil.getPresupuesto()) {
				if (iter.hasPrevious()) {
					paquete.removeAtraccion(atraccion, atraccion.getPosicionamiento().getTiempoTrasladoEntreCoordenadas(paquete.getAtracciones().get(paquete.getAtracciones().size() - 1).getPosicionamiento(), perfil.getVelocidadDeTranslado()));
				}else{
					paquete.removeAtraccion(atraccion, 0.0);
				}
			}

		}
	}

	private void agregarAtraccionesGratisPorPromocionesAXB(Paquete paquete, List<Atraccion> atraccionesGratisPorPromocionAXB, Perfil perfil) throws VelocidadDeTrasladoCeroException {
		ListIterator<Atraccion> iter = atraccionesGratisPorPromocionAXB.listIterator();
		while (iter.hasNext()) {
			Atraccion atraccion = iter.next();
			if (!paquete.getAtracciones().isEmpty()) {
				paquete.addAtraccion(atraccion, atraccion.getPosicionamiento().getTiempoTrasladoEntreCoordenadas(paquete.getAtracciones().get(paquete.getAtracciones().size() - 1).getPosicionamiento(), perfil.getVelocidadDeTranslado()), null, perfil);
			}else{
				paquete.addAtraccion(atraccion, 0.0, null, perfil);
			}


			if (paquete.getDuracion() > perfil.getTiempoDisponibleParaVisitas()) {
				if (iter.hasPrevious()) {
					paquete.removeAtraccion(atraccion, atraccion.getPosicionamiento().getTiempoTrasladoEntreCoordenadas(paquete.getAtracciones().get(paquete.getAtracciones().size() - 1).getPosicionamiento(), perfil.getVelocidadDeTranslado()));
				}else{
					paquete.removeAtraccion(atraccion, 0.0);
				}
			}

		}
	}

}
