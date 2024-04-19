package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import models.Usuario;
import utils.GerenciadorDeProdutos;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);

	// Gerenciador

	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	// Gerenciador de Produtos
		GerenciadorDeProdutos gp = new GerenciadorDeProdutos();


	// Construtor vazio
	public HandleMenu() {
		// toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
		gp.verificaECria("produtos.txt");
	}

	public void criar() {
		System.out.println("Digite o nome: ");
		String nome = sc.next();
		System.out.println("Digite sua senha: ");
		String senha = sc.next();

		int id = getNextId();
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuarios(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite a nova senha: ");
		String senha = sc.next();
		gs.editarUsuario(id, nome, senha);
	}

	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado: ");
		int id = sc.nextInt();
		gs.deletarUsuario(id);

	}

	public void listar() {

		gs.listarUsuarios();
	}

	public void buscarUnico() {
		System.out.println("Digite o ID do usuario para ser listado: ");
		int id = sc.nextInt();

		gs.buscarUnico(id);
	}

	private int getNextId() {

		List<Usuario> usuarios = gs.lerUsuarios();

		int maxId = 0;

		// for => foreach
		for (Usuario usuario : usuarios) {
			int id = usuario.getId();

			if (id > maxId) {

				// Lógica para descobrir o último Id
				maxId = id;
			}
		}

		return maxId + 1;

	}

	public void trocarSenhaUsuario(Scanner sc, GerenciadorDeUsuarios gp) {
		System.out.println("Digite o ID do usuário: ");
		int id = sc.nextInt();
		System.out.println("Digite a senha antiga: ");
		String senhaAntiga = sc.next();
		System.out.println("Digite a nova senha: ");
		String novaSenha = sc.next();

		// Chama o método trocarSenha do GerenciadorDeUsuarios
		gs.trocarSenha(id, senhaAntiga, novaSenha);
	}

	
	// Métodos para operações com produtos

	public void criarProduto() {
		System.out.println("Digite o nome do produto: ");
		String nome = sc.next();
		System.out.println("Digite o preço do produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a quantidade do produto: ");
		int quantidade = sc.nextInt();
		System.out.println("Produto Cadastrado!");
		long id = getNextProdutoId();
		Produto produto = new Produto(id, nome, preco, quantidade);
		gp.adicionarProduto(produto);
	}

	public void editarProduto() {
		System.out.println("Digite o ID do produto: ");
		long id = sc.nextLong();
		System.out.println("Digite o novo nome do produto: ");
		String nome = sc.next();
		System.out.println("Digite o novo preço do produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a nova quantidade do produto: ");
		int quantidade = sc.nextInt();
		System.out.println("Produto alterado com sucesso!");
		gp.editarProduto(id, nome, preco, quantidade);
	}

	public void deletarProduto() {
		System.out.println("Digite o ID do produto a ser deletado: ");
		long id = sc.nextLong();
		gp.deletarProduto(id);
	}

	public void listarProdutos() {
		gp.listarProdutos();
	}

	public void buscarProduto() {
		System.out.println("Digite o ID do produto para buscar: ");
		long id = sc.nextLong();
		gp.buscarUnico(id);
	}

	// Método auxiliar para obter o próximo ID de produto
	private long getNextProdutoId() {
		List<Produto> produtos = gp.lerProdutos();
		long maxId = 0;
		for (Produto produto : produtos) {
			if (produto.getId() > maxId) {
				maxId = produto.getId();
			}
		}
		return maxId + 1;
	}

	public void somarPrecos() {
		gp.somarPrecos();	
}
	public void contarQuantidadeProdutos() {
		gp.contarQuantidadeProdutos();
	}
}