package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciadorDeProdutos {

	private static final String NOME_ARQUIVO = "produtos.txt";

	public void verificaECria(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		if (arquivo.exists()) {
			System.out.println("Banco Funcionando!");
		} else {
			try {
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso");
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar um arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarProduto(Produto produto) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(produto.toString());
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Produto> lerProdutos() {
		List<Produto> produtos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void deletarProduto(long id) {
		List<Produto> produtos = lerProdutos();
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			reescreverArquivo(produtos);
			System.out.println("Produto deletado com sucesso");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarProdutos() {
		List<Produto> produtos = lerProdutos();
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			System.out.println("Lista de Produtos");
			for (Produto produto : produtos) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: "
						+ produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
			}
		}
	}

	public void editarProduto(long id, String novoNome, double novoPreco, int novaQuantidade) {
		List<Produto> produtos = lerProdutos();
		boolean encontrado = false;
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produto.setNome(novoNome);
				produto.setPreco(novoPreco);
				produto.setQuantidade(novaQuantidade);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(produtos);
			System.out.println("Produto editado com sucesso");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

	public void buscarUnico(long id) {
		List<Produto> produtos = lerProdutos();
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: "
						+ produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
			}
		}
	}
}
