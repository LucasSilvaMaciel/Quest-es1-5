package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    private TextView textResumo;
    private Button btnVoltar, btnPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo_pedido);

        textResumo = findViewById(R.id.textResumo);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnPagamento = findViewById(R.id.btnPagamento);

        // Recebendo os dados da tela anterior
        String nome = getIntent().getStringExtra("nome");
        String lanche = getIntent().getStringExtra("lanche"); // Correto nome da chave usada na Intent anterior

        // Validando e formatando o texto
        if (nome != null && lanche != null) {
            String resumo = "Olá, " + nome + "!\n\nSeu pedido é: " + lanche + ".\n\nClique em 'Ir para o pagamento' para finalizar seu pedido ou em 'Voltar' para refazê-lo.";
            textResumo.setText(resumo);
        } else {
            textResumo.setText("Erro ao receber os dados do pedido.");
        }

        // Ação do botão Voltar
        btnVoltar.setOnClickListener(v -> {
            Intent voltar = new Intent(ResumoActivity.this, MainActivity.class);
            voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(voltar);
        });

        // Ação do botão Pagamento (a implementar se necessário)
        // btnPagamento.setOnClickListener(...);
    }
}
