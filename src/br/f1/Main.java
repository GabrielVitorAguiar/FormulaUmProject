package br.f1;

import br.f1.carro.CarroF1;
import br.f1.equipe.EquipeF1;
import br.f1.estrategia.*;
import br.f1.telemetria.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome da equipe: ");
        String nomeEquipe = sc.nextLine();
        EquipeF1 equipe = EquipeF1.getInstancia(nomeEquipe);

        System.out.print("Nome do piloto: ");
        String pilotoNome = sc.nextLine();
        System.out.print("Número do carro: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Motor: ");
        String motor = sc.nextLine();

        CarroF1 carro = new CarroF1.Builder()
                .piloto(pilotoNome)
                .numero(numero)
                .motor(motor)
                .build();

        System.out.println("Escolha o circuito:");
        System.out.println("Monaco, Silverstone, Spa, Suzuka, Interlagos, Mexico, COTA, Zandvoort, Hungaroring, Bahrain, Jeddah, Miami, LasVegas");
        String circuito = sc.nextLine();

        CircuitoRecomendacao recomendacao = new CircuitoRecomendacao();
        System.out.println("Recomendação automática para " + circuito + ":");
        System.out.println(recomendacao.recomendacaoResumo(circuito));

        System.out.println("Deseja usar a recomendação automática? (s/n)");
        String usarRec = sc.nextLine().trim().toLowerCase();
        TipoDeEstrategia escolhidoTipo;
        if (usarRec.equals("s") || usarRec.equals("sim")) {
            escolhidoTipo = recomendacao.recomendacaoPadraoTipo(circuito);
        } else {
            System.out.println("Escolha a estratégia: 1 - Agressiva, 2 - Econômica, 3 - Chuva");
            int opt = sc.nextInt();
            sc.nextLine();
            if (opt == 1) escolhidoTipo = TipoDeEstrategia.AGRESSIVA;
            else if (opt == 2) escolhidoTipo = TipoDeEstrategia.ECONOMIA;
            else escolhidoTipo = TipoDeEstrategia.CHUVA;
        }

        Pneu pneu = recomendacao.definirPneu(circuito, escolhidoTipo);
        int pitLap = recomendacao.definirPitLap(circuito, escolhidoTipo);

        EstrategiaCorrida estrategia;
        if (escolhidoTipo == TipoDeEstrategia.AGRESSIVA) estrategia = new EstrategiaAtaque(pneu, pitLap, circuito);
        else if (escolhidoTipo == TipoDeEstrategia.ECONOMIA) estrategia = new EstrategiaEconomia(pneu, pitLap, circuito);
        else estrategia = new EstrategiaChuva(pneu, pitLap, circuito);

        Piloto piloto = new Piloto();
        piloto.definirEstrategia(estrategia);
        piloto.definirPneu(pneu);

        Telemetria telemetria = new TelemetriaAdapter(new SistemaTelemetriaExterno());

        System.out.println("Equipe: " + equipe.getNome());
        System.out.println(carro.getInfo());
        System.out.println("Estratégia: " + piloto.executarEstrategia());
        System.out.println("Pneu: " + piloto.exibirPneu() + " - " + pneu.getDescricao());
        System.out.println("Telemetria: " + telemetria.lerDados());

        sc.close();
    }
}