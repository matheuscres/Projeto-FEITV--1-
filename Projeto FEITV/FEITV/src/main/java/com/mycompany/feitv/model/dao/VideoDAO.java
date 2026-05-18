package com.mycompany.feitv.model.dao;

import com.mycompany.feitv.model.SerieFilme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    public List<SerieFilme> listarTodos() throws SQLException {
        String sql = "SELECT id, titulo, descricao, tipo, ano, categoria, detalhe, likes, dislikes "
                   + "FROM videos ORDER BY titulo";
        List<SerieFilme> lista = new ArrayList<>();

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    public List<SerieFilme> buscarPorTitulo(String termo) throws SQLException {
        String sql = "SELECT id, titulo, descricao, tipo, ano, categoria, detalhe, likes, dislikes "
                   + "FROM videos WHERE lower(titulo) LIKE lower(?) ORDER BY titulo";
        List<SerieFilme> lista = new ArrayList<>();

        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + termo + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    public SerieFilme buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, titulo, descricao, tipo, ano, categoria, detalhe, likes, dislikes FROM videos WHERE id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    public void atualizarReacoes(int videoId, int likesDelta, int dislikesDelta) throws SQLException {
        String sql = "UPDATE videos SET likes = GREATEST(likes + ?, 0), dislikes = GREATEST(dislikes + ?, 0) WHERE id = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, likesDelta);
            ps.setInt(2, dislikesDelta);
            ps.setInt(3, videoId);
            ps.executeUpdate();
        }
    }

    public int contarVideos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM videos";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    private SerieFilme mapear(ResultSet rs) throws SQLException {
        return new SerieFilme(
            rs.getInt("id"),
            rs.getString("titulo"),
            rs.getString("descricao"),
            rs.getString("tipo"),
            rs.getInt("ano"),
            rs.getString("categoria"),
            rs.getString("detalhe"),
            rs.getInt("likes"),
            rs.getInt("dislikes")
        );
    }
}
