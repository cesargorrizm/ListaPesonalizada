package com.cesar.a9listapesonalizada.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesar.a9listapesonalizada.DetalleActivity;
import com.cesar.a9listapesonalizada.R;
import com.cesar.a9listapesonalizada.model.Entidad;

import java.util.ArrayList;
//4-Extendemos la clase Baase adapter
public class Adaptador extends BaseAdapter {
    //1- Creamos el array lis de entidad que son los datos que mostrara el listView
    private ArrayList<Entidad> listEntidad;


    //2- Creamos un contexto
    private Context contex;
    private LayoutInflater inflater;
    //3- Generamos el constructor
    public Adaptador(ArrayList<Entidad> listEntidad, Context contex) {
        this.listEntidad = listEntidad;
        this.contex = contex;
    }
    //Este metodo indicara al listView cuantos datos o numero de objetos se van a cargar
    @Override
    public int getCount() {
        return listEntidad.size();
    }
    //Este metodo devolvera la posicion
    @Override
    public Object getItem(int posicion) {
        return listEntidad.get(posicion);
    }
    //Aqui se creara cada item y se le asignara los valores de cada elemenrto
    @Override
    public long getItemId(int i) {
        return 0;
    }
    //Aqui se creara cada item y se le asignara los valores de cada elemenrto
    @Override
    public View getView(int posicion, View converView, ViewGroup viewGroup) {
        //obtenemos el objeto por cada Item a mostrar
        final Entidad entidad= (Entidad) getItem(posicion);
        //cramos e inicializamos los elementos del item de la lista
        converView = LayoutInflater.from(contex).inflate(R.layout.item,null);

        ImageView imageView= converView.findViewById(R.id.imgFoto);
        TextView tvTitulo = converView.findViewById(R.id.tvTitulo);
        TextView tvContenido = converView.findViewById(R.id.tvContenido);

        //Llenamos los elementos con los valores de cada item
        imageView.setImageResource(entidad.getImgFoto());
        tvTitulo.setText(entidad.getTitulo());
        tvContenido.setText(entidad.getContenido());
        //Gestionamos el evento clik
        converView.setOnClickListener(view -> {
            Intent i = new Intent(contex, DetalleActivity.class);
            i.putExtra("item",entidad);
            contex.startActivity(i);
        });

        return converView;
    }
}
