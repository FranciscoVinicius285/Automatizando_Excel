package org.example.Server;

public class RegrasLinhas {
    public int calcularProblema(int problemas, int viagensConcluidas) {

        if (viagensConcluidas == 0) {
            return -1;
        }

        double taxa = (double) problemas / viagensConcluidas;

        return taxa > 0.20 ? 1 : 0;
    }
}
