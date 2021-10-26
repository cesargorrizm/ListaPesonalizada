package com.cesar.a9listapesonalizada.model;

import java.io.Serializable;

public class Entidad implements Serializable {
    //la imagen es un entero por que hace referencia al id de la imagen
    private int imgFoto;

    private String titulo;

    private String contenido;
    public Entidad(int imgFoto, String titulo, String contenido) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }


}
