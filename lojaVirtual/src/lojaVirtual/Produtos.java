package lojaVirtual;

import java.math.BigDecimal;

public class Produtos {
	
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private int quantidade;
	
	public Produtos(String nome, String descricao, BigDecimal preco, int quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
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
