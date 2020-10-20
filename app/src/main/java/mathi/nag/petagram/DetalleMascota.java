package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Objects;

public class DetalleMascota extends AppCompatActivity {

    //declaro los textViews como globales. se declaran privados para que solo sean utiles para la clase
    private TextView tvNombre;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        Bundle parametros = getIntent().getExtras();

        String nombre   = parametros.getString(getResources().getString(R.string.pnombre)); //recibe el parametro nombre


        //se declaran los textViews
        tvNombre   = (TextView) findViewById(R.id.tvNombre);

        //ahora puedo colocar los parametros en los textviews
        tvNombre.setText(nombre);


    }

}