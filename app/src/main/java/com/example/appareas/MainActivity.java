package com.example.appareas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View mainLayout = findViewById(R.id.main);
        
        // Aplica animação de entrada suave em todo o layout
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        mainLayout.startAnimation(fadeIn);

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialização dos botões
        configurarBotao(R.id.btnQuadrado, areaQuadrado.class);
        configurarBotao(R.id.btnTriangulo, areaTriangulo.class);
        configurarBotao(R.id.btnCirculo2, areaCirculo.class);
        configurarBotao(R.id.btnRetangulo2, areaRetangulo.class);
        configurarBotao(R.id.btnTrapezio, areaTrapezio.class);
        configurarBotao(R.id.btnLosango, areaLosango.class);
    }

    /**
     * Configura o clique do botão com animação e transição de tela
     */
    private void configurarBotao(int id, Class<?> targetActivity) {
        Button botao = findViewById(id);
        botao.setOnClickListener(v -> {
            // Efeito visual de clique (escala)
            v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction(() -> {
                v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                
                // Inicia a nova atividade
                Intent intent = new Intent(MainActivity.this, targetActivity);
                startActivity(intent);
                
                // Transição suave entre telas
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }).start();
        });
    }
}