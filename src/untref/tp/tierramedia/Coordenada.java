package untref.tp.tierramedia;

import untref.tp.tierramedia.excepciones.VelocidadDeTrasladoCeroException;

public class Coordenada {
	int x;
	int y;

	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public boolean equals(Coordenada otraCoordenada) {
		if (this.getX() == otraCoordenada.getX() && this.getY() == otraCoordenada.getY()) {
			return true;
		}else{
			return false;
		}
	}
	
	public double getDistanciaEntreCoordenadas (Coordenada c) {
		return  Math.hypot(getX() - c.getX(), getY() - c.getY());
	}
	
	public double getTiempoTrasladoEntreCoordenadas (Coordenada c, int velocidadTrasladoDelUsuario) throws VelocidadDeTrasladoCeroException {
		if (velocidadTrasladoDelUsuario > 0) {
			return getDistanciaEntreCoordenadas(c) / velocidadTrasladoDelUsuario;
		}else{
			throw new VelocidadDeTrasladoCeroException();
		}
	}

}
