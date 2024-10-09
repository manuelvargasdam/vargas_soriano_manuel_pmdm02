package com.vargas_soriano_manuel_pmdm02;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PersonajeDetalleActivity extends AppCompatActivity {

    private ImageView imageViewPersonajeDetail;
    private TextView textViewPersonajeName;
    private TextView textViewPersonajeDescription;
    private TextView textViewPersonajeAbilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detail);

        // Inicializa las vistas
        imageViewPersonajeDetail = findViewById(R.id.imageViewPersonajeDetail);
        textViewPersonajeName = findViewById(R.id.textViewPersonajeName);
        textViewPersonajeDescription = findViewById(R.id.textViewPersonajeDescription);
        textViewPersonajeAbilities = findViewById(R.id.textViewPersonajeAbilities);

        // Obtener los datos del Intent
        Intent intent = getIntent();
        String personajeName = intent.getStringExtra("personaje_name");
        int personajeImage = intent.getIntExtra("personaje_image", 0);
        String personajeDescription = intent.getStringExtra("personaje_description");
        String personajeAbilities = intent.getStringExtra("personaje_abilities");

        // Configurar los elementos de la vista
        imageViewPersonajeDetail.setImageResource(personajeImage);
        textViewPersonajeName.setText(personajeName);
        textViewPersonajeDescription.setText(personajeDescription);
        textViewPersonajeAbilities.setText(personajeAbilities);

        mostrarMensajeSeleccion(personajeName);

        // Mostrar un Toast al cargar los detalles
        //Toast.makeText(this, getString(R.string.detalles_cargados) + " "+personajeName, Toast.LENGTH_SHORT).show();

    }

    private void mostrarMensajeSeleccion(String personajeName) {
        String mensaje = getString(R.string.seleccion_personaje) + " " + personajeName;
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}