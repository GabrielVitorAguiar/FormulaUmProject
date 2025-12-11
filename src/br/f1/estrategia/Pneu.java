package br.f1.estrategia;

public enum Pneu {
    C1("C1 (Branco Duro): Mais duro, maior durabilidade, menor aderência."),
    C2("C2 (Amarelo Médio): Equilíbrio entre durabilidade e aderência."),
    C3("C3 (Vermelho Macio): Versátil, bom aquecimento e aderência."),
    C4("C4 (Macio): Aquecimento rápido, aderência superior."),
    C5("C5 (Mais Macio): Maciez máxima para velocidade."),
    C6("C6 (Ultramacio): Novo composto para circuitos de rua, máxima aderência e menor durabilidade."),
    CinturatoGreen("Usados em pistas levemente molhadas, com sulcos para drenar a água."),
    CinturatoBlue("Para pistas encharcadas, com sulcos mais profundos para máxima drenagem.");

    private final String descricao;

    Pneu(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}