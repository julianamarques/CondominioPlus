package com.app.condominioplus.models;

import java.util.Date;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class TaxaCondominio {
    @Id private long id;
    private String mesAno;
    private Date data;
    private double valorPago;
    private double valorAPagar;
    private ToOne<Apartamento> apartamento;
    @Backlink private ToMany<ItemTaxaCondominio> itemTaxaCondominios;

    public TaxaCondominio() {}

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

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setApartamento(ToOne<Apartamento> apartamento) {
        this.apartamento = apartamento;
    }

    public ToOne<Apartamento> getApartamento() {
        return apartamento;
    }

    public void setItemTaxaCondominios(ToMany<ItemTaxaCondominio> itemTaxaCondominios) {
        this.itemTaxaCondominios = itemTaxaCondominios;
    }

    public ToMany<ItemTaxaCondominio> getItemTaxaCondominios() {
        return itemTaxaCondominios;
    }
}
