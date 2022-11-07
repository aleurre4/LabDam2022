package com.mdgz.dam.labdam2022.bdd.pojo;


import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "reservas" , primaryKeys = {"id_alojamiento" , "id_usuario"} )
public class Reserva {


    @NonNull
    @ColumnInfo(name = "id_alojamiento")
    Integer alojamientoID;

    @NonNull
    @ColumnInfo(name = "id_usuario")
    Integer usuarioID;

    @ColumnInfo(name = "fecha_ingreso")
    String fechaIngreso;

    @ColumnInfo(name = "fecha_salida")
    String fechaSalida;

    public Integer getAlojamientoID() {return alojamientoID;}

    public void setAlojamientoID(Integer alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
