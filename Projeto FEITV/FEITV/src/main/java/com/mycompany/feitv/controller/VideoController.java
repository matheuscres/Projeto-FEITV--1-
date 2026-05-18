package com.mycompany.feitv.controller;

import com.mycompany.feitv.model.dao.ReacaoDAO;
import com.mycompany.feitv.model.dao.VideoDAO;
import com.mycompany.feitv.model.SerieFilme;
import java.sql.SQLException;
import java.util.List;

public class VideoController {
    private final VideoDAO videoDAO;
    private final ReacaoDAO reacaoDAO;

    public VideoController() {
        this.videoDAO = new VideoDAO();
        this.reacaoDAO = new ReacaoDAO();
    }

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

    public SerieFilme buscarPorId(int id) {
        try {
            return videoDAO.buscarPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar vídeo.");
        }
    }

    public void curtir(int usuarioId, int videoId) {
        registrarReacao(usuarioId, videoId, 'L');
    }

    public void descurtir(int usuarioId, int videoId) {
        registrarReacao(usuarioId, videoId, 'D');
    }

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
