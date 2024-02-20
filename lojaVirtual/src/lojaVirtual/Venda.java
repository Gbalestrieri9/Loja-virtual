package lojaVirtual;

import java.math.BigDecimal;

public class Venda {
	
	private Produtos produto;
	private Usuario usuario;
	private int quantidade;
	
	public Venda(Produtos produto, Usuario usuario, int quantidade) {
		this.produto = produto;
		this.usuario = usuario;
		this.quantidade = quantidade;
	}
	
	public void realizarVenda() {
		if(produto.getQuantidade() >= quantidade) {
			BigDecimal totalVenda = BigDecimal.valueOf(quantidade).multiply(produto.getPreco());
			if(usuario.getSaldo().compareTo(totalVenda) >= 0) {
				usuario.debitarSaldo(totalVenda);
				produto.estoque(quantidade);
				System.out.println("Venda realizada com sucesso");
			}else {
				System.out.println("Saldo insuficiente!");
			}
		}else {
			System.out.println("Quantidade no estoque indisponivel");
		}
	}
	

}
