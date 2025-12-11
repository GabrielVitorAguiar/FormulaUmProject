package br.f1.telemetria;

public class TelemetriaAdapter implements Telemetria {
    private SistemaTelemetriaExterno externo;

    public TelemetriaAdapter(SistemaTelemetriaExterno externo) {
        this.externo = externo;
    }

    public String lerDados() {
        return externo.getData();
    }
}