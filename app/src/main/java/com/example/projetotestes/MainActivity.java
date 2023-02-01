package com.example.projetotestes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private Button botaoCadastrar;
    public static List<Livro> listaLivros = new ArrayList<>();
    private RecyclerView recyclerView;

    static {
        listaLivros.add(new Livro("Harry Potter", "Maguinho chato numas aventuras contra calvo das trevas", "Tilibras", R.drawable.imagem1, 2000, 1 ));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Te faz pensar na vida, mas não muito", "Educa",R.drawable.imagem4 ,2013, 2 ));
        listaLivros.add(new Livro("Diário de um banana 10", "Menino bulinado pela familia, pelos amigos...", "Arqueiro", R.drawable.imagem5, 2020, 3 ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(v -> irCadastro());

        setAdaptador();
    }

    private void irCadastro() {
        Intent intent = new Intent(this, CadastroActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("idFoto", -1);
        intent.putExtras(bundle);

        startActivityForResult(intent, 1);
    }

    private void setAdaptador() {
        System.out.println(listaLivros);

        ListaRecyclerView listaRecyclerView = new ListaRecyclerView(listaLivros, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listaRecyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        this.recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onClickItem(int position){
        listaLivros.remove(position);

        this.recyclerView.getAdapter().notifyItemRemoved(position);
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