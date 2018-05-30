package com.app.condominioplus.models;

public enum TipoOcupacao {
    VAZIO(0), PROPRIETARIO(1), ALUGADO(2);

    private int codigo;

    TipoOcupacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
