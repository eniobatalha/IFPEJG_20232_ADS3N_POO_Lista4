package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rodada {
    private LocalDate data;
    private List<Jogo> jogos;
    private int numero;

    public Rodada (LocalDate data, int numero) {
        this.data = data;
        this.numero = numero;
        this.jogos = new ArrayList<>();
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public List<Jogo> getJogos() {
        return jogos;
    }
    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
