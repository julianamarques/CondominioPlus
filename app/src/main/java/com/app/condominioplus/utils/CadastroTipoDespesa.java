package com.app.condominioplus.utils;

import com.app.condominioplus.models.TipoDespesa;

import io.objectbox.Box;

public class CadastroTipoDespesa {

    public static void cadastrarTipoDespesa(Box<TipoDespesa> tipoDespesaBox, TipoDespesa tipoDespesa, String nome, boolean individual) {
        tipoDespesa.setNome(nome);
        tipoDespesa.setIndividual(individual);

        tipoDespesaBox.put(tipoDespesa);
    }
}
