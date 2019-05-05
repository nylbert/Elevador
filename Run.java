package tcc;

import java.io.IOException;

public class Run {

	public static void main(String[] args) throws IOException {

		executarPrimeiraTarefa();
		System.out.println();
		executarSegundaTarefa();

	}
	
	private static void executarPrimeiraTarefa() {
		Elevador elevador = new Elevador(5, 10);
		elevador.solicitarElevador(new Passageiro(8, 0));
		elevador.solicitarElevador(new Passageiro(0, 10));
		elevador.iniciarMovimento();
	}

	private static void executarSegundaTarefa() {
		Elevador elevador = new Elevador(3, 20);
		elevador.solicitarElevador(new Passageiro(8, 0));
		elevador.solicitarElevador(new Passageiro(0, 7));
		elevador.solicitarElevador(new Passageiro(3, 15));
		elevador.iniciarMovimento();
	}

}