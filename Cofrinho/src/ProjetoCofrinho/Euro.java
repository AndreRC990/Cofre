package ProjetoCofrinho;

public class Euro extends Moeda {

	/** Construtor */
	public Euro(double valorMoeda, double taxaCambiovalor) {
		super(valorMoeda, taxaCambiovalor);
	}

	/** Polimorfismo por parte da classe Euro herdando de Moeda */
	@Override
	public double converter() {
		double convertido = valor * taxaCambio;
		System.out.println("Fórmula Conversão:");
		System.out.println("€" + valor + "*" + taxaCambio);
		System.out.println("€" + convertido);
		System.out.println();
		return convertido;

	}
}
