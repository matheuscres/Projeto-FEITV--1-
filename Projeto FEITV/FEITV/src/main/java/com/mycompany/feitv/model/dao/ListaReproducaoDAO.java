package com.mycompany.feitv.model.dao;

import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.SerieFilme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaReproducaoDAO {

    public List<ListaReproducao> listarPorUsuario(int usuarioId) throws SQLException {
        String sql = "SELECT id, usuario_id, nome FROM playlists WHERE usuario_id = ? ORDER BY nome";
        List<ListaReproducao> lista = new ArrayList<>();
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new ListaReproducao(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getString("nome")
                    ));
                }
            }
        }
        return lista;
    }

    public ListaReproducao inserir(ListaReproducao listaReproducao) throws SQLException {
        String sql = "INSERT INTO playlists (usuario_id, nome) VALUES (?, ?) RETURNING id";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, listaReproducao.getUsuarioId());
            ps.setString(2, listaReproducao.getNome());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    listaReproducao.setId(rs.getInt(1));
                }
            }
        }
        return listaReproducao;
    }

    public void atualizarNome(int playlistId, String novoNome) throws SQLException {
        String sql = "UPDATE playlists SET nome = ? WHERE id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, novoNome);
            ps.setInt(2, playlistId);
            ps.executeUpdate();
        }
    }

    public void excluir(int playlistId) throws SQLException {
        String sql = "DELETE FROM playlists WHERE id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, playlistId);
            ps.executeUpdate();
        }
    }

    public void adicionarVideo(int playlistId, int videoId) throws SQLException {
        String sql = "INSERT INTO playlist_videos (playlist_id, video_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, playlistId);
            ps.setInt(2, videoId);
            ps.executeUpdate();
        }
    }

    public void removerVideo(int playlistId, int videoId) throws SQLException {
        String sql = "DELETE FROM playlist_videos WHERE playlist_id = ? AND video_id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, playlistId);
            ps.setInt(2, videoId);
            ps.executeUpdate();
        }
    }

    public List<SerieFilme> listarVideosDaPlaylist(int playlistId) throws SQLException {
        String sql = "SELECT v.id, v.titulo, v.descricao, v.tipo, v.ano, v.categoria, v.detalhe, v.likes, v.dislikes "
                   + "FROM videos v INNER JOIN playlist_videos pv ON v.id = pv.video_id "
                   + "WHERE pv.playlist_id = ? ORDER BY v.titulo";
        List<SerieFilme> lista = new ArrayList<>();
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, playlistId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new SerieFilme(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("tipo"),
                        rs.getInt("ano"),
                        rs.getString("categoria"),
                        rs.getString("detalhe"),
                        rs.getInt("likes"),
                        rs.getInt("dislikes")
                    ));
                }
            }
        }
        return lista;
    }
}
