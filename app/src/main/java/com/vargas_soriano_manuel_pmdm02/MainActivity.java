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

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterPersonaje adapterPersonaje;
    private List<Personaje> personajeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        personajeList = new ArrayList<>();
        personajeList.add(new Personaje("Mario", R.drawable.mario_image, "Héroe del Reino Champiñón", "Salta alto, Lucha contra Bowser"));
        personajeList.add(new Personaje("Luigi", R.drawable.luigi_image, "Hermano de Mario", "Más alto que Mario, Lucha contra fantasmas"));
        personajeList.add(new Personaje("Toad", R.drawable.toad_image, "Guardián del Reino Champiñón", "Pequeño y rápido, Ayuda a Mario"));
        personajeList.add(new Personaje("Yoshi", R.drawable.yoshi_image, "Compañero de Mario", "Come enemigos, Salta muy alto"));


        adapterPersonaje = new AdapterPersonaje(this, personajeList);
        recyclerView.setAdapter(adapterPersonaje);
    }


    // Método para inflar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // Método para manejar el clic en los ítems del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_acerca_de) {
            mostrarDialogoAcercaDe();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Método para mostrar el diálogo "Acerca de..."
    private void mostrarDialogoAcercaDe() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_acerca_de)
                .setMessage(R.string.acerca_de_message)
                .setPositiveButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}