package com.app.condominioplus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Despesa;
import com.app.condominioplus.models.TipoDespesa;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class TiposDeDespesasActivity extends AppCompatActivity {
    @BindView(R.id.txt_tipos_despesa) TextView txtTiposDespesa;
    private Box<TipoDespesa> tipoDespesaBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_de_despesas);
        ButterKnife.bind(this);

        tipoDespesaBox = ((App)getApplication()).getBoxStore().boxFor(TipoDespesa.class);

        listarTiposDeDespesas();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listarTiposDeDespesas();
    }

    public void listarTiposDeDespesas() {
        List<TipoDespesa> tipoDespesas = tipoDespesaBox.getAll();
        String tiposDeDespesas = "";

        for (int i = 0; i < tipoDespesas.size(); i++) {
            tiposDeDespesas += "Nome: " + tipoDespesas.get(i).getNome() + "\n";

            if (tipoDespesas.get(i).getIndividual()) {
                tiposDeDespesas += "Individual: Sim" + "\n\n";
            }

            else {
                tiposDeDespesas += "Individual: Não" + "\n\n";
            }
        }

        if (!tipoDespesas.isEmpty()) {
            txtTiposDespesa.setText(tiposDeDespesas);
        }

        else {
            txtTiposDespesa.setText("");
        }
    }

    @OnClick(R.id.fab_adicionar_tipo_de_despesa)
    public void abrirCadastroTipoDespesa(View view) {
        startActivity(new Intent(this, CadastroTipoDespesaActivity.class));
    }
}
