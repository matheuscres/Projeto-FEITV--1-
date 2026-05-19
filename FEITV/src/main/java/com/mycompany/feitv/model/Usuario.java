package com.mycompany.feitv.model;

/**
 * Representa um usuário na aplicação.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;

    /**
     * Construtor completo para um usuário já salvo no banco de dados.
     * @param id identificador
     * @param nome nome
     * @param email e-mail
     * @param senha senha
     */
    
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Construtor completo para um usuário já salvo no banco de dados.
     * @param nome nome
     * @param email e-mail
     * @param senha senha
     */
    
    public Usuario(String nome, String email, String senha) {
        this(0, nome, email, senha);
    }

    /**
     * @return identificador do usuário
     */
    
    public int getId() { return id; }

    /**
     * Define o identificador do usuário.
     * @param id identificador
     */
    
    public void setId(int id) { this.id = id; }

    /**
     * @return nome do usuário
     */
    
    public String getNome() { return nome; }

    /**
     * Define o nome do usuário.
     * @param nome nome
     */
    
    public void setNome(String nome) { this.nome = nome; }

    /**
     * @return e-mail do usuário
     */
    
    public String getEmail() { return email; }

    /**
     * Define o e-mail do usuário.
     * @param email e-mail
     */
    
    public void setEmail(String email) { this.email = email; }

    /**
     * @return senha do usuário
     */
    
    public String getSenha() { return senha; }

    /**
     * Define a senha do usuário.
     * @param senha senha
     */
    
    public void setSenha(String senha) { this.senha = senha; }
}
