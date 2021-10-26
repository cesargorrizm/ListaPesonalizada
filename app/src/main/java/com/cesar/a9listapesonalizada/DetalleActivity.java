package com.cesar.a9listapesonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cesar.a9listapesonalizada.model.Entidad;

public class DetalleActivity extends AppCompatActivity {
    private TextView tvTitulo;
    private TextView tvDescripcion;
    private ImageView imgFoto;
    private Entidad item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        item = (Entidad) getIntent().getSerializableExtra("item");
        if (item!= null){
            tvTitulo= findViewById(R.id.tvTituloDetalle);
            tvDescripcion= findViewById(R.id.tvDescripcionDetalle);
            imgFoto= findViewById(R.id.imgFotoDetalle);

            tvTitulo.setText(item.getTitulo());
            imgFoto.setImageResource(item.getImgFoto());
            tvDescripcion.setText(item.getContenido());
        }
    }
}