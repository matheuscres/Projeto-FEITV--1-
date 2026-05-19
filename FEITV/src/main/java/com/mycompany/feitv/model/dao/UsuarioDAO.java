package com.mycompany.feitv.model.dao;

import com.mycompany.feitv.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Objeto de acesso a dados responsável pelos usuários.
 */

public class UsuarioDAO {

    /**
     * Insere um novo usuário no banco de dados.
     * @param usuario usuário
     * @return usuário inserido
     */
    
    public Usuario inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }
        }
        return usuario;
    }

    /**
     * Busca um usuário pelo e-mail informado.
     * @param email e-mail
     * @return usuário encontrado
     */
    
    public Usuario buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT id, nome, email, senha FROM usuarios WHERE lower(email) = lower(?)";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                    );
                }
            }
        }
        return null;
    }

    /**
     * Valida o login de um usuário no banco de dados.
     * @param email e-mail
     * @param senha senha
     * @return usuário autenticado
     */
    
    public Usuario autenticar(String email, String senha) throws SQLException {
        String sql = "SELECT id, nome, email, senha FROM usuarios WHERE lower(email) = lower(?) AND senha = ?";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                    );
                }
            }
        }
        return null;
    }

    /**
     * Conta o total de usuários
     * @return total de usuários cadastrados
     */
    
    public int contarUsuarios() throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios";
        try (Connection conn = new Conexao().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        }
    }
}
