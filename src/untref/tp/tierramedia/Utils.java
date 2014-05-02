package untref.tp.tierramedia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {

	static double getDistanciaEntreCoordenadas (Coordenada c1, Coordenada c2) {
		System.out.println(Math.hypot(c2.getX() - c1.getX(), c2.getY() - c1.getY()));
		return  Math.hypot(c2.getX() - c1.getX(), c2.getY() - c1.getY());
	}

	static void ordenarAtraccionesPorPrecio(List<Atraccion> atracciones) {
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

}
