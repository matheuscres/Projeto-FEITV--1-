package com.mycompany.feitv.model;

/**
 * Representa um conteúdo do tipo série ou filme na aplicação.
 */

public class SerieFilme extends Video {

    /**
     * Construtor completo para um conteúdo já salvo no banco de dados.
     * @param id identificador
     * @param titulo titulo
     * @param descricao descricao
     * @param tipo tipo
     * @param ano ano
     * @param categoria categoria
     * @param detalhe detalhe
     * @param likes likes
     * @param dislikes dislikes
     */
    
    public SerieFilme(int id, String titulo, String descricao, String tipo, int ano,
                      String categoria, String detalhe, int likes, int dislikes) {
        super(id, titulo, descricao, tipo, ano, categoria, detalhe, likes, dislikes);
    }

    /**
     * Construtor completo para um conteúdo já salvo no banco de dados.
     * @param titulo titulo
     * @param descricao descricao
     * @param tipo tipo
     * @param ano ano
     * @param categoria categoria
     * @param detalhe detalhe
     */
    
    public SerieFilme(String titulo, String descricao, String tipo, int ano,
                      String categoria, String detalhe) {
        this(0, titulo, descricao, tipo, ano, categoria, detalhe, 0, 0);
    }
}
