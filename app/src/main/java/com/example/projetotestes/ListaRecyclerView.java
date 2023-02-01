package com.example.projetotestes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListaRecyclerView extends RecyclerView.Adapter {

    private List<Livro> itens;
    private Context context;
    private RecyclerViewInterface recyclerViewInterface;

    ListaRecyclerView(List<Livro> itens, Context context, RecyclerViewInterface recyclerViewInterface){
        this.itens = itens;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_livro, parent, false);
        return new ListaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListaHolder listaHolder = (ListaHolder) holder;
        Livro item = this.itens.get(position);

        listaHolder.getTitulo().setText(item.getTitulo());
        listaHolder.getFoto().setImageResource(item.getFoto());

        listaHolder.getItemLivro().setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoLivroActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("titulo", item.getTitulo());
            bundle.putString("sinopse", item.getSinopse());
            bundle.putString("editora", item.getEditora());
            bundle.putInt("ano", item.getAno());
            bundle.putInt("isbn", item.getIsbn());
            bundle.putInt("foto", item.getFoto());

            intent.putExtras(bundle);

            context.startActivity(intent);
        });

        listaHolder.getDelete().setOnClickListener(v -> {
            if(recyclerViewInterface != null ){
                int newPosition = holder.getAdapterPosition();

                if(newPosition != RecyclerView.NO_POSITION){
                    recyclerViewInterface.onClickItem(newPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itens.size();
    }
}
