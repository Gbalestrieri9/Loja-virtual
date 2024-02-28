package lojaVirtual;

import java.util.Scanner;

public class MenuDeControle {
	Scanner input = new Scanner(System.in);
	Estoque estoque = new Estoque();
	Usuario usuario = new Usuario("Gabriel Barros", "Rua Antonio Frederico 68", "17982275573",
			"gabrielbalestrieri@hotmail.com","15/02/1996", "Senha123");

	private void cadastrar() {
		usuario.cadastrar();
	}

	private void logar() {
		usuario.realizarLogin();
	}

	private void mostrarProdutos() {
		estoque.listarEstoque();
	}

	private void comprar() {
		estoque.listarEstoque();

		System.out.println("\n");
		System.out.println("Qual produto voce deseja comprar?");
		int produtoId = input.nextInt();
		input.nextLine();
		System.out.println("\n");

		System.out.println("\n");
		System.out.println("Qual a quantidade voce deseja?");
		int quantidade = input.nextInt();
		input.nextLine();
		System.out.println("\n");

		Produtos produtoSelecionado = estoque.listarEstoqueId(produtoId);

		if (produtoSelecionado != null) {
			Venda venda = new Venda(produtoSelecionado, usuario, quantidade);
			venda.realizarVenda();
		}
	}
	
	public void controle(int acaoSelecionada, int produtoId, int quantidade) {
		switch (acaoSelecionada) {
		case 1:
			cadastrar();
			break;
		case 2:
			logar();
			break;
		case 3:
			mostrarProdutos();
			break;
		case 4:
			comprar();
			break;
		}
	}
}
