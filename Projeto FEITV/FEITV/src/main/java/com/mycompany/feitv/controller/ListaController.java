package com.mycompany.feitv.controller;

import com.mycompany.feitv.model.dao.ListaReproducaoDAO;
import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.SerieFilme;
import java.sql.SQLException;
import java.util.List;

public class ListaController {
    private final ListaReproducaoDAO listaDAO;

    public ListaController() {
        this.listaDAO = new ListaReproducaoDAO();
    }

    public List<ListaReproducao> listarDoUsuario(int usuarioId) {
        try {
            return listaDAO.listarPorUsuario(usuarioId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar listas.");
        }
    }

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

    public void excluir(int playlistId) {
        try {
            listaDAO.excluir(playlistId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir lista.");
        }
    }

    public void adicionarVideo(int playlistId, int videoId) {
        try {
            listaDAO.adicionarVideo(playlistId, videoId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar vídeo.");
        }
    }

    public void removerVideo(int playlistId, int videoId) {
        try {
            listaDAO.removerVideo(playlistId, videoId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover vídeo.");
        }
    }

    public List<SerieFilme> listarVideos(int playlistId) {
        try {
            return listaDAO.listarVideosDaPlaylist(playlistId);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vídeos.");
        }
    }
}
