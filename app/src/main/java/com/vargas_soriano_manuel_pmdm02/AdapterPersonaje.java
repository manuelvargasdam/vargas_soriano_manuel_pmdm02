package com.vargas_soriano_manuel_pmdm02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * AdapterPersonaje es un adaptador personalizado que gestiona el listado de personajes
 * en un RecyclerView. Vincula los datos de cada personaje con el layout.
 */
public class AdapterPersonaje extends RecyclerView.Adapter<AdapterPersonaje.PersonajeViewHolder> {

    // Lista de personajes que se mostrará en el RecyclerView.
    private List<Personaje> personajeList;
    // Contexto de la actividad donde se utiliza el RecyclerView.
    private Context context;

    /**
     * Constructor de la clase AdapterPersonaje.
     *
     * @param context       El contexto de la actividad o fragmento donde se mostrará el RecyclerView.
     * @param personajeList La lista de personajes que se vincularán con el adaptador.
     */
    public AdapterPersonaje(Context context, List<Personaje> personajeList) {
        this.context = context;
        this.personajeList = personajeList;
    }

    /**
     * Infla el layout para cada elemento de la lista y crea un nuevo ViewHolder.
     *
     * @param parent   El ViewGroup padre al cual se añadirá el layout inflado.
     * @param viewType Tipo de vista, en este caso no se usa ya que todos los elementos son iguales.
     * @return Un nuevo objeto PersonajeViewHolder que contendrá las vistas para un personaje.
     */
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    /**
     * Vincula los datos del personaje con las vistas del ViewHolder.     *
     * @param holder   El ViewHolder que contiene las vistas donde se mostrarán los datos.
     * @param position La posición del personaje en la lista de personajes.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajeList.get(position);
        holder.textViewPersonajeName.setText(personaje.getName());
        holder.imageViewPersonaje.setImageResource(personaje.getImageResource());

        // Configura un click listener para cada item que mostrará una nueva actividad con los detalles del personaje.
        holder.itemView.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(context, PersonajeDetalleActivity.class);
                intent.putExtra("personaje_name", personaje.getName());
                intent.putExtra("personaje_image", personaje.getImageResource());
                intent.putExtra("personaje_description", personaje.getDescription());
                intent.putExtra("personaje_abilities", personaje.getAbilities());

                context.startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(context, R.string.error_detalles_cargados, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Devuelve el número total de personajes en la lista.     *
     * @return El tamaño de la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return personajeList.size();
    }

    /**
     * Representa el ViewHolder para cada personaje. Contiene las vistas que se deben llenar con la información de cada personaje.
     */
    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        // ImageView que muestra la imagen del personaje.
        ImageView imageViewPersonaje;
        // TextView que muestra el nombre del personaje.
        TextView textViewPersonajeName;

        /**
         * Constructor del ViewHolder. Inicializa las vistas del layout.         *
         * @param itemView La vista raíz del layout para cada personaje.
         */
        PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPersonaje = itemView.findViewById(R.id.imageViewPersonaje);
            textViewPersonajeName = itemView.findViewById(R.id.textViewPersonajeName);
        }
    }
}
