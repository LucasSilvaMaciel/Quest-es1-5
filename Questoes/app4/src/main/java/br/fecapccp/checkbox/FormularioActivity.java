package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class FormularioActivity extends AppCompatActivity {

    TextInputEditText textNome;
    CheckBox cbCarne, cbFrango, cbPeixe;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_pedido);

        textNome = findViewById(R.id.textinputNome);
        cbCarne = findViewById(R.id.cbCarne2);
        cbFrango = findViewById(R.id.cbFrango);
        cbPeixe = findViewById(R.id.cbCarne3);
        btnContinuar = findViewById(R.id.btnContinuar);

        // Permitir apenas um CheckBox selecionado por vez
        cbCarne.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbFrango.setChecked(false);
                cbPeixe.setChecked(false);
            }
        });

        cbFrango.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbCarne.setChecked(false);
                cbPeixe.setChecked(false);
            }
        });

        cbPeixe.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                cbCarne.setChecked(false);
                cbFrango.setChecked(false);
            }
        });

        btnContinuar.setOnClickListener(v -> {
            String nome = textNome.getText().toString().trim();
            String lanche = "";

            if (nome.isEmpty()) {
                Toast.makeText(FormularioActivity.this, "Digite seu nome!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cbCarne.isChecked()) {
                lanche = "Lanche de carne";
            } else if (cbFrango.isChecked()) {
                lanche = "Lanche de frango";
            } else if (cbPeixe.isChecked()) {
                lanche = "Lanche de peixe";
            } else {
                Toast.makeText(FormularioActivity.this, "Selecione um lanche!", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(FormularioActivity.this, ResumoActivity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("lanche", lanche);
            startActivity(intent);
        });
    }
}
