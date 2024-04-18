package sistema;

import java.util.Scanner;
import service.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		do {
			System.out.println("1- Operações de Usuários\n2- Operações de Produtos\n9 - Sair\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				operacoesUsuarios(sc, hm);
				break;
			case 2:
				operacoesProdutos(sc, hm);
				break;
			case 9:
				System.out.println("Saindo do sistema...");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (opcao != 9);
		sc.close();
	}

	private static void operacoesUsuarios(Scanner sc, HandleMenu hm) {
		int opcao = 0;
		do {
			System.out.println("1- Criar Usuário\n2- Editar Usuário\n3 - Deletar Usuário\n"
					+ "4 - Listar Usuários\n5 - Buscar Usuário\n9 - Voltar ao Menu Principal\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				hm.criar();
				break;
			case 2:
				hm.editar();
				break;
			case 3:
				hm.deletar();
				break;
			case 4:
				hm.listar();
				break;
			case 5:
				hm.buscarUnico();
				break;
			case 9:
				System.out.println("Voltando ao Menu Principal...");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (opcao != 9);
	}

	private static void operacoesProdutos(Scanner sc, HandleMenu hm) {
		int opcao = 0;
		do {
			System.out.println("1- Criar Produto\n2- Editar Produto\n3 - Deletar Produto\n"
					+ "4 - Listar Produtos\n5 - Buscar Produto\n9 - Voltar ao Menu Principal\n");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				hm.criarProduto();
				break;
			case 2:
				hm.editarProduto();
				break;
			case 3:
				hm.deletarProduto();
				break;
			case 4:
				hm.listarProdutos();
				break;
			case 5:
				hm.buscarProduto();
				break;
			case 9:
				System.out.println("Voltando ao Menu Principal...");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		} while (opcao != 9);
	}
}
