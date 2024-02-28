package lojaVirtual;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Usuario {
    Scanner leitor = new Scanner(System.in);

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String senhaHash;
    private BigDecimal saldo;

    private static Map<String, Usuario> usuarios = new HashMap<>();

    public Usuario(String nome, String endereco, String telefone, String email, String dataNascimento, String senha) {
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
    	System.out.println("Seu perfil: ");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("E-mail: " + getEmail());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("Saldo disponivel: R$" + getSaldo()+ "\n");
    }

    public void cadastrar() {
        System.out.println("Coloque seu nome:");
        String nome = leitor.next();
        setNome(nome);
        
        leitor.nextLine();

        System.out.println("Coloque seu endereço:");
        String endereco = leitor.next();
        setEndereco(endereco);
        
        leitor.nextLine();

        System.out.println("Coloque seu telefone:");
        String telefone = leitor.nextLine();
        setTelefone(telefone);

        System.out.println("Coloque seu email:");
        String email = leitor.nextLine();
        setEmail(email);

        System.out.println("Digite a data de aniversário (dd/MM/yyyy):");
        String dataDeAniversario = leitor.next();
        setDataNascimento(dataDeAniversario);

        System.out.println("Crie uma senha:");
        String senhaHash = leitor.next();
        setSenhaHash(senhaHash);

        setSaldo(new BigDecimal("100.0"));

        adicionarUsuario(this);
        
        System.out.println("Usuario criado com sucesso\n");
    }

    public boolean realizarLogin() {
        System.out.println("Nome de login:");
        String nomeUsuario = leitor.next();
        
        leitor.nextLine();

        System.out.println("Senha:");
        String senha = leitor.next();

        Usuario usuario = usuarios.get(nomeUsuario);
        if (usuario != null && usuario.getSenhaHash().equals(hashSenha(senha))) {
            System.out.println("Login bem-sucedido para o usuário: " + nomeUsuario);
            return true;
        } else {
            System.out.println("Usuário ou senha incorretos. Falha no login.");
            return false;
        }
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNome(), usuario);
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senha) {
        this.senhaHash = hashSenha(senha);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debitarSaldo(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }
}