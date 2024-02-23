package lojaVirtual;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Usuario {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private String senhaHash;
	private BigDecimal saldo;
	
	ArrayList<Usuario> usuarios = new ArrayList<>();

	public Usuario(String nome, String endereco, String telefone, String email, Date dataNascimento, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senhaHash = hashSenha(senha);
		this.saldo = new BigDecimal("100.0");
	}
	
	private String hashSenha(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public void chamarUsuario() {
		System.out.println("Nome: " + getNome());
	    System.out.println("Endereço: " + getEndereco());
	    System.out.println("Telefone: " + getTelefone());
	    System.out.println("E-mail: " + getEmail());
	    System.out.println("Data de Nascimento: " + getDataNascimento());
	    System.out.println("Senha: " + getSenhaHash());
	    System.out.println("Saldo: R$" + getSaldo());
	}
	
	private void cadastrar() {
		Scanner leitor = new Scanner(System.in);
	    
	    String nome = leitor.next();
	    setNome(nome);

	    String endereco = leitor.next();
	    setEndereco(endereco);

	    String telefone = leitor.next();
	    setTelefone(telefone);

	    String email = leitor.next();
	    setEmail(email);
	    
	    System.out.println("Digite a data de aniversário (dd/MM/yyyy):");
        String dataDeAniversarioString = leitor.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
			setDataNascimento(dateFormat.parse(dataDeAniversarioString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
	    String senhaHash = leitor.next();
	    setSenhaHash(senhaHash);
	   
	    setSaldo(new BigDecimal ("100.0"));

	    salvarUsuario(this);
	}
	
	private void salvarUsuario(Usuario usuarioCapturado) {
		usuarios.add(usuarioCapturado);
	}
	
	
	public void efetuarLogin() {
			
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenhaHash() {
		return senhaHash;
	}
	public boolean verificarSenha(String senha) {
        return this.senhaHash.equals(hashSenha(senha));
    }
	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public void debitarSaldo(BigDecimal valor) {
		this.saldo = this.saldo.subtract(valor) ;
	}
	
}
