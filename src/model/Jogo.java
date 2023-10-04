package model;

public class Jogo {
    // Atributos
    private Time mandante;
    private Time visitante;
    private int golsMandante;
    private int golsVisitante;

    // Construtor
    public Jogo(Time timeMandante, Time timeVisitante) {
        this.mandante = timeMandante;
        this.visitante = timeVisitante;
        this.golsMandante = 0;
        this.golsVisitante = 0;
    }

    // Getters and Setters
    public Time getMandante() {
        return mandante;
    }

    public void setMandante(Time mandante) {
        this.mandante = mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public int getGolsMandante() {
        return golsMandante;
    }

    public void setGolsMandante(int golsMandante) {
        this.golsMandante = golsMandante;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(int golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

}
