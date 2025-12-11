package br.f1.estrategia;

public class Piloto {
    private EstrategiaCorrida estrategia;
    private Pneu pneu;

    public void definirEstrategia(EstrategiaCorrida estrategia) {
        this.estrategia = estrategia;
    }

    public void definirPneu(Pneu pneu) {
        this.pneu = pneu;
    }

    public String executarEstrategia() {
        return estrategia.executar();
    }

    public String exibirPneu() {
        return pneu.toString();
    }
}