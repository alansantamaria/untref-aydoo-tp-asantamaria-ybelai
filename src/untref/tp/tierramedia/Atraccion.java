package untref.tp.tierramedia;

public class Atraccion {
	private String nombre;
	private EnumTipoDeAtraccion tipo;
	private double costo;
	private int tiempo;
	private Coordenada posicionamiento;
	private int cupoDeVisitantesDiarios;
	private boolean seAplicoPromocion = false;
	
	public Atraccion(String nombre, EnumTipoDeAtraccion tipo, double costo, int tiempo,
			Coordenada posicionamiento, int cupoDeVisitantesDiarios) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.tiempo = tiempo;
		this.posicionamiento = posicionamiento;
		this.cupoDeVisitantesDiarios = cupoDeVisitantesDiarios;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public boolean seAplicoPromocion() {
		return seAplicoPromocion;
	}

	public void setSeAplicoPromocion(boolean seAplicoPromocion) {
		this.seAplicoPromocion = seAplicoPromocion;
	}
	
	
}
