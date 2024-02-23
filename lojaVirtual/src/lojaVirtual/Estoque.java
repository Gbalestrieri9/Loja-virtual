package lojaVirtual;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Estoque {
	Produtos produto;
	
	ArrayList<Produtos> estoque = new ArrayList<>();
	
	void adicionarAoEstoque() {
		estoque.add(new Produtos("Whey protein","isolada 100%",new BigDecimal("120.00"),10,05));
		estoque.add(new Produtos("Creatina","1kg",new BigDecimal("25.00"),10,02));
	}
	
	public void listarEstoque() {
		adicionarAoEstoque();
		System.out.println("\n--- Lista de Produtos ---");
        if (estoque.isEmpty()) {
            System.out.println("Não há produtos.\n");
        } else {
			for (Produtos produto : estoque) {
				System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco()+ ", ID: " + produto.getId());
			}
        }
	}
	
	public void listarEstoqueId() {
		
	}
}
