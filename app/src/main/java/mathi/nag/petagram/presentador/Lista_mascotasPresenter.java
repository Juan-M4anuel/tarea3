package mathi.nag.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import mathi.nag.petagram.db.ConstructorMascotas;
import mathi.nag.petagram.fragments.ILista_mascotasView;
import mathi.nag.petagram.pojo.Mascota;

public class Lista_mascotasPresenter implements ILista_mascotasPresenter {

    private ILista_mascotasView iLista_mascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public Lista_mascotasPresenter(ILista_mascotasView iLista_mascotasView, Context context){
        this.iLista_mascotasView = iLista_mascotasView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iLista_mascotasView.inicializarAdaptador(iLista_mascotasView.crearAdaptador(mascotas));
        iLista_mascotasView.generarLinearLayoutVertical();
    }
}
