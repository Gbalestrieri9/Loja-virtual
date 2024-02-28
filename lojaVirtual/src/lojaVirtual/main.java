package lojaVirtual;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MenuDeControle menu = new MenuDeControle();
		
		int acaoDigitada;
		int produtoId=0;
		int quantidade= 0;
		boolean executando = true;
				
		while(executando) {
			try {
				System.out.println("---MENU DE CONTROLE---\n"
						+ "1.Se cadastre\n"
						+ "2.Logar\n"
						+ "3.Visualizar os produtos\n"
						+ "4.Efetuar compra\n"
						+ "5.Visualize seus dados\n"
						+ "6.Sair \n");
				
				System.out.println("Digite a numeração que deseja selecionar acima:");
				acaoDigitada = input.nextInt();
				input.nextLine();
				System.out.println("\n");
				
				if(acaoDigitada == 6) {
					executando = false;
					input.close();
					System.out.println("Programa finalizado com sucesso!");
				}else {
					menu.controle(acaoDigitada, produtoId, quantidade);
				}
			}catch(Exception e) {
				System.out.println("Digite apenas os numeros disponiveis no menu de controle\n");
				input.nextLine();
			}
		}	
	}
}
