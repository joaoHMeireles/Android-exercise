package com.example.projetotestes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText tituloInput, sinopseInput, editoraInput, anoInput;
    private Button cadastrarButton, verFotoButton;
    private TextView voltar;
    private static String tituloValue = "", sinopseValue = "", editoraValue = "";
    private static Integer anoValue = 0, fotoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Bundle bundle = getIntent().getExtras();
        fotoId = bundle.getInt("idFoto");

        tituloInput = findViewById(R.id.inputTitulo);
        sinopseInput = findViewById(R.id.inputSinopse);
        editoraInput = findViewById(R.id.inputEditora);
        anoInput = findViewById(R.id.inputAno);
        cadastrarButton = findViewById(R.id.cadastrarButton);
        verFotoButton = findViewById(R.id.escolherFotoButton);
        voltar = findViewById(R.id.voltarView);

        setarInputs();

        verFotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reSetarInputs();
                Intent intent = new Intent(getApplicationContext(), EscolherFotoActivity.class);
                startActivity(intent);
            }
        });

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro(
                        tituloInput.getText().toString(),
                        sinopseInput.getText().toString(),
                        editoraInput.getText().toString(),
                        fotoId,
                        Integer.parseInt(anoInput.getText().toString()),
                        MainActivity.proximoIsbn()
                );

                System.out.println(livro);

                MainActivity.listaLivros.add(livro);

                voltarMain();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarMain();
            }
        });
    }

    private void setarInputs() {
        String ano = anoValue + "";
        tituloInput.setText(tituloValue);
        sinopseInput.setText(sinopseValue);
        editoraInput.setText(editoraValue);
        anoInput.setText(ano);
    }

    private void reSetarInputs() {
        anoValue = Integer.parseInt(anoInput.getText().toString());
        tituloValue = tituloInput.getText().toString();
        sinopseValue = sinopseInput.getText().toString();
        editoraValue = editoraInput.getText().toString();

    }

    public void voltarMain(){
        tituloValue = "";
        sinopseValue = "";
        editoraValue = "";
        anoValue = 0;
        fotoId = -1;
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
