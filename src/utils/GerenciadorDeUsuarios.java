package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class GerenciadorDeUsuarios {

	private static final String NOME_ARQUIVO = "usuarios.txt";

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

	public void adicionarUsuarios(Usuario usuario) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString());
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Usuario> lerUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuarios();
		if (usuarios.removeIf(usuario -> usuario.getId() == id)) {
			reescreverArquivo(usuarios);
			System.out.println("Usuário deletado com sucesso");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarUsuarios() {
		List<Usuario> usuarios = lerUsuarios();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado");
		} else {
			System.out.println("Lista de Usuários");
			for (Usuario usuario : usuarios) {
				System.out.println(
						"ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}
		}
	}

	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				usuario.setNome(novoNome);
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuário editado com sucesso");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public void buscarUnico(int id) {
		List<Usuario> usuarios = lerUsuarios();
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				System.out.println(
						"ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}
		}
	}
	 	
}
