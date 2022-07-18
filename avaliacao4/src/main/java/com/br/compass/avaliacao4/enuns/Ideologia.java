package com.br.compass.avaliacao4.enuns;

public enum Ideologia {

    DIREITA("Direita"),
    CENTRO("Centro"),
    ESQUERDA("Esquerda");

    private String value;

    Ideologia(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
