package br.f1.estrategia;

public class EstrategiaChuva implements EstrategiaCorrida {
    private final Pneu pneu;
    private final int pitLap;
    private final String circuito;

    public EstrategiaChuva(Pneu pneu, int pitLap, String circuito) {
        this.pneu = pneu;
        this.pitLap = pitLap;
        this.circuito = circuito;
    }

    public String executar() {
        return "Estratégia para chuva ativada | Pneu: " + pneu + " | Sugestão: trocar aprox. após " + pitLap + " voltas em " + circuito;
    }
}