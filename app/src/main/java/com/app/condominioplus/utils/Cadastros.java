package com.app.condominioplus.utils;

import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Proprietario;
import com.app.condominioplus.models.TipoDespesa;
import com.app.condominioplus.models.TipoOcupacao;

import io.objectbox.Box;

public class Cadastros {

    public static void cadastrarApartamento(Box<Apartamento> apartamentoBox, Apartamento apartamento, int numero, int qtdQuartos, TipoOcupacao tipoOcupacao) {
        apartamento.setNumero(numero);
        apartamento.setQtdQuartos(qtdQuartos);
        apartamento.setTipoOcupacao(tipoOcupacao);

        apartamentoBox.put(apartamento);
    }

    public static void cadastrarProprietarios(Box<Proprietario> proprietarioBox, Proprietario proprietario, String nome, String telefone, long apartamentoId) {
        proprietario.setNome(nome);
        proprietario.setTelefone(telefone);
        proprietario.getApartamento().setTargetId(apartamentoId);

        proprietarioBox.put(proprietario);
    }

    public static void cadastrarTipoDespesa(Box<TipoDespesa> tipoDespesaBox, TipoDespesa tipoDespesa, String nome, boolean individual) {
        tipoDespesa.setNome(nome);
        tipoDespesa.setIndividual(individual);

        tipoDespesaBox.put(tipoDespesa);
    }
}
