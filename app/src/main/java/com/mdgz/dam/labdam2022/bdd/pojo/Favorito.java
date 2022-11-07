package com.mdgz.dam.labdam2022.bdd.pojo;


import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "favoritos" , primaryKeys = {"id_alojamiento","id_usuario"})
public class Favorito {


    @NonNull
    @ColumnInfo(name = "id_alojamiento")
    Integer alojamientoID;



    @NonNull
    @ColumnInfo(name = "id_usuario")
    Integer usuarioID;


    public Integer getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(Integer alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }
}
