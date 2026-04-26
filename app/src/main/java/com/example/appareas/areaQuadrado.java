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

import java.text.DecimalFormat;

public class areaQuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_quadrado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText ladoQ = findViewById(R.id.txtLadoQ);
            TextView resultado = findViewById(R.id.tvResultadoQ);
            Button calcular = findViewById(R.id.btnCalcularQ);

            //Area Quadrado
            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ladoQ.getText().toString().isEmpty()) {
                        Toast.makeText(areaQuadrado.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(ladoQ.getText().toString()) <= 0) {
                        Toast.makeText(areaQuadrado.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(areaQuadrado.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                        double lado = Double.parseDouble(ladoQ.getText().toString());
                        double area = Math.pow(lado, 2);
                        DecimalFormat df = new DecimalFormat("#.##");
                        resultado.setText(String.valueOf("Área = " + df.format(area) + " cm²"));
                        return;
                    }
                }
            });

            return insets;
        });
    }
}