package com.ra2444338.coletor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        auth = FirebaseAuth.getInstance();

    
        EditText emailEditText = findViewById(R.id.Plaintxt_usuario);
        EditText passwordEditText = findViewById(R.id.editTextNumberPassword);
        Button loginButton = findViewById(R.id.button_login);


        ((View) loginButton).setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                loginUser(email, password);
            } else {
                Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Login com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Homepage.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(MainActivity.this, "Erro: Usuário ou senha inexistente" , Toast.LENGTH_SHORT).show();
                    }
                });
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Login com sucesso!", Toast.LENGTH_SHORT).show();
                        String userName = "Nome do Funcionario";
                        Intent intent = new Intent(MainActivity.this, Homepage.class);
                        intent.putExtra("userName", userName);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(MainActivity.this, "Erro: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
