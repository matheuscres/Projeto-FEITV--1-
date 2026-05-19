package com.mycompany.feitv.model;

/**
 * Representa uma lista de reprodução na aplicação.
 */

public class ListaReproducao {
    private int id;
    private int usuarioId;
    private String nome;

    /**
     * Construtor completo para uma lista de reprodução já salva no banco de dados.
     * @param id identificador
     * @param usuarioId ID do usuário
     * @param nome nome
     */
    
    public ListaReproducao(int id, int usuarioId, String nome) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    /**
     * Construtor completo para uma lista de reprodução já salva no banco de dados.
     * @param usuarioId ID do usuário
     * @param nome nome
     */
    
    public ListaReproducao(int usuarioId, String nome) {
        this(0, usuarioId, nome);
    }

    /**
     * @return identificador da lista
     */
    
    public int getId() { return id; }

    /**
     * Define o identificador da lista.
     * @param id identificador
     */
   
    public void setId(int id) { this.id = id; }

    /**
     * @return identificador do usuário
     */
    
    public int getUsuarioId() { return usuarioId; }

    /**
     * Define o identificador do usuário.
     * @param usuarioId ID do usuário
     */
    
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    /**
     * @return nome da lista
     */
    
    public String getNome() { return nome; }

    /**
     * Define o nome da lista.
     * @param nome nome
     */
    
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Retorna uma representação em texto da lista de reprodução.
     * @return representação em texto da lista de reprodução
     */
    
    @Override
    public String toString() {
        return nome;
    }
}
