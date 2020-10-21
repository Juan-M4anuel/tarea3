package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import mathi.nag.petagram.adaptadores.MascotaAdaptador;
import mathi.nag.petagram.adaptadores.PageAdapter;
import mathi.nag.petagram.fragments.Lista_mascotas;
import mathi.nag.petagram.fragments.Perfil;
import mathi.nag.petagram.pojo.Mascota;

public class MainActivity extends AppCompatActivity {


    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new Lista_mascotas());
        fragments.add(new Perfil());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_house);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_lobo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //recibe un menu de nombre menu
        getMenuInflater().inflate(R.menu.menu_opciones, menu); //trae el menu de opciones
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //recibe el item del menu seleccionado

        if (item.getItemId() == R.id.contacto){
            Intent i = new Intent(MainActivity.this, Formulario.class);
            startActivity(i);
        }else if (item.getItemId() == R.id.Acerca_de){
            Intent i2 = new Intent(MainActivity.this, Acerca_de.class);
            startActivity(i2);
        }else if (item.getItemId() == R.id.mRefresh){
            Intent intent2 = new Intent(MainActivity.this, Top5Mascotas.class);
            startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);
        }


    }

