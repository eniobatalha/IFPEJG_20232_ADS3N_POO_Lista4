package model;

public class Time {
    // Atributos
    private String nome;
    private int pontos;
    private int saldoGols;

    // Construtor
    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.saldoGols = 0;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public int getSaldoGols() {
        return saldoGols;
    }
    public void setSaldoGols(int saldoGols) { this.saldoGols = saldoGols; }

}
