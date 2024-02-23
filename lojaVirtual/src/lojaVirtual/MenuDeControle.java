package lojaVirtual;

import java.util.Date;
import java.math.BigDecimal;

public class MenuDeControle {
	Estoque estoque = new Estoque();
	Produtos produto = new Produtos("omega 3","500mg", new BigDecimal("32.00"),10, 03);
	Usuario usuario = new Usuario(
			"Gabriel Barros",
			"Rua Antonio Frederico 68",
			"17982275573",
			"gabrielbalestrieri@hotmail.com",
			new Date(),
			"Senha123");
	Venda venda = new Venda(produto, usuario, 3);
	
	
	private void cadastrar() {
		usuario.efetuarLogin();
	}
	
	private void logar() {
		usuario.efetuarLogin();
	}
	
	private void mostrarProdutos() {
		estoque.listarEstoque();
	}
	
	private void comprar() {
		estoque.listarEstoque();
		venda.realizarVenda();
	}
	
	private void sair() {
		
	}

	public void controle(int acaoSelecionada) {
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
			sair();
			break;
		}
	}
}
