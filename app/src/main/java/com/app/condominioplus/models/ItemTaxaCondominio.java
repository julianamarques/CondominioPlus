package com.app.condominioplus.models;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class ItemTaxaCondominio {
    @Id private long id;
    private String referencia;
    private double valor;
    private ToOne<TaxaCondominio> taxaCondominio;
    @Backlink private ToMany<Despesa> despesas;

    public ItemTaxaCondominio() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setTaxaCondominio(ToOne<TaxaCondominio> taxaCondominio) {
        this.taxaCondominio = taxaCondominio;
    }

    public ToOne<TaxaCondominio> getTaxaCondominio() {
        return taxaCondominio;
    }

    public void setDespesas(ToMany<Despesa> despesas) {
        this.despesas = despesas;
    }

    public ToMany<Despesa> getDespesas() {
        return despesas;
    }
}
