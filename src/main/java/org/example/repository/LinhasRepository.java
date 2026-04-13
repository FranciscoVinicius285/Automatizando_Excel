package org.example.repository;



import org.example.DB.ConnectionFactory;
import org.example.model.Linhas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LinhasRepository {

    public List<Linhas> buscarTodos() {

        List<Linhas> lista = new ArrayList<>();

        String sql = "SELECT * FROM operacao_onibus";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Linhas linha = new Linhas(
                        rs.getDate("data_mes").toLocalDate(),
                        rs.getString("linha"),
                        rs.getString("onibus"),
                        rs.getString("itinerarios"),
                        rs.getInt("problemas_roleta"),
                        rs.getInt("problemas_km"),
                        rs.getInt("sem_abertura"),
                        rs.getInt("viagens_previstas"),
                        rs.getInt("viagens_concluidas")
                );

                lista.add(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}