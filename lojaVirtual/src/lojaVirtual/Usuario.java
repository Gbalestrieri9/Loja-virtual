package lojaVirtual;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Usuario {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private String senhaHash;
	private double saldo;

	public Usuario(String nome, String endereco, String telefone, String email, Date dataNascimento, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senhaHash = hashSenha(senha);
		this.saldo = 100.0;
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

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getSenha() {
		return senhaHash;
	}
	
	public boolean verificarSenha(String senha) {
        return this.senhaHash.equals(hashSenha(senha));
    }

	public double getSaldo() {
		return saldo;
	}
}
