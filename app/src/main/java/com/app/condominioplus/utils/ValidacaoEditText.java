package com.app.condominioplus.utils;

import android.widget.EditText;

public class ValidacaoEditText {

    public static void validarEditText(EditText editText) throws NumberFormatException {
        if(editText.getText().toString().trim().length() == 0) {
            throw new NumberFormatException("O campo não pode estar vazio!");
        }
    }
}
