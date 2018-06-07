package com.app.condominioplus.utils;

import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Proprietario;
import com.app.condominioplus.models.TipoDespesa;
import com.app.condominioplus.models.TipoOcupacao;

import io.objectbox.Box;

public class CadastroApartamento {

    public static void cadastrarApartamento(Box<Apartamento> apartamentoBox, Apartamento apartamento, int numero, int qtdQuartos, TipoOcupacao tipoOcupacao) {
        apartamento.setNumero(numero);
        apartamento.setQtdQuartos(qtdQuartos);
        apartamento.setTipoOcupacao(tipoOcupacao);

        apartamentoBox.put(apartamento);
    }
}
