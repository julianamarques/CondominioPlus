package com.app.condominioplus.activities;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Proprietario;
import com.app.condominioplus.models.TipoOcupacao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class CadastroApartamentoActivity extends AppCompatActivity {
    @BindView(R.id.edit_numero) TextInputEditText editNumero;
    @BindView(R.id.edit_qtd_quartos) TextInputEditText editQtdQuartos;
    @BindView(R.id.radio_group) RadioGroup radioGroup;

    private Box<Apartamento> apartamentoBox;
    private Apartamento apartamento;
    private long apartamentoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_apartamento);
        ButterKnife.bind(this);

        apartamentoBox = ((App)getApplication()).getBoxStore().boxFor(Apartamento.class);
        apartamentoId = getIntent().getLongExtra("apartamentoId", -1);

        apartamento = new Apartamento();
    }

    public TipoOcupacao getTipoOcupacao() {
        int idRadioGroup = radioGroup.getCheckedRadioButtonId();
        TipoOcupacao tipoOcupacao = TipoOcupacao.VAZIO;

        if(idRadioGroup == R.id.vazio) {
            tipoOcupacao = TipoOcupacao.VAZIO;
        }

        else if(idRadioGroup == R.id.proprietario) {
            tipoOcupacao = TipoOcupacao.PROPRIETARIO;
        }

        else if(idRadioGroup == R.id.alugado) {
            tipoOcupacao = TipoOcupacao.ALUGADO;
        }

        return tipoOcupacao;
    }

    @OnClick(R.id.btn_salvar_apartamento)
    public void salvarApartamento(View view) {
        String numero = editNumero.getText().toString().trim();
        String qtdQuartos = editQtdQuartos.getText().toString().trim();

        try {
            apartamento.setNumero(Integer.valueOf(numero));
            apartamento.setQtdQuartos(Integer.valueOf(qtdQuartos));
            apartamento.setTipoOcupacao(getTipoOcupacao());

            apartamentoBox.put(apartamento);
            finish();
        }

        catch (NumberFormatException e) {
            Snackbar.make(view, "Preencha os campos!", Snackbar.LENGTH_SHORT);
        }
    }
}
