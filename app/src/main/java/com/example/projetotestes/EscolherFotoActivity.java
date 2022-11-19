package com.example.projetotestes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EscolherFotoActivity extends AppCompatActivity {

    private ImageView imagemEscolhida, imagem1, imagem2, imagem3, imagem4, imagem5, imagem6;
    private Button voltarButton, escolherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_foto);

        voltarButton = findViewById(R.id.botaoVoltar);
        escolherButton = findViewById(R.id.botaoEscolher);

        imagem1 = findViewById(R.id.imagem1);
        imagem2 = findViewById(R.id.imagem2);
        imagem3 = findViewById(R.id.imagem3);
        imagem4 = findViewById(R.id.imagem4);
        imagem5 = findViewById(R.id.imagem5);
        imagem6 = findViewById(R.id.imagem6);
        imagemEscolhida = findViewById(R.id.imagemEscolhida);
        imagemEscolhida.setImageResource(R.drawable.imagem1);

        imagem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem1);
                imagemEscolhida.setTag(R.drawable.imagem1);
            }
        });

        imagem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem2);
                imagemEscolhida.setTag(R.drawable.imagem2);
            }
        });

        imagem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem3);
                imagemEscolhida.setTag(R.drawable.imagem3);
            }
        });

        imagem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem4);
                imagemEscolhida.setTag(R.drawable.imagem4);
            }
        });

        imagem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem5);
                imagemEscolhida.setTag(R.drawable.imagem5);
            }
        });

        imagem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemEscolhida.setImageResource(R.drawable.imagem6);
                imagemEscolhida.setTag(R.drawable.imagem6);
            }
        });

        escolherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                Bundle bundle = new Bundle();

                bundle.putInt("idFoto", (int) imagemEscolhida.getTag());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

}
