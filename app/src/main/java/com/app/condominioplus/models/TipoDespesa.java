package com.app.condominioplus.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class TipoDespesa {
    @Id private long id;
    private String nome;
    private boolean individual;

    public TipoDespesa() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public boolean getIndividual() {
        return individual;
    }
}
