package lojaVirtual;
import java.math.BigDecimal;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		
		//BigDecimal b = new BigDecimal("4050.56");
		
		Usuario usuario = new Usuario(
				"Gabriel Barros",
				"Rua Antonio Frederico 68",
				"17982275573",
				"gabrielbalestrieri@hotmail.com",
				new Date(),
				"Senha123");
		
		Produtos produtos = new Produtos("Iphone 12","Celular lançado em 2021",new BigDecimal("4050.56"),3);
		
		System.out.println("Nome: " + produtos.getNome());
	    System.out.println("Descrição: " + produtos.getDescricao());
	    System.out.println("Preço: " + produtos.getPreco());
	    System.out.println("Quantidade: " + produtos.getQuantidade());
	    
	    System.out.println("-----------------------------");
		
		System.out.println("Nome: " + usuario.getNome());
	    System.out.println("Endereço: " + usuario.getEndereco());
	    System.out.println("Telefone: " + usuario.getTelefone());
	    System.out.println("E-mail: " + usuario.getEmail());
	    System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
	    System.out.println("Senha: " + usuario.getSenhaHash());
	    System.out.println("Saldo: R$" + usuario.getSaldo());
	}
}
