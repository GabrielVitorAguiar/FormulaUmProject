package br.f1.carro;

public class CarroF1 {
    private String motor;
    private int numero;
    private String piloto;

    private CarroF1(Builder builder) {
        this.motor = builder.motor;
        this.numero = builder.numero;
        this.piloto = builder.piloto;
    }

    public static class Builder {
        private String motor;
        private int numero;
        private String piloto;

        public Builder motor(String motor) {
            this.motor = motor;
            return this;
        }

        public Builder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public Builder piloto(String piloto) {
            this.piloto = piloto;
            return this;
        }

        public CarroF1 build() {
            return new CarroF1(this);
        }
    }

    public String getInfo() {
        return "Carro Nº " + numero + " | Motor: " + motor + " | Piloto: " + piloto;
    }
}