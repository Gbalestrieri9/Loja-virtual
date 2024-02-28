package lojaVirtual;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	Produtos produto;

	List<Produtos> estoqueProdutos = new ArrayList<>();

	public void adicionarAoEstoque() {
		estoqueProdutos.add(new Produtos("Whey protein", "isolada 100%", new BigDecimal("120.00"), 10, 05));
		estoqueProdutos.add(new Produtos("Creatina", "1kg", new BigDecimal("25.00"), 10, 02));
	}

	public void listarEstoque() {
		System.out.println("\n--- Lista de Produtos ---");
		if (estoqueProdutos.isEmpty()) {
			adicionarAoEstoque();
		}
		for (Produtos produto : estoqueProdutos) {
			System.out.println("Nome: " + produto.getNome() + " Preço: R$" + produto.getPreco() + " Quantidade: "
					+ produto.getQuantidade() + " ID: " + produto.getId());

		}
	}

	public Produtos listarEstoqueId(int id) {
		for (Produtos produto : estoqueProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
}
