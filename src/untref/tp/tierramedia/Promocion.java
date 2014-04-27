package untref.tp.tierramedia;


public abstract class Promocion {
	private int vigencia;
	
	public Promocion(int vigencia) {
		this.vigencia = vigencia;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}
	
}
