package com.mdgz.dam.labdam2022.bdd.pojo;


import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "alojamientos")
public class AlojamientoPojo {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_alojamiento")
    Integer id;

    @ColumnInfo(name = "titulo")
    String titulo;

    @ColumnInfo(name = "descripcion")
    String descripcion;

    @ColumnInfo(name = "capacidad")
    Integer capacidad;

    @ColumnInfo(name = "precio_base")
    Double precioBase;

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }
}
