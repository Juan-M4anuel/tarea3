package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
////////////////////////////////
        //con esto estamos diciendo que listacontactos que es un recyclerview se comporte como un Linearlayoutmanager
        inicializarListaMascotas();
        inicializarAdaptador();

    }

///////////////////////////////////////

    public void inicializarAdaptador() { //recibe la lista de contactos

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this); //se le agrego el activity
        listaMascotas.setAdapter(adaptador); //le pone el adaptador a la lista de mascotas
        //el recyclerview ya contiene el adaptador, que el recyclerview va a estar llamando al layout CARDVIEW_MASCOTA
        //va a estar pasandole todos los datos del arraylist a todos los views que el viewholder esta declarando

    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>(); //creo una nueva lista de contactos

        mascotas.add(new Mascota("Catty", R.drawable.d1, 0));
        mascotas.add(new Mascota("Puppy", R.drawable.chicle, 0));
        mascotas.add(new Mascota("Malon", R.drawable.caramelo, 0));
        mascotas.add(new Mascota("Roger", R.drawable.dos, 0));
        mascotas.add(new Mascota("Lucas", R.drawable.oip, 0));
        mascotas.add(new Mascota("otroperro", R.drawable.tres, 0));
        mascotas.add(new Mascota("unoperromas", R.drawable.cuatro, 0));


     //   ArrayList<String> nombresMascota = new ArrayList<>(); //crea una nueva lista solo con los nombres de las mascotas
       // for (Mascota mascota : mascotas) { //aqui la recorre y la llena
            //       nombresMascota.add(mascota.getNombre());
            // nombresMascota.add(getin Contador());*/

        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //recibe un menu de nombre menu
        getMenuInflater().inflate(R.menu.menu_opciones, menu); //trae el menu de opciones
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //recibe el item del menu seleccionado
        switch (item.getItemId()) {
            case R.id.mAbout:

                break;

            case R.id.mSettings:

                break;

            case R.id.mRefresh:

                Intent intent2 = new Intent(MainActivity.this, Top5Mascotas.class);
                startActivity(intent2);

                };

                return super.onOptionsItemSelected(item);
        }


    }

