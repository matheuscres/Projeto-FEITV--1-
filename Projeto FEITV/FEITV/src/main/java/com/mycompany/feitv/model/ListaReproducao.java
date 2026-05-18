package com.mycompany.feitv.model;

public class ListaReproducao {
    private int id;
    private int usuarioId;
    private String nome;

    public ListaReproducao(int id, int usuarioId, String nome) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
    }

    public ListaReproducao(int usuarioId, String nome) {
        this(0, usuarioId, nome);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return nome;
    }
}
