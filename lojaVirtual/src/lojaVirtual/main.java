package lojaVirtual;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario(
				"Gabriel Barros",
				"Rua Antonio Frederico 68",
				"17982275573",
				"gabrielbalestrieri@hotmail.com",
				new Date(),
				"Senha123");
		
		System.out.println("Nome: " + usuario.getNome());
	    System.out.println("Endereço: " + usuario.getEndereco());
	    System.out.println("Telefone: " + usuario.getTelefone());
	    System.out.println("E-mail: " + usuario.getEmail());
	    System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
	    System.out.println("Senha: " + usuario.getSenha());
	    System.out.println("Saldo: R$" + usuario.getSaldo());
	}
}
