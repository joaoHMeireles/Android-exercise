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
    private static List<Livro> listaLivros;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(v -> irCadastro());
        listaLivros = new ArrayList<>();

        setInfoPeca();
        setAdaptador();
    }

    private void irCadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("idFoto", -1);
        intent.putExtras(bundle);

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
        listaLivros.add(new Livro("Harry Potter", "Maguinho chato numas aventuras contra calvo das trevas", "Tilibras", R.drawable.imagem1, 2000, 1 ));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Te faz pensar na vida, mas não muito", "Educa",R.drawable.imagem4 ,2013, 2 ));
        listaLivros.add(new Livro("Diário de um banana - 10", "Menino bulinado pela familia, pelos amigos...", "Arqueiro", R.drawable.imagem5, 2020, 3 ));
    }

    public static void addLista(Livro livro){
        listaLivros.add(livro);
    }

    public static void deleteFromLista(Integer index){
        listaLivros.remove(index);
    }

    public static Integer proximoIsbn(){
        Integer proximoIsbn = 0;
        for(int i = 0; i < listaLivros.size(); i++){
            if(listaLivros.get(i).getIsbn() > proximoIsbn){
                proximoIsbn = listaLivros.get(i).getIsbn();
            }
        }
        return proximoIsbn + 1;
    }
}