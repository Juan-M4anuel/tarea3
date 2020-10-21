package mathi.nag.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.Objects;

public class Acerca_de extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}