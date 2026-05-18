package com.mycompany.feitv.model;

public class SerieFilme extends Video {

    public SerieFilme(int id, String titulo, String descricao, String tipo, int ano,
                      String categoria, String detalhe, int likes, int dislikes) {
        super(id, titulo, descricao, tipo, ano, categoria, detalhe, likes, dislikes);
    }

    public SerieFilme(String titulo, String descricao, String tipo, int ano,
                      String categoria, String detalhe) {
        this(0, titulo, descricao, tipo, ano, categoria, detalhe, 0, 0);
    }
}
