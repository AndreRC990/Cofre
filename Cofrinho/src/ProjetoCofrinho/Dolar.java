package ProjetoCofrinho;

public class Dolar extends Moeda {

	/** Construtor */
	public Dolar(double valorMoeda, double taxaCambiovalor) {
		super(valorMoeda, taxaCambiovalor);
	}

	/** Polimorfismo por parte da classe Dolar herdando de Moeda */
	@Override
	public double converter() {
		double convertido = valor * taxaCambio;
		System.out.println("Fórmula Conversão:");
		System.out.println("$" + valor + "*" + taxaCambio);
		System.out.println("$" + convertido);
		System.out.println();
		return convertido;
	}
}
