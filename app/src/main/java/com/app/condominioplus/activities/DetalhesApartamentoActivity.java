package com.app.condominioplus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.app.condominioplus.R;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Proprietario;
import com.app.condominioplus.models.Proprietario_;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;

public class DetalhesApartamentoActivity extends AppCompatActivity {
    @BindView(R.id.txt_detalhes_apartamento) TextView txtDetalhesApartamento;

    private Box<Proprietario> proprietarioBox;
    private long apartamentoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_apartamento);
        ButterKnife.bind(this);

        proprietarioBox = ((App)getApplication()).getBoxStore().boxFor(Proprietario.class);
        apartamentoId = getIntent().getLongExtra("apartamentoId", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listarDetalhes();
    }

    public void listarDetalhes() {
        List<Proprietario> proprietarios = proprietarioBox.query().equal(Proprietario_.apartamentoId, apartamentoId).build().find();
        String detalhes = "";

        for(int i = 0; i < proprietarios.size(); i++) {
            detalhes += "Nome: " + proprietarios.get(i).getNome() + "\n" +
                    "Telefone: " + proprietarios.get(i).getTelefone() + "\n\n";
        }

        if(!proprietarios.isEmpty()) {
            txtDetalhesApartamento.setText(detalhes);
            getSupportActionBar().setTitle("APTO Nº" + proprietarios.get(0).getApartamento().getTarget().getNumero());
        }

        else {
            txtDetalhesApartamento.setText("Sem proprietários");
        }
    }
}
