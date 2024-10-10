package com.vargas_soriano_manuel_pmdm02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * PersonajeDetalleActivity muestra los detalles de un personaje seleccionado.
 * Esta actividad recibe los datos del personaje a través de un Intent
 */
public class PersonajeDetalleActivity extends AppCompatActivity {

    // ImageView para mostrar la imagen del personaje en detalle.
    private ImageView imageViewPersonajeDetail;
    // TextView para mostrar el nombre del personaje.
    private TextView textViewPersonajeName;
    // TextView para mostrar la descripción del personaje.
    private TextView textViewPersonajeDescription;
    // TextView para mostrar las habilidades del personaje.
    private TextView textViewPersonajeAbilities;

    /**
     * Método que se ejecuta cuando se crea la actividad.
     * Inicializa las vistas y configura los datos del personaje
     *
     * @param savedInstanceState Si la actividad se reinicia, este Bundle contiene los datos más recientes.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detail);

        // Inicializa las vistas
        imageViewPersonajeDetail = findViewById(R.id.imageViewPersonajeDetail);
        textViewPersonajeName = findViewById(R.id.textViewPersonajeName);
        textViewPersonajeDescription = findViewById(R.id.textViewPersonajeDescription);
        textViewPersonajeAbilities = findViewById(R.id.textViewPersonajeAbilities);

        // Obtener los datos del Intent que inicia esta actividad
        Intent intent = getIntent();
        String personajeName = intent.getStringExtra("personaje_name");
        int personajeImage = intent.getIntExtra("personaje_image", 0);
        String personajeDescription = intent.getStringExtra("personaje_description");
        String personajeAbilities = intent.getStringExtra("personaje_abilities");

        // Configurar los elementos de la vista con los datos del personaje
        imageViewPersonajeDetail.setImageResource(personajeImage);
        textViewPersonajeName.setText(personajeName);
        textViewPersonajeDescription.setText(personajeDescription);
        textViewPersonajeAbilities.setText(personajeAbilities);

        // Mostrar un mensaje cuando se selecciona un personaje
        mostrarMensajeSeleccion(personajeName);
    }

    /**
     * Muestra un Toast con un mensaje indicando el nombre del personaje seleccionado.
     *
     * @param personajeName El nombre del personaje seleccionado.
     */
    private void mostrarMensajeSeleccion(String personajeName) {
        String mensaje = getString(R.string.seleccion_personaje) + " " + personajeName;
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
