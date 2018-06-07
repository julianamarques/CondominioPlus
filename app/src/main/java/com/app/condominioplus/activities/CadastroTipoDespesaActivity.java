package com.app.condominioplus.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.TipoDespesa;
import com.app.condominioplus.utils.CadastroApartamento;
import com.app.condominioplus.utils.CadastroTipoDespesa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class CadastroTipoDespesaActivity extends AppCompatActivity {
    @BindView(R.id.check_despesa_individual) CheckBox checkDespesaIndividual;
    @BindView(R.id.edit_nome_despesa) TextInputEditText editNomeDespesa;

    private Box<TipoDespesa> tipoDespesaBox;
    private TipoDespesa tipoDespesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tipo_despesa);
        ButterKnife.bind(this);

        tipoDespesaBox = ((App)getApplication()).getBoxStore().boxFor(TipoDespesa.class);
        tipoDespesa = new TipoDespesa();
    }

    @OnClick(R.id.btn_salvar_tipo_despesa)
    public void salvarTipoDespesa(View view) {
        String nomeDespesa = editNomeDespesa.getText().toString().trim();
        boolean individual = false;

        if (checkDespesaIndividual.isChecked()) {
            individual = true;
        }

        CadastroTipoDespesa.cadastrarTipoDespesa(tipoDespesaBox, tipoDespesa, nomeDespesa, individual);
        finish();
    }

    @OnClick(R.id.btn_cancelar_despesa)
    public void cancelar(View view) {
        finish();
    }
}
