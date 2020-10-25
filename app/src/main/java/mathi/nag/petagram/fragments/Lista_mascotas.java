package mathi.nag.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mathi.nag.petagram.R;
import mathi.nag.petagram.adaptadores.MascotaAdaptador;
import mathi.nag.petagram.pojo.Mascota;
import mathi.nag.petagram.presentador.ILista_mascotasPresenter;
import mathi.nag.petagram.presentador.Lista_mascotasPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Lista_mascotas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Lista_mascotas extends Fragment implements ILista_mascotasView {
/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

 */

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ILista_mascotasPresenter presenter;

/*
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Lista_mascotas() {
        // Required empty public constructor
    }

 */

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Lista_mascotas.
     */
    // TODO: Rename and change types and number of parameters

    /*
    public static Lista_mascotas newInstance(String param1, String param2) {
        Lista_mascotas fragment = new Lista_mascotas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new Lista_mascotasPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>(); //creo una nueva lista de contactos

        mascotas.add(new Mascota("Catty", R.drawable.d1, 0));
        mascotas.add(new Mascota("Puppy", R.drawable.chicle, 0));
        mascotas.add(new Mascota("Malon", R.drawable.caramelo, 0));
        mascotas.add(new Mascota("Roger", R.drawable.dos, 0));
        mascotas.add(new Mascota("Lucas", R.drawable.oip, 0));
        mascotas.add(new Mascota("otroperro", R.drawable.tres, 0));
        mascotas.add(new Mascota("unoperromas", R.drawable.cuatro, 0));




    }

     */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}