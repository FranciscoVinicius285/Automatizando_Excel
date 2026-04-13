package org.example.Server;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Linhas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CriaArquivoExcel {

    private RegrasLinhas regrasLinhas = new RegrasLinhas();

    public void criarArquivo(final String nomeArquivo, final List<Linhas> linhas){
        System.out.println("Arquivo criado: " + nomeArquivo);

        try(var workbook = new XSSFWorkbook();
            var outputStream = new FileOutputStream(nomeArquivo)){
            var planilha = workbook.createSheet("Lista Teste");
            int numeroDaLinha = 0;

            adicionarCabecalho(planilha, numeroDaLinha++);

            for(Linhas linha : linhas){
                Row linhaExcel = planilha.createRow(numeroDaLinha++);
                adicionarCelulaString(linhaExcel, 0, linha.getDataMes().toString());
                adicionarCelulaString(linhaExcel, 1, linha.getLinha());
                adicionarCelulaString(linhaExcel, 2, linha.getOnibus());
                adicionarCelulaString(linhaExcel, 3, linha.getItinerarios());
                adicionarCelulaInt(linhaExcel, 4,
                        regrasLinhas.calcularProblema(linha.getProblemasRoleta(), linha.getViagensConcluidas()));

                adicionarCelulaInt(linhaExcel, 5,
                        regrasLinhas.calcularProblema(linha.getProblemasKm(), linha.getViagensConcluidas()));

                adicionarCelulaInt(linhaExcel, 6,
                        regrasLinhas.calcularProblema(linha.getSemAbertura(), linha.getViagensConcluidas()));
                adicionarCelulaInt(linhaExcel, 7, linha.getViagensPrevistas());
                adicionarCelulaInt(linhaExcel, 8, linha.getViagensConcluidas());

            }

            workbook.write(outputStream);

        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado: {}" + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: {} " + nomeArquivo);
        }
        System.out.println("Arquivo gerado com sucesso!");

    }

    private void adicionarCabecalho(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelulaString(linha, 0, "DATA/MES");
        adicionarCelulaString(linha, 1, "LINHA");
        adicionarCelulaString(linha, 2, "ONIBUS");
        adicionarCelulaString(linha, 3, "ITINERARIA");
        adicionarCelulaString(linha, 4, "PROBLEMA DE ROLETA");
        adicionarCelulaString(linha, 5, "PROBLEMA DE KILOMETRAGEM");
        adicionarCelulaString(linha, 6, "PROBLEMA DE ABERTURA");
        adicionarCelulaString(linha, 7, "VIAGENS PREVISTAS");
        adicionarCelulaString(linha, 8, "VIAGENS CONCLUIDAS");
    }

    private void adicionarCelulaString(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelulaInt(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

}

