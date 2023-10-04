package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import control.CampeonatoController;
import model.Grupo;
import model.Jogo;
import model.Rodada;

public class Main {

    public static void main(String[] args) {
        CampeonatoController controller = new CampeonatoController();
        Scanner scanner = new Scanner(System.in);

        // Criação de grupos
        controller.criarGrupo(1, "Grupo A");
        controller.criarGrupo(2, "Grupo B");

        // Criação de times
        Grupo grupoA = controller.filtrarGrupos().get(0);
        controller.criarTime(grupoA, "Palmeiras");
        controller.criarTime(grupoA, "Corinthians");
        controller.criarTime(grupoA, "São Paulo");
        controller.criarTime(grupoA, "Santos");

        Grupo grupoB = controller.filtrarGrupos().get(1);
        controller.criarTime(grupoB, "Fluminense");
        controller.criarTime(grupoB, "Flamengo");
        controller.criarTime(grupoB, "Botafogo");
        controller.criarTime(grupoB, "Vasco");

        // Criação de rodadas
        controller.criarRodada(LocalDate.of(2023, 10, 10), 1);
        controller.criarRodada(LocalDate.of(2023, 10, 17), 2);

        // Criação de jogos
        List<Rodada> rodadas = controller.filtrarRodadas();
        controller.criarJogo(rodadas.get(0), grupoA.getTimes().get(0), grupoA.getTimes().get(1));
        controller.criarJogo(rodadas.get(0), grupoB.getTimes().get(0), grupoB.getTimes().get(1));
        controller.criarJogo(rodadas.get(0), grupoA.getTimes().get(2), grupoA.getTimes().get(3));
        controller.criarJogo(rodadas.get(0), grupoB.getTimes().get(2), grupoB.getTimes().get(3));
        controller.criarJogo(rodadas.get(1), grupoA.getTimes().get(3), grupoA.getTimes().get(0));
        controller.criarJogo(rodadas.get(1), grupoB.getTimes().get(3), grupoB.getTimes().get(0));
        controller.criarJogo(rodadas.get(1), grupoA.getTimes().get(1), grupoA.getTimes().get(2));
        controller.criarJogo(rodadas.get(1), grupoB.getTimes().get(1), grupoB.getTimes().get(2));

        // Simulando os resultados dos jogos e registrando-os
        System.out.println("Simule os resultados dos jogos:");
        for (Rodada rodada : rodadas) {
            List<Jogo> jogos = rodada.getJogos();
            for (Jogo jogo : jogos) {
                System.out.print(jogo.getMandante().getNome() + " vs. " + jogo.getVisitante().getNome() + ": ");
                int golsMandante = scanner.nextInt();
                int golsVisitante = scanner.nextInt();
                controller.registrarResultado(rodada, jogo, golsMandante, golsVisitante);
            }
        }

        // Exibindo a classificação após os jogos
        controller.exibirClassificacao();

        scanner.close();
    }
}
