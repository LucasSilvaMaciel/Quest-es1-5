package br.fecapccp.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.fecapccp.checkbox.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSalario;
    private RadioGroup radioGroup;
    private Button btnCalcular;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os componentes
        editTextSalario = findViewById(R.id.editTextDigiteSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnMostrarNovoSalario);
        textResultado = findViewById(R.id.textResultado);

        // Evento de clique no botão
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNovoSalario();
            }
        });
    }

    private void calcularNovoSalario() {
        String salarioStr = editTextSalario.getText().toString().trim();

        if (salarioStr.isEmpty()) {
            Toast.makeText(this, "Digite o salário!", Toast.LENGTH_SHORT).show();
            return;
        }

        double salario;
        try {
            salario = Double.parseDouble(salarioStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Digite um valor numérico válido!", Toast.LENGTH_SHORT).show();
            return;
        }

        double percentual = 0.0;
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            Toast.makeText(this, "Selecione um percentual!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Definir percentual baseado no RadioButton selecionado
        if (selectedId == R.id.radioButton40) {
            percentual = 0.40;
        } else if (selectedId == R.id.radioButton45) {
            percentual = 0.45;
        } else if (selectedId == R.id.radioButton50) {
            percentual = 0.50;
        }

        // Calcular novo salário
        double novoSalario = salario + (salario * percentual);
        textResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
    }
}
