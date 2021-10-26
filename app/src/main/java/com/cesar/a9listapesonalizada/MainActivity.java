package com.cesar.a9listapesonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cesar.a9listapesonalizada.adaptadores.Adaptador;
import com.cesar.a9listapesonalizada.model.Entidad;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvItem;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = findViewById(R.id.lVItems);
        llenarItems();

        lvItem.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Intent intent= new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("item",arrayEntidad.get(posicion));
                startActivity(intent);
            }
        }));
    }

    private void llenarItems() {
        arrayEntidad.add(new Entidad(R.drawable.dbs_1,"SS BLUES","Goku y Vegeta"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_2,"SS ROSE","Goku y Black"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_3,"DB HEROES 1","Personajes Nuevos"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_4,"DB HEROES ","Otros personajes,Majin Boo"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_5,"VEGETA","Sacrificio Vegeta"));

        adaptador= new Adaptador(arrayEntidad,this);
        lvItem.setAdapter(adaptador);
    }
}