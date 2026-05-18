package com.mycompany.feitv.model;

public class Video {
    private int id;
    private String titulo;
    private String descricao;
    private String tipo;
    private int ano;
    private String categoria;
    private String detalhe;
    private int likes;
    private int dislikes;

    protected Video() {
    }

    protected Video(int id, String titulo, String descricao, String tipo, int ano,
                    String categoria, String detalhe, int likes, int dislikes) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.ano = ano;
        this.categoria = categoria;
        this.detalhe = detalhe;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public void curtir() {
        likes++;
    }

    public void descurtir() {
        dislikes++;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDetalhe() { return detalhe; }
    public void setDetalhe(String detalhe) { this.detalhe = detalhe; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getDislikes() { return dislikes; }
    public void setDislikes(int dislikes) { this.dislikes = dislikes; }

    public String getResumo() {
        return String.format("%s | %s | %d", getTitulo(), getTipo(), getAno());
    }

    @Override
    public String toString() {
        return getResumo();
    }
}
