package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;

import java.util.Objects;

public class Formulario extends AppCompatActivity {

    private EditText inNombre;
    private EditText inEmail;
    private EditText inMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        inNombre = (EditText)findViewById(R.id.inNombre);
        inEmail = (EditText)findViewById(R.id.inEmail);
        inMensaje = (EditText)findViewById(R.id.inMesanje);


    }
}