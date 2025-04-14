package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    private TextView textDescricao;
    private Button btnVoltar, btnCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        textDescricao = findViewById(R.id.textDescricao);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnCompras = findViewById(R.id.btnCompras);

        String nome = getIntent().getStringExtra("nome");
        if (nome == null) nome = "usuário";

        String mensagem = "Olá " + nome + ", Seus dados foram salvos e agora é só clicar no botão Ir para as compras para ser feliz! Caso queria entrar em outra conta clique em Voltar";
        textDescricao.setText(mensagem);

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmacaoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnCompras.setOnClickListener(v -> {
            // sem ação
        });
    }
}