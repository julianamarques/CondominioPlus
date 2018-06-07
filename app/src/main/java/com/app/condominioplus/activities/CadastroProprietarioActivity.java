package com.app.condominioplus.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Proprietario;
import com.app.condominioplus.utils.CadastroApartamento;
import com.app.condominioplus.utils.CadastroProprietario;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class CadastroProprietarioActivity extends AppCompatActivity {
    @BindView(R.id.edit_nome) TextInputEditText editNome;
    @BindView(R.id.edit_telefone) TextInputEditText editTelefone;

    private Box<Proprietario> proprietarioBox;
    private Proprietario proprietario;
    private long apartamentoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_proprietario);
        ButterKnife.bind(this);

        proprietarioBox = ((App)getApplication()).getBoxStore().boxFor(Proprietario.class);
        apartamentoId = getIntent().getLongExtra("apartamentoId", -1);

        proprietario = new Proprietario();
    }

    @OnClick(R.id.btn_salvar_proprietario)
    public void salvarProprietario(View view) {
        String nome = editNome.getText().toString().trim();
        String telefone = editTelefone.getText().toString().trim();

        CadastroProprietario.cadastrarProprietarios(proprietarioBox, proprietario, nome, telefone, apartamentoId);
        finish();
    }

    @OnClick(R.id.btn_cancelar_proprietario)
    public void cancelar(View view) {
        finish();
    }
}
