package com.app.condominioplus.utils;

import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.ItemTaxaCondominio;

import java.util.List;

public class Calculos {
    private Integer qtdTotalQuartos;

    public Calculos(List<Apartamento> apartamentos) {
        setQtdTotalQuartos(apartamentos);
    }

    private Integer obterTotalQuartos(List<Apartamento> apartamentos){
        Integer totalQuartos = 0;
        for (int i = 0;i<apartamentos.size();i++){
            totalQuartos += apartamentos.get(i).getQtdQuartos();
        }

        return totalQuartos;
    }

    public Double obterDespesaItemCondominio(Apartamento apartamento, Boolean individual, Double valor){
        Double valorFinal = valor;
        if(!individual){
            valorFinal = (valor/qtdTotalQuartos) * apartamento.getQtdQuartos();
        }

        return valorFinal;
    }


    public Integer getQtdTotalQuartos(){
        return qtdTotalQuartos;
    }

    public void setQtdTotalQuartos(List<Apartamento> apartamentos) {
        this.qtdTotalQuartos = obterTotalQuartos(apartamentos);
    }

    public Double valorContaCondominio(List<ItemTaxaCondominio> itemTaxaCondominios){
        Double soma = 0.0;

        for (int i =0; i<itemTaxaCondominios.size();i++){
            soma+= itemTaxaCondominios.get(i).getValor();
        }

        return soma;
    }



}
