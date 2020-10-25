package mathi.nag.petagram.adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mathi.nag.petagram.DetalleMascota;
import mathi.nag.petagram.R;
import mathi.nag.petagram.db.ConstructorMascotas;
import mathi.nag.petagram.pojo.Mascota;

public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    private int contador;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas; //construye nuestra lista de mascotas
        this.activity = activity;
    }

    @NonNull
    @Override
    //inflar el layout y lo pasara al viewholder para que el obtenga los views
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        //esta sentencia de arriba le da vida a nuestro layout
        return new MascotaViewHolder(v); //devuelve el constructor para tomar cada elemento
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {
        //en este metodo es que se setean los valores de los objetos de la lista de contactos
        final Mascota mascota = mascotas.get(position); //obtiene el objeto
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        //mascotaViewHolder.tvLikesCV.setText(mascota.getContador());
        mascotaViewHolder.contador.setText(String.valueOf(mascotas.get(position).getContador()) + "");


        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.contador.setText(constructorMascotas.obtenerLikesMascota(mascota));

            }
        });

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("nombre", mascota.getNombre());
                activity.startActivity(intent);
                //toast muestra el nombre del contacto
                //el mensaje Toast recibe un objeto activity como contexto este lo estaremos declarando como variable global en nuestra clase
            }
        });


    }
    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista
        return mascotas.size();

    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNombreCV;
        public TextView tvLikesCV;
        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView contador;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            contador = (TextView) itemView.findViewById(R.id.tvContadorCV);
        }
    }
}
