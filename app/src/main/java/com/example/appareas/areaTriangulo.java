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

public class areaTriangulo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_triangulo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText base = findViewById(R.id.txtBase);
            EditText altura = findViewById(R.id.txtAltura);
            TextView resultado = findViewById(R.id.tvResultado);
            Button calcular = findViewById(R.id.btnCalcular);

            //Area Triangulo
            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (base.getText().toString().isEmpty() || altura.getText().toString().isEmpty()) {
                        Toast.makeText(areaTriangulo.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(base.getText().toString()) <= 0 || Double.parseDouble(altura.getText().toString()) <= 0) {
                        Toast.makeText(areaTriangulo.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        double baseT = Double.parseDouble(base.getText().toString());
                        double alturaT = Double.parseDouble(altura.getText().toString());
                        double area = (baseT * alturaT) / 2;
                        DecimalFormat df = new DecimalFormat("#.##");
                        resultado.setText(String.valueOf("Área = " + df.format(area) + " cm²"));
                        Toast.makeText(areaTriangulo.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            return insets;
        });
    }
}