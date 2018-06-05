package com.app.condominioplus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.condominioplus.R;
import com.app.condominioplus.adapters.ApartamentosAdapter;
import com.app.condominioplus.dao.App;
import com.app.condominioplus.models.Apartamento;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.objectbox.Box;

public class ApartamentosActivity extends AppCompatActivity {
    @BindView(R.id.rv_apartamentos) RecyclerView recyclerApartamentos;

    private Box<Apartamento> apartamentoBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartamentos);
        ButterKnife.bind(this);

        apartamentoBox = ((App)getApplication()).getBoxStore().boxFor(Apartamento.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Apartamento> apartamentos = apartamentoBox.getAll();
        recyclerApartamentos.setLayoutManager(new LinearLayoutManager(this));
        ApartamentosAdapter adapter = new ApartamentosAdapter(this, apartamentos, apartamentoBox);
        recyclerApartamentos.setAdapter(adapter);
    }

    @OnClick(R.id.fab_adicionar_apartamento)
    public void abrirCadastroApartamento(View view) {
        startActivity(new Intent(this, CadastroApartamentoActivity.class));
    }
}
