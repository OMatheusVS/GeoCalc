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

public class areaRetangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_retangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText baseR = findViewById(R.id.txtBaseR);
            EditText alturaR = findViewById(R.id.txtAlturaR);
            TextView resultadoR = findViewById(R.id.tvResultadoR);
            Button calcularR = findViewById(R.id.btnCalcularR);

            //Area Retangulo
            calcularR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (baseR.getText().toString().isEmpty() || alturaR.getText().toString().isEmpty()) {
                        Toast.makeText(areaRetangulo.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(baseR.getText().toString()) <= 0 || Double.parseDouble(alturaR.getText().toString()) <= 0) {
                        Toast.makeText(areaRetangulo.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        double baseT = Double.parseDouble(baseR.getText().toString());
                        double alturaT = Double.parseDouble(alturaR.getText().toString());
                        double area = (baseT * alturaT);
                        DecimalFormat df = new DecimalFormat("#.##");
                        resultadoR.setText(String.valueOf("Área = " + df.format(area) + " cm²"));
                        Toast.makeText(areaRetangulo.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return insets;
        });
    }
}