package org.example.model;



import java.time.LocalDate;
import java.util.List;


public class Linhas {
    private LocalDate dataMes;
    private String linha;
    private String onibus;
    private String itinerarios;
    private int problemasRoleta;
    private int problemasKm;
    private int semAbertura;
    private Integer viagensPrevistas;
    private Integer viagensConcluidas;

    public Linhas(LocalDate dataMes, String linha, String onibus, String itinerarios, int problemasRoleta, int problemasKm, int semAbertura, Integer viagensPrevistas, Integer viagensConcluidas) {
        this.dataMes = dataMes;
        this.linha = linha;
        this.onibus = onibus;
        this.itinerarios = itinerarios;
        this.problemasRoleta = problemasRoleta;
        this.problemasKm = problemasKm;
        this.semAbertura = semAbertura;
        this.viagensPrevistas = viagensPrevistas;
        this.viagensConcluidas = viagensConcluidas;
    }

    public LocalDate getDataMes() {
        return dataMes;
    }

    public void setDataMes(LocalDate dataMes) {
        this.dataMes = dataMes;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getOnibus() {
        return onibus;
    }

    public void setOnibus(String onibus) {
        this.onibus = onibus;
    }

    public String getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(String itinerarios) {
        this.itinerarios = itinerarios;
    }

    public int getProblemasRoleta() {
        return problemasRoleta;
    }

    public void setProblemasRoleta(int problemasRoleta) {
        this.problemasRoleta = problemasRoleta;
    }

    public int getProblemasKm() {
        return problemasKm;
    }

    public void setProblemasKm(int problemasKm) {
        this.problemasKm = problemasKm;
    }

    public int getSemAbertura() {
        return semAbertura;
    }

    public void setSemAbertura(int semAbertura) {
        this.semAbertura = semAbertura;
    }

    public Integer getViagensPrevistas() {
        return viagensPrevistas;
    }

    public void setViagensPrevistas(Integer viagensPrevistas) {
        this.viagensPrevistas = viagensPrevistas;
    }

    public Integer getViagensConcluidas() {
        return viagensConcluidas;
    }

    public void setViagensConcluidas(Integer viagensConcluidas) {
        this.viagensConcluidas = viagensConcluidas;
    }
}
