package com.app.condominioplus.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Proprietario {
    @Id private long id;
    private String nome;
    private String telefone;
    private ToOne<Apartamento> apartamento;

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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setApartamento(ToOne<Apartamento> apartamento) {
        this.apartamento = apartamento;
    }

    public ToOne<Apartamento> getApartamento() {
        return apartamento;
    }
}
