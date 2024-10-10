package com.vargas_soriano_manuel_pmdm02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Actividad principal de la aplicación que muestra una lista de personajes en un RecyclerView.
 * Implementa un menú de opciones para mostrar un diálogo "Acerca de".
 */
public class MainActivity extends AppCompatActivity {

    // RecyclerView que muestra la lista de personajes.
    private RecyclerView recyclerView;
    // Adaptador que vincula los datos de los personajes con el RecyclerView.
    private AdapterPersonaje adapterPersonaje;
    // Lista de personajes que se mostrarán en la aplicación.
    private List<Personaje> personajeList;

    /**
     * Método que se ejecuta cuando la actividad es creada.
     * Inicializa la vista principal y configura el RecyclerView.
     *
     * @param savedInstanceState Si la actividad se reinicia, este Bundle contiene los datos más recientes.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración del RecyclerView.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Inicialización de la lista de personajes.
        personajeList = new ArrayList<>();
        personajeList.add(new Personaje("Mario", R.drawable.mario_image, "Héroe del Reino Champiñón", "Salta alto, Lucha contra Bowser"));
        personajeList.add(new Personaje("Luigi", R.drawable.luigi_image, "Hermano de Mario", "Más alto que Mario, Lucha contra fantasmas"));
        personajeList.add(new Personaje("Peach", R.drawable.peach_image, "Princesa del Reino Champiñón", "Puede flotar en el aire, Utiliza su paraguas para atacar, Líder valiente"));
        personajeList.add(new Personaje("Toad", R.drawable.toad_image, "Guardián del Reino Champiñón", "Pequeño y rápido, Ayuda a Mario"));

        // Configura el adaptador con la lista de personajes y lo asigna al RecyclerView.
        adapterPersonaje = new AdapterPersonaje(this, personajeList);
        recyclerView.setAdapter(adapterPersonaje);
    }

    /**
     * Infla el menú de opciones en la actividad.
     *
     * @param menu El menú en el cual se agregarán los elementos.
     * @return true si el menú es inflado correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja las acciones de los ítems del menú cuando son seleccionados.
     *
     * @param item El ítem del menú que fue seleccionado.
     * @return true si se maneja correctamente la acción del ítem, de lo contrario llama a la superclase.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Si se selecciona la opción "Acerca de", se muestra un diálogo.
        if (id == R.id.menu_acerca_de) {
            mostrarDialogoAcercaDe();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un cuadro de diálogo con información "Acerca de" la aplicación.
     */
    private void mostrarDialogoAcercaDe() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_acerca_de)
                .setMessage(R.string.acerca_de_message)
                .setPositiveButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                    /**
                     * Maneja la acción de cerrar el cuadro de diálogo cuando se presiona el botón "Cerrar".
                     *
                     * @param dialog El cuadro de diálogo que se está mostrando.
                     * @param id     El id del botón presionado, no es utilizado en este caso.
                     */
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
