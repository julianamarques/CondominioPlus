package com.app.condominioplus.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.condominioplus.R;
import com.app.condominioplus.activities.CadastroProprietarioActivity;
import com.app.condominioplus.models.Apartamento;
import com.app.condominioplus.models.Proprietario;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.objectbox.Box;

public class ApartamentosAdapter extends RecyclerView.Adapter<ApartamentosAdapter.ViewHolder> {
    private Context context;
    private Apartamento apartamento;
    private List<Apartamento> apartamentos;
    private Box<Apartamento> apartamentoBox;
    private Proprietario proprietario;
    private Box<Proprietario> proprietarioBox;

    public ApartamentosAdapter(Context context, List<Apartamento> apartamentos, Box<Apartamento> apartamentoBox) {
        this.context = context;
        this.apartamentos = apartamentos;
        this.apartamentoBox = apartamentoBox;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_apartamento, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Apartamento apartamento = this.apartamentos.get(position);

        holder.txtNumero.setText("Nº " + apartamento.getNumero());
        holder.txtQtdQuartos.setText(apartamento.getQtdQuartos() + " quartos");
        //holder.txtOcupacao.setText("Ocupação: " + apartamento.getOcupacao());

        configurarClickLongo(holder.itemView, apartamento, position);
        //configurarClickCurto(holder.itemView, apartamento, position);
    }

    @Override
    public int getItemCount() {
        return this.apartamentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_numero)
        TextView txtNumero;
        @BindView(R.id.txt_qtd_quartos) TextView txtQtdQuartos;
        @BindView(R.id.txt_ocupacao) TextView txtOcupacao;
        @BindView(R.id.txt_proprietario) TextView txtProprietario;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void configurarClickLongo(final View itemView, final Apartamento apartamento, final int position) {
        itemView.setOnLongClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu_apartamento, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if(item.getItemId() == R.id.adicionar_proprietario) {
                    adicionarProprietario(itemView, apartamento, position);
                }

                /*else if(item.getItemId() == R.id.remover_apartamento) {
                    removerApartamento(itemView, apartamento, position);
                }*/

                return false;
            });

            popupMenu.show();

            return true;
        });
    }

    public void adicionarProprietario(View view, Apartamento apartamento, int position) {
        Intent intent = new Intent(context, CadastroProprietarioActivity.class);
        intent.putExtra("apartamentoId", apartamento.getId());
        context.startActivity(intent);
        notifyItemChanged(position);
    }

    public void removerApartamento(View view, Apartamento apartamento, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Condominio App");
        builder.setMessage("Deseja remover o apartamento da lista?");

        builder.setPositiveButton("SIM", (dialog, which) -> {
            this.apartamentos.remove(apartamento);
            this.apartamentoBox.remove(apartamento);

            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
            Snackbar.make(view, "Apartamento removido!", Snackbar.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("NÃO", null);
        builder.create().show();
    }

    /*public void configurarClickCurto(final View itemView, final Apartamento apartamento, final int position) {
        itemView.setOnClickListener(view -> {
            context.startActivity(new Intent(context, ProprietarioActivity.class).putExtra("apartamentoId", apartamento.getId()));
        });
    }*/
}