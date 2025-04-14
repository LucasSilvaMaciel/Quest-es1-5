package br.fecapccp.checkbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnComecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComecar = findViewById(R.id.btnContinuar);

        btnComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }
}