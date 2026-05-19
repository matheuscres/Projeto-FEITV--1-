package com.mycompany.feitv.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 /**
 * Objeto de acesso a dados responsável pelas reações dos usuários.
 * Centraliza as operações de banco de dados relacionadas à entidade.
 */
public class ReacaoDAO {

     /**
     * Registra a reação do usuário e atualiza os contadores do vídeo.
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     * @param tipo tipo
     * @throws java.sql.SQLException
     */
    
    public void registrarReacao(int usuarioId, int videoId, char tipo) throws SQLException {
        try (Connection conn = new Conexao().getConnection()) {
            conn.setAutoCommit(false);
            try {
                Character atual = buscarReacaoAtual(conn, usuarioId, videoId);

                if (atual == null) {
                    inserirReacao(conn, usuarioId, videoId, tipo);
                    ajustarContadores(conn, videoId, tipo == 'L' ? 1 : 0, tipo == 'D' ? 1 : 0);
                } else if (atual == tipo) {
                    removerReacao(conn, usuarioId, videoId);
                    ajustarContadores(conn, videoId, tipo == 'L' ? -1 : 0, tipo == 'D' ? -1 : 0);
                } else {
                    atualizarReacao(conn, usuarioId, videoId, tipo);
                    if (atual == 'L') {
                        ajustarContadores(conn, videoId, -1, +1);
                    } else {
                        ajustarContadores(conn, videoId, +1, -1);
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

     /**
     * Busca a reação do usuário e atualiza os contadores do vídeo.
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     */
    
    private Character buscarReacaoAtual(Connection conn, int usuarioId, int videoId) throws SQLException {
        String sql = "SELECT tipo FROM reacoes WHERE usuario_id = ? AND video_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ps.setInt(2, videoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getString(1).charAt(0);
            }
        }
        return null;
    }
    
     /**
     * Insere a reação do usuário e atualiza os contadores do vídeo.
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     * @param tipo tipo
     */
    
    private void inserirReacao(Connection conn, int usuarioId, int videoId, char tipo) throws SQLException {
        String sql = "INSERT INTO reacoes (usuario_id, video_id, tipo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ps.setInt(2, videoId);
            ps.setString(3, String.valueOf(tipo));
            ps.executeUpdate();
        }
    }
    
     /**
     * Atualiza a reação do usuário no pgadmin(PostGreSQL).
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     * @param tipo tipo
     */
    
    private void atualizarReacao(Connection conn, int usuarioId, int videoId, char tipo) throws SQLException {
        String sql = "UPDATE reacoes SET tipo = ? WHERE usuario_id = ? AND video_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(tipo));
            ps.setInt(2, usuarioId);
            ps.setInt(3, videoId);
            ps.executeUpdate();
        }
    }
    
     /**
     * Remove a reação do usuário no pgadmin(PostGreSQL).
     * @param usuarioId ID do usuário
     * @param videoId ID do vídeo
     */
    

    private void removerReacao(Connection conn, int usuarioId, int videoId) throws SQLException {
        String sql = "DELETE FROM reacoes WHERE usuario_id = ? AND video_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ps.setInt(2, videoId);
            ps.executeUpdate();
        }
    }
    
     /**
     * Ajusta os contadores(like e dislike) e atualiza eles.
     * @param videoId ID do vídeo
     * @param likesDelta likes dados
     * @param dislikesDelta dislikes dados
     */
    
    private void ajustarContadores(Connection conn, int videoId, int likesDelta, int dislikesDelta) throws SQLException {
        String sql = "UPDATE videos SET likes = GREATEST(likes + ?, 0), dislikes = GREATEST(dislikes + ?, 0) WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, likesDelta);
            ps.setInt(2, dislikesDelta);
            ps.setInt(3, videoId);
            ps.executeUpdate();
        }
    }
}
