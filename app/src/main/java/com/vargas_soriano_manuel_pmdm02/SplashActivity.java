package com.vargas_soriano_manuel_pmdm02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Usamos un Handler para retrasar la navegación a la siguiente actividad
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Redirige a la actividad del listado de personajes
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza la actividad Splash para que no se pueda volver
            }
        }, 3000); // 3000 milisegundos = 3 segundos
    }
}
