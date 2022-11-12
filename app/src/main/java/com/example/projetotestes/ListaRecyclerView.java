package com.example.projetotestes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListaRecyclerView extends RecyclerView.Adapter{

    private List<Livro> itens;
    private Context context;

    ListaRecyclerView(List<Livro> itens, Context context){
        this.itens = itens;
        this.context = context;
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

        listaHolder.getItemLivro().setOnClickListener(v -> {
            Intent intent = new Intent(context, InfoLivroActivity.class);
            intent.putExtra("titulo", item.getTitulo());
            intent.putExtra("sinopse", item.getSinopse());
            intent.putExtra("editora", item.getEditora());
            intent.putExtra("ano", item.getAno());
            intent.putExtra("isbn", item.getIsbn());
            intent.putExtra("foto", item.getFoto());
            context.startActivity(intent);
        });

        listaHolder.getDelete().setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return this.itens.size();
    }
}
