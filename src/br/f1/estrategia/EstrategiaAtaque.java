package br.f1.estrategia;

public class EstrategiaAtaque implements EstrategiaCorrida {
    private final Pneu pneu;
    private final int pitLap;
    private final String circuito;

    public EstrategiaAtaque(Pneu pneu, int pitLap, String circuito) {
        this.pneu = pneu;
        this.pitLap = pitLap;
        this.circuito = circuito;
    }

    public String executar() {
        return "Estratégia agressiva ativada | Pneu: " + pneu + " | Sugestão: trocar aprox. após " + pitLap + " voltas em " + circuito;
    }
}