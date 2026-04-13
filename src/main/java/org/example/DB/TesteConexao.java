package org.example.DB;


import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {

        try (Connection conn = ConnectionFactory.getConnection()) {
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }

    }
}
