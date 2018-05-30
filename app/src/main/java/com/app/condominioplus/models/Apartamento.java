package com.app.condominioplus.models;

import com.app.condominioplus.utils.TipoOcupacaoConverter;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class Apartamento {
    @Id private long id;
    private int numero;
    private int qtdQuartos;
    @Convert(converter = TipoOcupacaoConverter.class, dbType = Integer.class)
    private TipoOcupacao tipoOcupacao;
    private ToOne<Proprietario> proprietario;
    @Backlink private ToMany<TaxaCondominio> taxaCondominios;

    public Apartamento() {}

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public int getQtdQuartos() {
        return qtdQuartos;
    }

    public void setTipoOcupacao(TipoOcupacao tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public TipoOcupacao getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setProprietario(ToOne<Proprietario> proprietario) {
        this.proprietario = proprietario;
    }

    public ToOne<Proprietario> getProprietario() {
        return proprietario;
    }

    public void setTaxaCondominios(ToMany<TaxaCondominio> taxaCondominios) {
        this.taxaCondominios = taxaCondominios;
    }

    public ToMany<TaxaCondominio> getTaxaCondominios() {
        return taxaCondominios;
    }
}
