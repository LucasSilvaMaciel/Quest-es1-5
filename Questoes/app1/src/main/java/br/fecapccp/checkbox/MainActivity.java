package br.fecapccp.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import br.fecapccp.checkbox.R;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    private Button btnTotal;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);
        btnTotal = findViewById(R.id.btnTotal);
        textResultado = findViewById(R.id.textResultado);

        // Corrigindo os preços conforme o enunciado
        cbArroz.setText("Arroz (R$2,69)");
        cbLeite.setText("Leite (R$2,70)");
        cbCarne.setText("Carne (R$16,70)");
        cbFeijao.setText("Feijão (R$3,38)");
        cbRefrigerante.setText("Refrigerante Coca-Cola (R$3,00)");

        // Evento de clique do botão
        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        double total = 0.0;

        if (cbArroz.isChecked()) total += 2.69;
        if (cbLeite.isChecked()) total += 2.70;
        if (cbCarne.isChecked()) total += 16.70;
        if (cbFeijao.isChecked()) total += 3.38;
        if (cbRefrigerante.isChecked()) total += 3.00;

        textResultado.setText(String.format("Total da compra: R$ %.2f", total));
    }
}
