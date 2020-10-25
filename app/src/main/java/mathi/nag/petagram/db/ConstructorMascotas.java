package mathi.nag.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mathi.nag.petagram.R;
import mathi.nag.petagram.pojo.Mascota;

public class ConstructorMascotas { //interactor

    private static final int LIKE = 1;

    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>(); //creo una nueva lista de contactos

           mascotas.add(new Mascota("Catty", R.drawable.d1, 0));
           mascotas.add(new Mascota("Puppy", R.drawable.chicle, 0));
           mascotas.add(new Mascota("Malon", R.drawable.caramelo, 0));
           mascotas.add(new Mascota("Roger", R.drawable.dos, 0));
           mascotas.add(new Mascota("Lucas", R.drawable.oip, 0));
           mascotas.add(new Mascota("otroperro", R.drawable.tres, 0));
           mascotas.add(new Mascota("unoperromas", R.drawable.cuatro, 0));

           return mascotas;

         */
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Catty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.d1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Puppy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.chicle);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Malon");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.caramelo);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public String obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.ObtenerLikesMascota(mascota);
    }
}
