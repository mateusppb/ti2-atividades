package com.ti2;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		
		dao.conectar();
		String titulo;
		String anolancamento;
		String genero;
		int codigo;
		
		while(true) {
			System.out.println("=== Menu de opções ===");
			System.out.println("1- Inserir Filme");
			System.out.println("2- Atualizar Filme");
			System.out.println("3- Excluir Filme");
			System.out.println("4- Exibir filmes");
			System.out.println("5-Sair");
			System.out.println("\n\nOpção: ");
			int opcao = sc.nextInt();
			sc.nextLine();
			if(opcao == 1) {
				
				//Inserir um elemento na tabela
				System.out.print("Digite o codigo do filme: ");
				codigo = sc.nextInt();
				sc.nextLine();
				System.out.print("Digite o título do filme: ");
				titulo = sc.nextLine();
				System.out.print("Digite o ano do lançamento do filme: ");
				anolancamento = sc.nextLine();
				System.out.print("Digite o gênero do filme: ");
				genero = sc.nextLine();
				Filme filme = new Filme(codigo, titulo, anolancamento, genero);
				if(dao.inserirFilme(filme) == true) {
					System.out.println("Inserção com sucesso -> " + filme.toString());
				}
			
			} else if(opcao == 2) { // Atualizar filme
			    System.out.print("Digite o código do filme a ser atualizado: ");
			    int codigoAtualizar = sc.nextInt();
			    sc.nextLine();

			    System.out.print("Digite o novo título do filme: ");
			    String novoTitulo = sc.nextLine();

			    System.out.print("Digite o novo ano de lançamento do filme: ");
			    String novoAno = sc.nextLine();

			    System.out.print("Digite o novo gênero do filme: ");
			    String novoGenero = sc.nextLine();

			    Filme filmeAtualizado = new Filme(codigoAtualizar, novoTitulo, novoAno, novoGenero);

			    if(dao.atualizarFilme(filmeAtualizado)) {
			        System.out.println("Filme atualizado com sucesso: " + filmeAtualizado);
			    } else {
			        System.out.println("Não foi possível atualizar o filme. Verifique se o código está correto.");
			    }
			} else if(opcao == 3) { // Excluir filme
			    System.out.print("Digite o código do filme a ser excluído: ");
			    int codigoExcluir = sc.nextInt();
			    sc.nextLine(); // limpa buffer

			    if(dao.excluirFilme(codigoExcluir)) {
			        System.out.println("Filme com código " + codigoExcluir + " excluído com sucesso!");
			    } else {
			        System.out.println("Não foi possível excluir o filme. Verifique se o código está correto.");
			    }
			} else if(opcao == 4) { // Mostrar filmes
			    Filme[] filmes = dao.getFilmes();
			    if(filmes != null && filmes.length > 0) {
			        System.out.println("==== Lista de Filmes ====");
			        for(Filme f : filmes) {
			            System.out.println(f.toString());
			        }
			    } else {
			        System.out.println("Nenhum filme cadastrado.");
			    }
			
			} else if(opcao == 5) {
				System.out.println("Finalizando programa...");
				break;
			} else {
				System.out.println("Opção inválida. Digite um opção válida (1, 2, 3, 4, 5).");
			}
		}
		
		dao.close();
		sc.close();
	}
}
