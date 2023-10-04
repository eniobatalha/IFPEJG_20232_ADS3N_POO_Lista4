package model;

import java.util.List;
import java.util.ArrayList;

public class Grupo {
    private int codigo;
    private String nome;
    private List<Time> times;

    public Grupo (int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.times = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }


}
