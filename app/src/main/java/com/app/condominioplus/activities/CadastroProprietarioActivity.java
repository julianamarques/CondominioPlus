package com.app.condominioplus.activities;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Proprietario;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class CadastroProprietarioActivity extends AppCompatActivity {
    @BindView(R.id.edit_nome) TextInputEditText editNome;
    @BindView(R.id.edit_telefone) TextInputEditText editTelefone;

    private Box<Proprietario> proprietarioBox;
    private Box<Apartamento> apartamentoBox;
    private Proprietario proprietario;
    private long proprietarioId;
    private long apartamentoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_proprietario);
        ButterKnife.bind(this);

        proprietarioBox = ((App)getApplication()).getBoxStore().boxFor(Proprietario.class);
        proprietarioId = getIntent().getLongExtra("proprietarioId", -1);
        apartamentoId = getIntent().getLongExtra("apartamentoId", -1);

        proprietario = new Proprietario();

        Toast.makeText(this, "ID AP: " + apartamentoId, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_salvar_proprietario)
    public void salvarProprietario(View view) {
        String nome = editNome.getText().toString().trim();
        String telefone = editTelefone.getText().toString().trim();

        try {
            proprietario.setNome(nome);
            proprietario.setTelefone(telefone);
            proprietario.getApartamento().setTargetId(apartamentoId);
            proprietarioBox.put(proprietario);
            finish();
        }

        catch (NumberFormatException e) {
            Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
        }
    }

    @OnClick(R.id.btn_cancelar)
    public void cancelar(View view) {
        finish();
    }
}
