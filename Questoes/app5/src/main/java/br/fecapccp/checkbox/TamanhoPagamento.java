package br.fecapccp.checkbox;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class TamanhoPagamento extends AppCompatActivity {

    RadioButton rbPequena, rbMedia, rbGrande;
    RadioButton rdDinheiro, rdCartão, rdPix;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar);

        // Recupera pizzas selecionadas da MainActivity
        Intent intent = getIntent();
        String pizzasSelecionadas = intent.getStringExtra("pizzasSelecionadas");

        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);

        rdDinheiro = findViewById(R.id.rdDinheiro);
        rdCartão = findViewById(R.id.rdCartão);
        rdPix = findViewById(R.id.rdPix);

        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tamanho = "";
                double valorTamanho = 0;

                if (rbPequena.isChecked()) {
                    tamanho = "Pequena";
                    valorTamanho = 5.00;
                } else if (rbMedia.isChecked()) {
                    tamanho = "Média";
                    valorTamanho = 10.00;
                } else if (rbGrande.isChecked()) {
                    tamanho = "Grande";
                    valorTamanho = 15.00;
                } else {
                    Toast.makeText(TamanhoPagamento.this, "Selecione o tamanho da pizza!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String pagamento = "";

                if (rdDinheiro.isChecked()) {
                    pagamento = "Dinheiro";
                } else if (rdCartão.isChecked()) {
                    pagamento = "Cartão";
                } else if (rdPix.isChecked()) {
                    pagamento = "Pix";
                } else {
                    Toast.makeText(TamanhoPagamento.this, "Selecione o método de pagamento!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intentResumo = new Intent(TamanhoPagamento.this, ResumoPedido.class);
                intentResumo.putExtra("pizzasSelecionadas", pizzasSelecionadas);
                intentResumo.putExtra("tamanhoSelecionado", tamanho);
                intentResumo.putExtra("pagamentoSelecionado", pagamento);
                intentResumo.putExtra("valorTamanho", valorTamanho);
                startActivity(intentResumo);
            }
        });
    }
}