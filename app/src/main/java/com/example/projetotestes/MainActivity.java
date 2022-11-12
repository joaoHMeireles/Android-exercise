package com.example.projetotestes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botaoCadastrar;
    private List<Livro> listaLivros;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(v -> irCadastro());

        this.listaLivros = new ArrayList<>();

        setInfoPeca();
        setAdaptador();
    }

    private void irCadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    private void setAdaptador() {
        ListaRecyclerView listaRecyclerView = new ListaRecyclerView(listaLivros, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listaRecyclerView);
    }

    private void setInfoPeca() {
        listaLivros.add(new Livro("Harry Potter", "Maguinho chato numas aventuras contra calvo das trevas", "Tilibras", 2000, 1 ));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Te faz pensar na vida, mas não muito", "Educa", 2013, 2 ));
        listaLivros.add(new Livro("Diário de um banana - 10", "Menino bulinado pela familia, pelos amigos...", "Arqueiro", 2020, 3 ));
    }
}