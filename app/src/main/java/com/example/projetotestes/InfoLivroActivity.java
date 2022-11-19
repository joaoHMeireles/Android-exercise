package com.example.projetotestes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoLivroActivity extends AppCompatActivity {

    private TextView titulo, sinopse, editora, ano, isbn;
    private ImageView foto;
    private Button voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_livro);

        Bundle bundle = getIntent().getExtras();
        String tituloInfo = bundle.getString("titulo");
        String sinopseInfo = bundle.getString("sinopse");
        String editoraInfo = bundle.getString("editora");
        Integer anoInfo = bundle.getInt("ano");
        Integer isbnInfo = bundle.getInt("isbn");
        Integer fotoInfo = bundle.getInt("foto");

        titulo = findViewById(R.id.tituloLivroInfo);
        sinopse = findViewById(R.id.sinopseText);
        editora = findViewById(R.id.editoraText);
        ano = findViewById(R.id.anoText);
        isbn = findViewById(R.id.isbnText);
        foto = findViewById(R.id.foto);

        titulo.setText(tituloInfo);
        sinopse.setText(sinopseInfo);
        editora.setText(editoraInfo);
        ano.setText(anoInfo + "");
        isbn.setText(isbnInfo + "");
        foto.setImageResource(fotoInfo);
        voltarButton = findViewById(R.id.voltarButton);

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
