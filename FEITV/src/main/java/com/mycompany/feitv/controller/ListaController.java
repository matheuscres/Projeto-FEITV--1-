package com.mycompany.feitv.controller;

import com.mycompany.feitv.model.dao.ListaReproducaoDAO;
import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.SerieFilme;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador responsável pelas operações de negócio relacionadas a listas de reprodução. 
 * Faz a intermediação entre a camada de visão e a ListaReproducaoDAO, 
 * realizando validações e encapsulando o tratamento de exceções de banco de dados.
 */

public class ListaController {

    private final ListaReproducaoDAO listaDAO;

    /**
     * * Construtor padrão que inicializa o DAO de listas de reprodução.
     */
    
    public ListaController() {
        this.listaDAO = new ListaReproducaoDAO();
    }

    /**
     * @param usuarioId ID do usuário proprietário das listas 
     * @return ListaReproducao do usuário
     */
    
    public List<ListaReproducao> listarDoUsuario(int usuarioId) {
        try {
            return listaDAO.listarPorUsuario(usuarioId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar listas.");
        }
    }

    /**
     * Cria uma nova lista de reprodução para o usuário especificado. 
     * @param usuarioId ID do usuário proprietário 
     * @param nome da nova lista
     */
    
    public ListaReproducao criar(int usuarioId, String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe um nome.");
        }
        try {
            return listaDAO.inserir(new ListaReproducao(usuarioId, nome.trim()));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar lista.");
        }
    }

    /**
     * Renomeia uma lista de reprodução existente. 
     * @param playlistId ID da playlist a ser renomeada
     * @param novoNome nome da playlist
     */
    
    public void renomear(int playlistId, String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe um nome.");
        }
        try {
            listaDAO.atualizarNome(playlistId, novoNome.trim());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao renomear lista.");
        }
    }

    /**
     * Exclui permanentemente uma lista de reprodução
     * @param playlistId ID da playlist a ser excluída
     */
    
    public void excluir(int playlistId) {
        try {
            listaDAO.excluir(playlistId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir lista.");
        }
    }

    /**
     * Adiciona um vídeo a uma lista de reprodução. 
     * @param playlistId ID da playlist de destino 
     * @param videoId ID do vídeo a ser adicionado
     */
    
    public void adicionarVideo(int playlistId, int videoId) {
        try {
            listaDAO.adicionarVideo(playlistId, videoId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar vídeo.");
        }
    }

    /**
     * * Vai remover um vídeo de uma lista de reprodução. * @param playlistId ID
     * da playlist de origem * @param videoId ID do vídeo a ser removido
     */
    
    public void removerVideo(int playlistId, int videoId) {
        try {
            listaDAO.removerVideo(playlistId, videoId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover vídeo.");
        }
    }

    /**
     * @param playlistId ID da playlist que os vídeos serão listados 
     * @return lista de SerieFilme que estão na playlist
     */
    
    public List<SerieFilme> listarVideos(int playlistId) {
        try {
            return listaDAO.listarVideosDaPlaylist(playlistId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vídeos.");
        }
    }
}
