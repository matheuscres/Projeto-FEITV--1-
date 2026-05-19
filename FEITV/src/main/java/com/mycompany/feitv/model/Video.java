package com.mycompany.feitv.model;

/**
 * Representa um vídeo disponível na aplicação.
 */

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

    /**
     * Aumenta o número de curtidas.
     */
    
    public void curtir() {
        likes++;
    }

    /**
     * Aumenta o número de descurtidas.
     */
    
    public void descurtir() {
        dislikes++;
    }

    /**
     * @return identificador do vídeo
     */
    
    public int getId() { return id; }

    /**
     * Define o identificador do vídeo.
     * @param id identificador
     */
    
    public void setId(int id) { this.id = id; }

    /**
     * @return título do vídeo
     */
    
    public String getTitulo() { return titulo; }

    /**
     * Define o título do vídeo.
     * @param titulo titulo
     */
    
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /**
     * @return descrição do vídeo
     */
    
    public String getDescricao() { return descricao; }

    /**
     * Define a descrição do vídeo.
     * @param descricao descricao
     */
    
    public void setDescricao(String descricao) { this.descricao = descricao; }

    /**
     * @return tipo do vídeo
     */
    
    public String getTipo() { return tipo; }

    /**
     * Define o tipo do vídeo.
     * @param tipo tipo
     */
    
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * @return ano do vídeo
     */
    
    public int getAno() { return ano; }

    /**
     * Define o ano do vídeo.
     * @param ano ano
     */
    
    public void setAno(int ano) { this.ano = ano; }

    /**
     * @return categoria do vídeo
     */
    
    public String getCategoria() { return categoria; }

    /**
     * Define a categoria do vídeo.
     * @param categoria categoria
     */
    
    public void setCategoria(String categoria) { this.categoria = categoria; }

    /**
     * @return detalhe do vídeo
     */
    
    public String getDetalhe() { return detalhe; }

    /**
     * Define o detalhe do vídeo.
     * @param detalhe detalhe
     */
    
    public void setDetalhe(String detalhe) { this.detalhe = detalhe; }

    /**
     * @return total de curtidas
     */
    
    public int getLikes() { return likes; }

    /**
     * Define o total de curtidas.
     * @param likes likes
     */
    
    public void setLikes(int likes) { this.likes = likes; }

    /**
     * @return total de descurtidas
     */
    
    public int getDislikes() { return dislikes; }

    /**
     * Define o total de descurtidas.
     * @param dislikes dislikes
     */
    
    public void setDislikes(int dislikes) { this.dislikes = dislikes; }

    /**
     * @return resumo do vídeo
     */
    
    public String getResumo() {
        return String.format("%s | %s | %d", getTitulo(), getTipo(), getAno());
    }

    /**
     * @return representação em texto do vídeo
     */
    
    @Override
    public String toString() {
        return getResumo();
    }
}
