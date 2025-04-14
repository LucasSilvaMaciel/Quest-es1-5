package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoPedido extends AppCompatActivity {

    TextView textViewResumo;
    Button btnPagamento, btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        textViewResumo = findViewById(R.id.textView);
        btnPagamento = findViewById(R.id.btnPagamento);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Recupera os dados enviados pelas outras Activities
        Intent intent = getIntent();
        String pizzasSelecionadas = intent.getStringExtra("pizzasSelecionadas");
        String tamanho = intent.getStringExtra("tamanhoSelecionado");
        String pagamento = intent.getStringExtra("pagamentoSelecionado");
        double valorTamanho = intent.getDoubleExtra("valorTamanho", 0.0);

        // Calcular o valor total da pizza com base nas seleções
        double valorBase = 0.0;

        if (pizzasSelecionadas.contains("Calabresa")) {
            valorBase += 30.0;
        }
        if (pizzasSelecionadas.contains("Marguerita")) {
            valorBase += 25.0;
        }
        if (pizzasSelecionadas.contains("Portuguesa")) {
            valorBase += 35.0;
        }

        double valorTotal = valorBase + valorTamanho;

        String resumo = "Seu pedido será uma pizza de: " + pizzasSelecionadas +
                "\nNo tamanho: " + tamanho +
                "\nForma de pagamento: " + pagamento +
                "\n\nValor total: R$ " + String.format("%.2f", valorTotal) +
                "\n\nClique em 'Pagamento' para continuar ou 'Voltar' para refazer o pedido.";

        textViewResumo.setText(resumo);

        // Botão de pagamento não faz nada

        // Botão voltar leva para MainActivity
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPedido.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}