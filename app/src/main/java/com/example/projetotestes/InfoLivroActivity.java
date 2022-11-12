package com.example.projetotestes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InfoLivroActivity  extends AppCompatActivity {

    private String titulo = getIntent().getStringExtra("titulo");
    private String sinopse = getIntent().getStringExtra("sinopse");
    private String editora = getIntent().getStringExtra("editora");
    private Integer ano = Integer.parseInt(getIntent().getStringExtra("ano"));
    private Integer isbn = Integer.parseInt(getIntent().getStringExtra("isbn"));
    private String foto = getIntent().getStringExtra("foto");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_livro);


    }
}
