package com.mycompany.feitv.controller;

import com.mycompany.feitv.model.dao.UsuarioDAO;
import com.mycompany.feitv.model.Usuario;
import java.sql.SQLException;

/**
 * Controlador responsável pelas operações de usuários.
 * Faz a intermediação entre a camada de visão e o DAO de usuários, mantendo a lógica de negócio organizada.
 */

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    /**
     * Construtor padrão que inicializa o DAO de usuários.
     */
    
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Cadastra um novo usuário no sistema.
     * @param nome nome
     * @param email e-mail
     * @param senha senha
     * @return usuário cadastrado
     */
    
    public Usuario registrar(String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o e-mail.");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Informe a senha.");
        }

        try {
            if (usuarioDAO.buscarPorEmail(email.trim()) != null) {
                throw new IllegalArgumentException("E-mail já cadastrado.");
            }
            Usuario usuario = new Usuario(nome.trim(), email.trim().toLowerCase(), senha);
            return usuarioDAO.inserir(usuario);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário.");
        }
    }

    /**
     * Valida os dados de acesso de um usuário.
     * @param email e-mail
     * @param senha senha
     * @return usuário autenticado
     */
    
    public Usuario autenticar(String email, String senha) {
        if (email == null || email.trim().isEmpty() || senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Preencha e-mail e senha.");
        }
        try {
            return usuarioDAO.autenticar(email.trim().toLowerCase(), senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao entrar.");
        }
    }

    /**
     * @return total de usuários cadastrados
     */
    
    public int totalUsuarios() {
        try {
            return usuarioDAO.contarUsuarios();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar usuários.");
        }
    }
}
