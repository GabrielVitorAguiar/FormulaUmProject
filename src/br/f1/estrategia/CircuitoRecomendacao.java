package br.f1.estrategia;

public class CircuitoRecomendacao {

    public String recomendacaoResumo(String circuito) {
        TipoDeEstrategia tipo = recomendacaoPadraoTipo(circuito);
        Pneu p = definirPneu(circuito, tipo);
        int laps = definirPitLap(circuito, tipo);
        return "Tipo recomendado: " + tipo + " | Pneu sugerido: " + p + " | " + p.getDescricao()
                + " | Parada aprox.: " + laps + " voltas";
    }

    public TipoDeEstrategia recomendacaoPadraoTipo(String circuito) {
        switch (circuito.toLowerCase()) {
            case "monaco": return TipoDeEstrategia.AGRESSIVA;
            case "silverstone": return TipoDeEstrategia.ECONOMIA;
            case "spa": return TipoDeEstrategia.ECONOMIA;
            case "suzuka": return TipoDeEstrategia.ECONOMIA;
            case "interlagos": return TipoDeEstrategia.AGRESSIVA;
            case "mexico": return TipoDeEstrategia.AGRESSIVA;
            case "cota": return TipoDeEstrategia.AGRESSIVA;
            case "zandvoort": return TipoDeEstrategia.ECONOMIA;
            case "hungaroring": return TipoDeEstrategia.ECONOMIA;
            case "bahrain": return TipoDeEstrategia.AGRESSIVA;
            case "jeddah": return TipoDeEstrategia.AGRESSIVA;
            case "miami": return TipoDeEstrategia.AGRESSIVA;
            case "lasvegas": return TipoDeEstrategia.AGRESSIVA;
            default: return TipoDeEstrategia.AGRESSIVA;
        }
    }

    public Pneu definirPneu(String circuito, TipoDeEstrategia tipo) {
        String c = circuito.toLowerCase();

        if (tipo == TipoDeEstrategia.AGRESSIVA) {
            switch (c) {
                case "monaco":
                case "miami":
                case "lasvegas":
                    return Pneu.C5;
                case "silverstone":
                    return Pneu.C4;
                case "spa":
                    return Pneu.C3;
                case "suzuka":
                    return Pneu.C4;
                case "interlagos":
                    return Pneu.C4;
                case "mexico":
                    return Pneu.C3;
                case "cota":
                    return Pneu.C4;
                case "zandvoort":
                    return Pneu.C2;
                case "hungaroring":
                    return Pneu.C4;
                case "bahrain":
                    return Pneu.C1;
                case "jeddah":
                    return Pneu.C4;
                default:
                    return Pneu.C5;
            }

        } else if (tipo == TipoDeEstrategia.ECONOMIA) {
            switch (c) {
                case "monaco":
                    return Pneu.C3;
                case "silverstone":
                case "spa":
                case "zandvoort":
                    return Pneu.C2;
                case "suzuka":
                case "mexico":
                    return Pneu.C3;
                case "interlagos":
                    return Pneu.C3;
                case "cota":
                    return Pneu.C3;
                case "hungaroring":
                    return Pneu.C3;
                case "bahrain":
                    return Pneu.C2;
                case "jeddah":
                    return Pneu.C3;
                case "miami":
                case "lasvegas":
                    return Pneu.C3;
                default:
                    return Pneu.C3;
            }

        } else if (tipo == TipoDeEstrategia.CHUVA) {
            switch (c) {
                case "monaco":
                case "miami":
                case "lasvegas":
                case "interlagos":
                case "cota":
                    return Pneu.CinturatoGreen;

                case "spa":
                case "suzuka":
                case "silverstone":
                case "zandvoort":
                case "hungaroring":
                case "bahrain":
                case "jeddah":
                case "mexico":
                    return Pneu.CinturatoBlue;

                default:
                    return Pneu.CinturatoGreen;
            }
        }

        return Pneu.C3;
    }

    public int definirPitLap(String circuito, TipoDeEstrategia tipo) {
        if (tipo == TipoDeEstrategia.AGRESSIVA) {
            switch (circuito.toLowerCase()) {
                case "monaco": case "miami": case "lasvegas": return 18;
                case "silverstone": case "suzuka": case "interlagos": case "cota": return 25;
                case "spa": case "mexico": return 30;
                case "zandvoort": case "hungaroring": return 35;
                case "bahrain": return 40;
                case "jeddah": return 25;
                default: return 20;
            }

        } else if (tipo == TipoDeEstrategia.ECONOMIA) {
            switch (circuito.toLowerCase()) {
                case "silverstone": case "spa": case "zandvoort": return 35;
                case "bahrain": return 35;
                default: return 30;
            }

        } else {
            return 22;
        }
    }
}