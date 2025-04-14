package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioActivity extends AppCompatActivity {

    private TextInputEditText inputNome, inputEmail, inputSenha;
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        inputNome = findViewById(R.id.textInputEditTextNome);
        inputEmail = findViewById(R.id.textInputEditTextEmail);
        inputSenha = findViewById(R.id.textInputEditTextSenha);
        btnLogar = findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(v -> {
            String nome = inputNome.getText().toString().trim();
            String email = inputEmail.getText().toString().trim();
            String senha = inputSenha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(FormularioActivity.this, ConfirmacaoActivity.class);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });
    }
}
