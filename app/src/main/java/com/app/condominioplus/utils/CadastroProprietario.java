package com.app.condominioplus.utils;

import com.app.condominioplus.models.Proprietario;

import io.objectbox.Box;

public class CadastroProprietario {

    public static void cadastrarProprietarios(Box<Proprietario> proprietarioBox, Proprietario proprietario, String nome, String telefone, long apartamentoId) {
        proprietario.setNome(nome);
        proprietario.setTelefone(telefone);
        proprietario.getApartamento().setTargetId(apartamentoId);

        proprietarioBox.put(proprietario);
    }
}
