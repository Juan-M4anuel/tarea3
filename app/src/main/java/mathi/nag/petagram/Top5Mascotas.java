package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mathi.nag.petagram.adaptadores.MascotaAdaptador;
import mathi.nag.petagram.pojo.Mascota;

public class Top5Mascotas extends AppCompatActivity {

   private List<Mascota> mascotasFavoritas;
    private RecyclerView rvlistaFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_top_5);

        LinearLayoutManager llmFavoritas = new LinearLayoutManager(this);
        llmFavoritas.setOrientation(LinearLayoutManager.VERTICAL);



//             rvlistaFavoritos.setLayoutManager(llmFavoritas);

       //ArrayList<Mascota> lstmascotas = (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        rvlistaFavoritos = findViewById(R.id.rvTop5);
        rvlistaFavoritos.setLayoutManager(new LinearLayoutManager(this));

        inicializarListaMascotasFavoritas();
        inicializarAdaptadorFavoritas();

    }

    public void inicializarAdaptadorFavoritas(){

        MascotaAdaptador adaptador = new MascotaAdaptador((ArrayList<Mascota>) mascotasFavoritas,this);
        rvlistaFavoritos.setAdapter(adaptador);

    }

      public void inicializarListaMascotasFavoritas() {

           mascotasFavoritas = new ArrayList<>(); //listado de mascotas favoritas

          mascotasFavoritas.add(new Mascota("Roger", R.drawable.dos, 12));
          mascotasFavoritas.add(new Mascota("Lucas", R.drawable.oip, 9));
          mascotasFavoritas.add(new Mascota("otroperro", R.drawable.tres, 7));
          mascotasFavoritas.add(new Mascota("unoperromas", R.drawable.cuatro, 6));
          mascotasFavoritas.add(new Mascota("Catty", R.drawable.d1, 5));



       }


}
