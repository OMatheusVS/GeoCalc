package com.example.appareas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class areaCirculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_circulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText raio = findViewById(R.id.txtRaioC);
            TextView resultado = findViewById(R.id.tvResultadoC);
            Button calcular = findViewById(R.id.btnCalcularC);


            //Area Circulo
            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (raio.getText().toString().isEmpty()) {
                        Toast.makeText(areaCirculo.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(raio.getText().toString()) <= 0) {
                        Toast.makeText(areaCirculo.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(areaCirculo.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                        double raioC = Double.parseDouble(raio.getText().toString());
                        double area = Math.PI * Math.pow(raioC, 2);
                        resultado.setText(String.valueOf("Área = " + area + " cm²"));
                        return;
                    }
                }
            });

            return insets;
        });
    }
}