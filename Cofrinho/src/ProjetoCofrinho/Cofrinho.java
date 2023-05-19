package ProjetoCofrinho;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe cujos métodos alimentam, pesquisam ou removem itens da lista de
 * Moedas.
 */
public class Cofrinho {

	/**
	 * Lista primária de Moedas que será utilizada pelos métodos implementados nesta
	 * classe.
	 */
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();

	private double taxaCambioDolar = 0, taxaCambioEuro = 0;

	/** Método responsável por adicionar valores situados no ArrayList. */
	public void addMoeda(Scanner scan) throws InterruptedException {
		String resp;
		boolean repeatMenu = true;

		while (repeatMenu) {
			System.out.println();
			System.out.println("************************ Menu de Adição de Moedas ************************");
			System.out.println("Tipo de moeda:");
			System.out.println("1-Real");
			System.out.println("2-Dolar");
			System.out.println("3-Euro");
			System.out.println("4-Sair");
			System.out.println("**************************************************************************");
			System.out.print("#: ");
			resp = scan.nextLine();
			System.out.println();

			try {
				switch (resp) {
				case "1":
					System.out.println("****** Moeda selecionada: REAL ******");
					System.out.println();
					System.out.print("Valor [R$]: ");

					listaMoedas.add(new Real(checkIfNegative(scan.nextDouble()), 1)); // Real é ele mesmo. Portanto "1".

					scan.nextLine();
					System.out.println();
					break;
				case "2":
					System.out.println("****** Moeda selecionada: DOLAR ******");
					System.out.println();
					System.out.print("Valor [$]: ");

					listaMoedas.add(new Dolar(checkIfNegative(scan.nextDouble()), taxaCambioDolar));

					scan.nextLine();
					System.out.println();
					break;
				case "3":
					System.out.println("****** Moeda selecionada: EURO ******");
					System.out.println();
					System.out.print("Valor [€]: ");

					listaMoedas.add(new Euro(checkIfNegative(scan.nextDouble()), taxaCambioEuro));

					scan.nextLine();
					System.out.println();
					break;
				case "4":
					repeatMenu = false;
					System.out.println("Retornando ao menu inicial! \nPressione enter para continuar!");
					scan.nextLine();
					System.out.println();
					break;
				default:
					System.out.println("Opção inválida!");
					scan.nextLine();
					System.out.println();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor informado é obrigatório ser numérico!");
				Thread.sleep(1500);
				scan.nextLine();
				System.out.println();
			}
		}
	}

	/** Método responsável por remover valores situados no ArrayList. */
	public void removerMoedas(Scanner scan) throws InterruptedException {
		String resp;
		boolean repeatMenu = true;

		while (repeatMenu) {
			System.out.println();
			System.out.println("************************ Menu de Remoção de Valores ************************");
			System.out.println("Tipo de moeda:");
			System.out.println("1-Remover Valor");
			System.out.println("2-Sair");
			System.out.println("**************************************************************************");
			System.out.print("#: ");
			resp = scan.nextLine();
			System.out.println();

			try {
				switch (resp) {
				case "1":

					if (listaMoedas.size() == 0) {
						System.out.println("Não há valores para remover!");
						break;
					} else {
						System.out.println("Valores disponíveis para remoção: ");
						listagemMoedas();

						try {
							System.out.print("#: ");
							listaMoedas.remove(scan.nextInt() - 1); // Este -1 é para reduzir 1 valor da opção
																	// selecionada, visto que adicionei +1 na listagem
																	// (checar listaMoedas())
						} catch (IndexOutOfBoundsException e) {
							System.out.println("Valor selecionado não existe!");
							Thread.sleep(1500);
							scan.nextLine();
							System.out.println();
						}
					}
					scan.nextLine();
					System.out.println();
					break;
				case "2":
					repeatMenu = false;
					System.out.println("Retornando ao menu inicial! \nPressione enter para continuar!");
					scan.nextLine();
					System.out.println();
					break;
				default:
					System.out.println("Opção inválida!");
					scan.nextLine();
					System.out.println();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Valor informado é obrigatório ser numérico!");
				Thread.sleep(1500);
				scan.nextLine();
				System.out.println();
			}
		}

	}

	/** Método responsável por demonstrar todos os valores situados no ArrayList. */
	public void listagemMoedas() {
		if (listaMoedas.size() != 0) {
			System.out.println();
			System.out.println("Total de Moedas: " + listaMoedas.size());

			for (int i = 0; i < listaMoedas.size(); i++) {
				String tipoMoeda = listaMoedas.get(i).getClass().getSimpleName();

				if (tipoMoeda.equals("Real")) {
					System.out.println(i + 1 + " - R$" + listaMoedas.get(i).toString());
				} else if (tipoMoeda.equals("Dolar")) {
					System.out.println(i + 1 + " - $" + listaMoedas.get(i).toString());
				} else if (tipoMoeda.equals("Euro")) {
					System.out.println(i + 1 + " - €" + listaMoedas.get(i).toString());
				}
			}

			System.out.println();

		} else {
			System.out.println();
			System.out.println("Não há moedas para listar!");
			System.out.println();
		}
	}

	public void totalConvertido() {
		double totalConversao = 0;
		if (listaMoedas.size() == 0) {
			System.out.println("Não há valores para converter para R$!");
		} else {
			for (int i = 0; i < listaMoedas.size(); i++) {
				totalConversao += listaMoedas.get(i).converter();
			}
			System.out.println("Valor total da conversão: R$" + totalConversao);
		}
	}

	/**
	 * Checa se o valor a ser adicionado na listagem é negativo.
	 * 
	 * @return: Retorna o valor informado ou 0 caso seja negativo
	 */
	public double checkIfNegative(double valor) {
		if (valor < 0) {
			System.out.println("Valor informado não pode ser negativo! Adicionado como 0!");
			return 0;
		} else
			return valor;
	}

	public boolean definirTaxaDeCambio(Scanner scan) {
		System.out.print("Taxa do Dolar: $");
		this.taxaCambioDolar = scan.nextDouble();
		System.out.print("Taxa do Euro: €");
		this.taxaCambioEuro = scan.nextDouble();

		if (taxaCambioDolar <= 0 || taxaCambioEuro <= 0) {
			System.out.println("Taxas não podem ser zero ou negativa!\n");
			scan.nextLine();
			return true;
		} else {
			System.out.println();
			scan.nextLine();
			return false;
		}

	}

}
