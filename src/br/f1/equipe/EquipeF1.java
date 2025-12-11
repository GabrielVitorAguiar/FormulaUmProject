package br.f1.equipe;

public class EquipeF1 {
    private static EquipeF1 instancia;
    private String nome;

    private EquipeF1(String nome) {
        this.nome = nome;
    }

    public static EquipeF1 getInstancia(String nome) {
        if (instancia == null) instancia = new EquipeF1(nome);
        return instancia;
    }

    public String getNome() {
        return nome;
    }
}