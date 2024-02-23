package lojaVirtual;

import java.math.BigDecimal;

public class Produtos {
	
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private int quantidade;
	private int id;
	
	public Produtos(String nome, String descricao, BigDecimal preco, int quantidade, int id) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void estoque (int quantidadeVendida) {
		this.quantidade -= quantidadeVendida;
	}
}
