package mathi.nag.petagram.pojo;

import androidx.appcompat.app.AppCompatActivity;

public class Mascota extends AppCompatActivity {

    private String nombre;
    private int foto;
    private int contador;
    //private boolean orden;

    public Mascota(String nombre, int foto, int contador) {
        this.nombre = nombre;
        this.foto = foto;
        this.contador = contador;
        //this.orden = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

   // public void setOrdenar(boolean orden) { this.orden = orden;}

    /*@Override
    public int compareTo(Mascota mascota) {

        if (orden == true)
            return (this.getNombre().compareTo(mascota.getNombre()));
        else {
            if (this.getContador() < mascota.getContador()) return -1;
            else if (this.getContador() == mascota.getContador()) return 0;
            else return 1;
        }*/
    }

