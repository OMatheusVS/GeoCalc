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

public class areaTrapezio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_trapezio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText baseMa = findViewById(R.id.txtBaseMaT);
            EditText baseMe = findViewById(R.id.txtBaseMeT);
            EditText alturaT = findViewById(R.id.txtAlturaTr);
            TextView resultado = findViewById(R.id.tvResultadoTr);
            Button calcular = findViewById(R.id.btnCalcularTr);

            //Area Trapezio
            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (baseMa.getText().toString().isEmpty() || alturaT.getText().toString().isEmpty() || baseMe.getText().toString().isEmpty()) {
                        Toast.makeText(areaTrapezio.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(baseMa.getText().toString()) <= 0 || Double.parseDouble(alturaT.getText().toString()) <= 0 || Double.parseDouble(baseMe.getText().toString()) <= 0) {
                        Toast.makeText(areaTrapezio.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        double baseTMa = Double.parseDouble(baseMa.getText().toString());
                        double baseTMe = Double.parseDouble(baseMe.getText().toString());
                        double alturaTr = Double.parseDouble(alturaT.getText().toString());
                        double area = ((baseTMa + baseTMe) * alturaTr) / 2;

                        DecimalFormat df = new DecimalFormat("#.##");
                        resultado.setText(String.valueOf("Área = " + df.format(area) + " cm²"));
                        Toast.makeText(areaTrapezio.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return insets;
        });
    }
}