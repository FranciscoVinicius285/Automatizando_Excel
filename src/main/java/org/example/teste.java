package org.example;

import org.example.Server.CriaArquivoExcel;
import org.example.model.Linhas;
import org.example.repository.LinhasRepository;

import java.util.List;

public class teste {
    public static void main(String[] args) {
        LinhasRepository repo = new LinhasRepository();
        List<Linhas> dados = repo.buscarTodos();

        new CriaArquivoExcel().criarArquivo("relatorioTest.xlsx", dados);
    }
}
