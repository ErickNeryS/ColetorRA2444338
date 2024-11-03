package com.ra2444338.coletor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        String lastSection = getLatestSection(); 
        String lastQuantity = getLatestQuantity(); 

        TextView txtMostarUltimaSecao = findViewById(R.id.txt_mostarultimasecao);
        TextView txtMostarUltimaQtd = findViewById(R.id.txt_mostarultimaqtd);

        txtMostarUltimaSecao.setText(TextUtils.isEmpty(lastSection) ? "Sem dados" : lastSection);
        txtMostarUltimaQtd.setText(TextUtils.isEmpty(lastQuantity) ? "Sem dados" : lastQuantity);

        String userName = getIntent().getStringExtra("userName");
        TextView nomeFuncionarioTextView = findViewById(R.id.txt_nomefuncionario);
        if (userName != null) {
            nomeFuncionarioTextView.setText("Bem-vindo, " + userName + "!");
        } else {
            nomeFuncionarioTextView.setText("Bem-vindo!");
        }
    }
    public void openNovaContagem(View view) {
            Intent intent = new Intent(Homepage.this, NovaContagemActivity.class);
            startActivity(intent);
        }
    
    private String getLatestSection() {
        String lastSection;
        return "Teste";
    }

    private String getLatestQuantity() {

        return "100";
    }
}

