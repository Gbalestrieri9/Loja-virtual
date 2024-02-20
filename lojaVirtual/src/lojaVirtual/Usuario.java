package lojaVirtual;

import java.math.BigDecimal;
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
	private BigDecimal saldo;

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
