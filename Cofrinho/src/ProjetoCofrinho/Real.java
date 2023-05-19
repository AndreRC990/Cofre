package ProjetoCofrinho;

public class Real extends Moeda {

	/** Construtor */
	public Real(double valorMoeda, double taxaCambiovalor) {
		super(valorMoeda, taxaCambiovalor);
	}

	/** Polimorfismo por parte da classe Real herdando de Moeda */
	@Override
	public double converter() {
		double convertido = valor * taxaCambio;
		System.out.println("Fórmula Conversão:");
		System.out.println("R$" + valor + "*" + taxaCambio);
		System.out.println("R$" + convertido);
		System.out.println();
		return convertido;

	}
}
