package untref.tp.tierramedia;

public class Atraccion {
	private EnumTipoDeAtraccion tipo;
	private double costo;
	private int tiempo;
	private Coordenada posicionamiento;
	private int cupoDeVisitantesDiarios;
	
	
	public Atraccion(EnumTipoDeAtraccion tipo, double costo, int tiempo,
			Coordenada posicionamiento, int cupoDeVisitantesDiarios) {
		this.tipo = tipo;
		this.costo = costo;
		this.tiempo = tiempo;
		this.posicionamiento = posicionamiento;
		this.cupoDeVisitantesDiarios = cupoDeVisitantesDiarios;
	}
	public EnumTipoDeAtraccion getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoDeAtraccion tipo) {
		this.tipo = tipo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public Coordenada getPosicionamiento() {
		return posicionamiento;
	}
	public void setPosicionamiento(Coordenada posicionamiento) {
		this.posicionamiento = posicionamiento;
	}
	public int getCupoDeVisitantesDiarios() {
		return cupoDeVisitantesDiarios;
	}
	public void setCupoDeVisitantesDiarios(int cupoDeVisitantesDiarios) {
		this.cupoDeVisitantesDiarios = cupoDeVisitantesDiarios;
	}
	
}
