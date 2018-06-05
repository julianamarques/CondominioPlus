package com.app.condominioplus.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Despesa {
    @Id private long id;
    private String mesAno;
    private double valor;
    private ToOne<ItemTaxaCondominio> itemTaxaCondominio;
    private ToOne<TipoDespesa> tipoDespesa;

    public Despesa() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setMesAno(String mesAno) {
        this.mesAno = mesAno;
    }

    public String getMesAno() {
        return mesAno;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setItemTaxaCondominio(ToOne<ItemTaxaCondominio> itemTaxaCondominio) {
        this.itemTaxaCondominio = itemTaxaCondominio;
    }

    public ToOne<ItemTaxaCondominio> getItemTaxaCondominio() {
        return itemTaxaCondominio;
    }

    public void setTipoDespesa(ToOne<TipoDespesa> tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public ToOne<TipoDespesa> getTipoDespesa() {
        return tipoDespesa;
    }
}
