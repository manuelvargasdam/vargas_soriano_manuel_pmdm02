package com.vargas_soriano_manuel_pmdm02;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterPersonaje extends RecyclerView.Adapter<AdapterPersonaje.PersonajeViewHolder> {

    private List<Personaje> personajeList;
    private Context context;

    public AdapterPersonaje(Context context, List<Personaje> personajeList) {
        this.context = context;
        this.personajeList = personajeList;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajeList.get(position);
        holder.textViewPersonajeName.setText(personaje.getName());
        holder.imageViewPersonaje.setImageResource(personaje.getImageResource());


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

    @Override
    public int getItemCount() {
        return personajeList.size();
    }

    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPersonaje;
        TextView textViewPersonajeName;

        PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPersonaje = itemView.findViewById(R.id.imageViewPersonaje);
            textViewPersonajeName = itemView.findViewById(R.id.textViewPersonajeName);
        }
    }
}
