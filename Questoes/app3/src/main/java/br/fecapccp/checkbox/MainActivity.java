package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComecar = findViewById(R.id.btnComecar);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia a FormularioActivity
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }
}
