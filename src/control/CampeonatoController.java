package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

import model.Grupo;
import model.Jogo;
import model.Rodada;
import model.Time;

public class CampeonatoController {

    private List<Grupo> grupos;
    private List<Rodada> rodadas;

    public CampeonatoController() {
        this.grupos = new ArrayList<>();
        this.rodadas = new ArrayList<>();
    }

    // Métodos para manipular Grupos
    public void criarGrupo(int codigo, String nome) {
        Grupo grupo = new Grupo(codigo, nome);
        grupos.add(grupo);
    }

    public void alterarGrupo(Grupo grupo, String novoNome) {
        grupo.setNome(novoNome);
    }

    public List<Grupo> filtrarGrupos() {
        return grupos;
    }

    public void removerGrupo(Grupo grupo) {
        grupos.remove(grupo);
    }

    // Métodos para manipular Times
    public void criarTime(Grupo grupo, String nome) {
        Time time = new Time(nome);
        grupo.getTimes().add(time);
    }

    public void alterarTime(Time time, String novoNome) {
        time.setNome(novoNome);
    }

    public List<Time> filtrarTimes(Grupo grupo) {
        return grupo.getTimes();
    }

    public void removerTime(Grupo grupo, Time time) {
        grupo.getTimes().remove(time);
    }

    // Métodos para manipular Jogos
    public void criarJogo(Rodada rodada, Time timeMandante, Time timeVisitante) {
        Jogo jogo = new Jogo(timeMandante, timeVisitante);
        rodada.getJogos().add(jogo);
    }

    public void alterarJogo(Jogo jogo, int golsMandante, int golsVisitante) {
        jogo.setGolsMandante(golsMandante);
        jogo.setGolsVisitante(golsVisitante);
    }

    // Método para registrar resultado da partida
    public void registrarResultado(Rodada rodada, Jogo jogo, int golsMandante, int golsVisitante) {
        alterarJogo(jogo, golsMandante, golsVisitante);

        Time timeMandante = jogo.getMandante();
        Time timeVisitante = jogo.getVisitante();

        if (golsMandante > golsVisitante) {
            timeMandante.setPontos(timeMandante.getPontos() + 3);
        } else if (golsMandante < golsVisitante) {
            timeVisitante.setPontos(timeVisitante.getPontos() + 3);
        } else {
            timeMandante.setPontos(timeMandante.getPontos() + 1);
            timeVisitante.setPontos(timeVisitante.getPontos() + 1);
        }

        // Atualizar saldo de gols
        timeMandante.setSaldoGols(timeMandante.getSaldoGols() + (golsMandante - golsVisitante));
        timeVisitante.setSaldoGols(timeVisitante.getSaldoGols() + (golsVisitante - golsMandante));
    }

    // Método para exibir classificação
    public void exibirClassificacao() {
        for (Grupo grupo : grupos) {
            List<Time> classificacao = new ArrayList<>(grupo.getTimes());
            Collections.sort(classificacao, new Comparator<Time>() {
                @Override
                public int compare(Time time1, Time time2) {
                    // Ordenar por pontos (Critério 1)
                    int resultado = Integer.compare(time2.getPontos(), time1.getPontos());
                    if (resultado == 0) {
                        // Em caso de empate nos pontos, ordenar por saldo de gols (Critério 2)
                        resultado = Integer.compare(time2.getSaldoGols(), time1.getSaldoGols());
                        if (resultado == 0) {
                            // Em caso de empate no saldo de gols, realizar sorteio (Critério 3)
                            Random random = new Random();
                            resultado = random.nextInt(2) - 1; // Sorteio -1, 0 ou 1
                        }
                    }
                    return resultado;
                }
            });

            System.out.println("Classificação do Grupo " + grupo.getNome() + ":");
            int posicao = 1;
            for (Time time : classificacao) {
                System.out.println(posicao + ". " + time.getNome() + " - Pontos: " + time.getPontos() +
                        ", Saldo de Gols: " + time.getSaldoGols());
                posicao++;
            }
        }
    }

    // Métodos para manipular Rodadas
    public void criarRodada(LocalDate data, int numero) {
        Rodada rodada = new Rodada(data, numero);
        rodadas.add(rodada);
    }

    public List<Rodada> filtrarRodadas() {
        return rodadas;
    }
}


