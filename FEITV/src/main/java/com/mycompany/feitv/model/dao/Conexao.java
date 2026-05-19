package com.mycompany.feitv.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Responsável por fornecer conexões com o banco de dados da aplicação FEITV.
 * Centraliza a configuração de acesso ao PostgreSQL.
 */
public class Conexao {

    /**
     * Retorna uma conexão com o banco de dados.
     * @return conexão com o banco de dados
     */
    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/feitv", "postgres", "fei");
        return conexao;
    }
}
