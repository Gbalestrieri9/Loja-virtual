package lojaVirtual;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MenuDeControle menu = new MenuDeControle();
		
		int acaoDigitada;
		boolean executando = true;
		
		while(executando) {
			System.out.println("---MENU DE CONTROLE---\n"
					+ "1.Se cadastre\n"
					+ "2.Logar\n"
					+ "3.Visualizar os produtos\n"
					+ "4.Efetuar compra\n"
					+ "5.Sair \n");
			
			System.out.println("Digite a numeração que deseja selecionar acima:");
			acaoDigitada = input.nextInt();
			input.nextLine();
			System.out.println("\n");
			
			menu.controle(acaoDigitada);
		}	
	}
}
