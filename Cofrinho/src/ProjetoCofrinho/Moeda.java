package ProjetoCofrinho;

public abstract class Moeda {

	/** Atributo fundamental numérico da respectiva Moeda */
	public double valor;
	public double taxaCambio;

	/** Construtor */
	public Moeda(double valorMoeda, double taxaCambioMoeda) {
		valor = valorMoeda;
		taxaCambio = taxaCambioMoeda;
	}

	/** Método abstrato que será herdado e implementado pelas classes filhas */
	public abstract double converter();

	/**
	 * Override do método nativo "toString()" criado para formatar o "print" da
	 * lista de Moedas
	 */
	@Override
	public String toString() {
		return "" + String.format("%.2f", valor);
	}

}