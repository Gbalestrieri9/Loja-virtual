package lojaVirtual;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	Produtos produto;

	List<Produtos> estoqueProdutos = new ArrayList<>();

	public void adicionarAoEstoque() {
		estoqueProdutos.add(new Produtos("Whey protein", "isolada 100%", new BigDecimal("100.00"), 5, 01));
		estoqueProdutos.add(new Produtos("Pré treino", "500g", new BigDecimal("25.00"), 10, 02));
		estoqueProdutos.add(new Produtos("Multivitaminico", "40 capsulas", new BigDecimal("9.90"), 4, 03));
		estoqueProdutos.add(new Produtos("BCAA", "300g", new BigDecimal("37.90"), 20, 04));
		estoqueProdutos.add(new Produtos("Albumina", "1kg", new BigDecimal("23.50"), 15, 05));
		estoqueProdutos.add(new Produtos("Creatina", "1kg", new BigDecimal("60.00"), 3, 06));
	}

	public void listarEstoque() {
		System.out.println("\n--- Lista de Produtos ---");
		if (estoqueProdutos.isEmpty()) {
			adicionarAoEstoque();
		}
		for (Produtos produto : estoqueProdutos) {
			System.out.println("Nome: " + produto.getNome() + " Preço: R$" + produto.getPreco() + " Quantidade: "
					+ produto.getQuantidade() + " ID: " + produto.getId()+ "\n");
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
