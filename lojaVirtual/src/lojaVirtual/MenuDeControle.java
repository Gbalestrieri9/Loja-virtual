package lojaVirtual;

import java.util.Scanner;

public class MenuDeControle {
	Scanner input = new Scanner(System.in);
	Estoque estoque = new Estoque();
	Usuario usuario = new Usuario("Fulano silva", "Rua Antonio Silva 35", "11999999993",
			"fulanosilva@gmail.com","15/02/1996", "Senha321");

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
		try {
			estoque.listarEstoque();

			System.out.println("\n");
			System.out.println("Coloque o ID do produto que deseja comprar: ");
			int produtoId = input.nextInt();
			input.nextLine();
			System.out.println("\n");

			System.out.println("\n");
			System.out.println("Qual a quantidade você deseja?");
			int quantidade = input.nextInt();
			input.nextLine();
			System.out.println("\n");

			Produtos produtoSelecionado = estoque.listarEstoqueId(produtoId);

			if (produtoSelecionado != null) {
				Venda venda = new Venda(produtoSelecionado, usuario, quantidade);
				venda.realizarVenda();
			}
		}catch(Exception e) {
			System.out.println("Digite apenas os ID disponiveis ou a quantidade desejada\n");
			input.nextLine();
		}
	}
	
	private void mostrarDadosCliente() {
		usuario.chamarUsuario();
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
		case 5:
			mostrarDadosCliente();
			break;
		}
	}
}
