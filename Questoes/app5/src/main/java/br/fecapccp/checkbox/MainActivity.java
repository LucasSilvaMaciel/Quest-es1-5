package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbMarguerita, cbPortuguesa;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder pizzasSelecionadas = new StringBuilder();

                if (cbCalabresa.isChecked()) {
                    pizzasSelecionadas.append("Calabresa, ");
                }
                if (cbMarguerita.isChecked()) {
                    pizzasSelecionadas.append("Marguerita, ");
                }
                if (cbPortuguesa.isChecked()) {
                    pizzasSelecionadas.append("Portuguesa, ");
                }

                if (pizzasSelecionadas.length() == 0) {
                    Toast.makeText(MainActivity.this, "Selecione pelo menos uma pizza!", Toast.LENGTH_SHORT).show();
                } else {
                    // Remove a última vírgula e espaço
                    if (pizzasSelecionadas.length() >= 2) {
                        pizzasSelecionadas.setLength(pizzasSelecionadas.length() - 2);
                    }

                    Intent intent = new Intent(MainActivity.this, TamanhoPagamento.class);
                    intent.putExtra("pizzasSelecionadas", pizzasSelecionadas.toString());
                    startActivity(intent);
                }
            }
        });
    }
}
