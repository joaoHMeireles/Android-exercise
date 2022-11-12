package com.example.projetotestes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListaHolder extends RecyclerView.ViewHolder {
    private View itemLivro;
    private TextView delete;
    private TextView titulo;

    public ListaHolder(@NonNull View itemView) {
        super(itemView);
        this.itemLivro = itemView.findViewById(R.id.itemLivro);
        this.delete = itemView.findViewById(R.id.delete);
        this.titulo = itemView.findViewById(R.id.tituloLivro);
    }

    public View getItemLivro() {
        return itemLivro;
    }

    public void setItemLivro(View itemLivro) {
        this.itemLivro = itemLivro;
    }

    public TextView getDelete() {
        return delete;
    }

    public void setDelete(TextView delete) {
        this.delete = delete;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public void setTitulo(TextView titulo) {
        this.titulo = titulo;
    }
}
