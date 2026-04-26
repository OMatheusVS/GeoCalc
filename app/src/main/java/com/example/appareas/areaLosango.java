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

public class areaLosango extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_losango);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            EditText diagonalMa = findViewById(R.id.txtDiagonalMa);
            EditText diagonalMe = findViewById(R.id.txtDiagonalMe);
            TextView resultado = findViewById(R.id.tvResultadoL);
            Button calcular = findViewById(R.id.btnCalcularL);

            //Area Losango
            calcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (diagonalMa.getText().toString().isEmpty() || diagonalMe.getText().toString().isEmpty()) {
                        Toast.makeText(areaLosango.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(diagonalMa.getText().toString()) <= 0 || Double.parseDouble(diagonalMe.getText().toString()) <= 0) {
                        Toast.makeText(areaLosango.this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        double diagonalLMa = Double.parseDouble(diagonalMa.getText().toString());
                        double diagonalLMe = Double.parseDouble(diagonalMe.getText().toString());
                        double area = (diagonalLMa * diagonalLMe) / 2;

                        DecimalFormat df = new DecimalFormat("#.##");
                        resultado.setText(String.valueOf("Área = " + df.format(area) + " cm²"));
                        Toast.makeText(areaLosango.this, "Cálculo realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return insets;
        });
    }
}