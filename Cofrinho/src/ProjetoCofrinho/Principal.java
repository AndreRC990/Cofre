package ProjetoCofrinho;

import java.util.Scanner;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static Cofrinho cofre = new Cofrinho();

	public static void main(String[] args) throws InterruptedException {
		boolean menuRepeat = true, menuExchangeRepeat = true;

		while (menuExchangeRepeat) {
			System.out.println("************************ Menu Taxa de Câmbio ************************");
			System.out.println("Favor informar as Taxas de Câmbio do Dólar e do Euro:");
			menuExchangeRepeat = cofre.definirTaxaDeCambio(scan);
		}

		while (menuRepeat) {
			String resp = "";
			System.out.println("************************ Menu Cofrinho ************************");
			System.out.println("1- Adicionar Moedas");
			System.out.println("2- Remover Moedas");
			System.out.println("3- Listar Moedas");
			System.out.println("4- Calcular Total Em Reais");
			System.out.println("5- Sair");
			System.out.println("***************************************************************");
			System.out.print("Seleção: ");
			resp = scan.nextLine();

			switch (resp) {
			case "1":
				cofre.addMoeda(scan);
				break;
			case "2":
				cofre.removerMoedas(scan);
				break;
			case "3":
				cofre.listagemMoedas();
				break;
			case "4":
				cofre.totalConvertido();
				break;
			case "5":
				System.out.println("Fechando sistema. Obrigado. :)");
				scan.close();
				System.exit(0);
			default:
				System.out.println("Opção incorreta!");
				break;
			}
		}
	}
}
