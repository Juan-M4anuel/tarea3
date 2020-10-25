package mathi.nag.petagram.fragments;

import java.util.ArrayList;

import mathi.nag.petagram.adaptadores.MascotaAdaptador;
import mathi.nag.petagram.pojo.Mascota;

public interface ILista_mascotasView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
