package tcc;

import java.util.ArrayList;
import java.util.List;

public class Elevador {

	private Integer andarMaximo;
	private Integer andarAtual;

	private List<Passageiro> passageiros;

	public Elevador(Integer andarAtual, Integer andarMaximo) {
		this.andarAtual = andarAtual;
		this.andarMaximo = andarMaximo;
		this.passageiros = new ArrayList<Passageiro>();
	}

	public void mover(Integer andar) {
		this.andarAtual = andar;
	}

	public void solicitarElevador(Passageiro passageiro) {
		this.passageiros.add(passageiro);
	}

	public void iniciarMovimento() {
		while (!this.passageiros.isEmpty()) {

			Passageiro passageiro = buscarProximoPassageiro();

			if (passageiro.isEmbarcou()) {
				System.out.print(String.valueOf("->" + passageiro.getAndarDestino()));
				
				if (passageiro.getAndarDestino() != andarAtual) {
					mover(passageiro.getAndarDestino());
				}

				desembarcarPassageiro(passageiro);
			}

			else {
				System.out.print(String.valueOf("->" + passageiro.getAndarOrigem()));
				
				if (passageiro.getAndarOrigem() != andarAtual) {
					mover(passageiro.getAndarOrigem());
				}

				embarcarPassageiro(passageiro);
			}
		}
	}

	private void embarcarPassageiro(Passageiro passageiro) {
		passageiro.embarcar();
	}

	private void desembarcarPassageiro(Passageiro passageiro) {
		passageiro.desembarcar();
		this.passageiros.remove(passageiro);
	}

	private Passageiro buscarProximoPassageiro() {
		return passageiros.size() == 1 ? passageiros.get(0) : buscarPassageiroComMenorDistanciaDoAndarAtual();
	}

	private Passageiro buscarPassageiroComMenorDistanciaDoAndarAtual() {
		Passageiro passageiroSelecionado = null;
		Integer menorDistanciaEntreAndares = andarMaximo;

		for (Passageiro passageiro : passageiros) {

			Integer andarOrigem = passageiro.getAndarOrigem();
			Integer andarDestino = passageiro.getAndarDestino();
			Integer distanciaEntreAndares = 0;

			if (!passageiro.isEmbarcou()) {
				distanciaEntreAndares = andarAtual < andarOrigem ? andarOrigem - andarAtual : andarAtual - andarOrigem;
			}
			else{
				distanciaEntreAndares = andarAtual < andarDestino ? andarDestino - andarAtual
						: andarAtual - andarDestino;
			}

			if (menorDistanciaEntreAndares > distanciaEntreAndares) {
				menorDistanciaEntreAndares = distanciaEntreAndares;
				passageiroSelecionado = passageiro;
			}
		}

		return passageiroSelecionado;
	}

	public Integer getAndarMaximo() {
		return andarMaximo;
	}

	public void setAndarMaximo(Integer andarMaximo) {
		this.andarMaximo = andarMaximo;
	}

	public Integer getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(Integer andarAtual) {
		this.andarAtual = andarAtual;
	}

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}

}
