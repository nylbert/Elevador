package tcc;

public class Passageiro {

	private Integer andarOrigem;
	private Integer andarDestino;

	private boolean embarcou;

	public Passageiro() {
		// TODO Auto-generated constructor stub
	}

	public Passageiro(Integer andarOrigem, Integer andarDestino) {
		this.andarOrigem = andarOrigem;
		this.andarDestino = andarDestino;
	}
	
	public void embarcar() {
		setEmbarcou(true);
	}
	
	public void desembarcar(){
		setEmbarcou(false);
	}

	public Integer getAndarOrigem() {
		return andarOrigem;
	}

	public void setAndarOrigem(Integer andarOrigem) {
		this.andarOrigem = andarOrigem;
	}

	public Integer getAndarDestino() {
		return andarDestino;
	}

	public void setAndarDestino(Integer andarDestino) {
		this.andarDestino = andarDestino;
	}

	public boolean isEmbarcou() {
		return embarcou;
	}

	public void setEmbarcou(boolean embarcou) {
		this.embarcou = embarcou;
	}

}
