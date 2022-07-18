package com.br.compass.avaliacao4.enuns;

public enum CargoPolitico {

    VEREADOR("Vereador"),
    PREFEITO("Prefeito"),
    DEPUTADO_ESTADUAL("Deputado Estadual"),
    DEPUTADO_FEDERAL("Deputado Federal"),
    SENADOR("Senador"),
    GOVERNADOR("Governador"),
    PRESIDENTE("Presidente"),
    NENHUM("Nenhum");

    private String displayName;

    private CargoPolitico(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return this.displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
