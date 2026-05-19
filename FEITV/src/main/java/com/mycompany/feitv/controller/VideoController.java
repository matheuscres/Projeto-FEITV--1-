package com.mycompany.feitv.controller;

import com.mycompany.feitv.model.dao.ReacaoDAO;
import com.mycompany.feitv.model.dao.VideoDAO;
import com.mycompany.feitv.model.SerieFilme;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador responsável pelas operações de vídeos.
 * Faz a intermediação entre a camada de visão e os DAOs de vídeos e reações, mantendo a lógica de negócio organizada.
 */

public class VideoController {
    private final VideoDAO videoDAO;
    private final ReacaoDAO reacaoDAO;

    /**
     * Construtor padrão que inicializa os DAOs de vídeos e reações.
     */
    
    public VideoController() {
        this.videoDAO = new VideoDAO();
        this.reacaoDAO = new ReacaoDAO();
    }

    /**
     * @param termo termo de busca
     * @return lista de vídeos encontrados
     */
    
    public List<SerieFilme> listar(String termo) {
        try {
            if (termo == null || termo.trim().isEmpty()) {
                return videoDAO.listarTodos();
            }
            return videoDAO.buscarPorTitulo(termo.trim());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar vídeos.");
        }
    }

    /**
     * Registra uma curtida para o vídeo informado.
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     */
    
    public void curtir(int usuarioId, int videoId) {
        registrarReacao(usuarioId, videoId, 'L');
    }

    /**
     * Registra uma descurtida para o vídeo informado.
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     */
    
    public void descurtir(int usuarioId, int videoId) {
        registrarReacao(usuarioId, videoId, 'D');
    }

    /**
     * @return total de vídeos cadastrados
     */
    
    public int totalVideos() {
        try {
            return videoDAO.contarVideos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar vídeos.");
        }
    }

    private void registrarReacao(int usuarioId, int videoId, char tipo) {
        try {
            reacaoDAO.registrarReacao(usuarioId, videoId, tipo);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar reação.");
        }
    }
}
