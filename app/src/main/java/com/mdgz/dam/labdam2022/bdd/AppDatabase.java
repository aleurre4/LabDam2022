package com.mdgz.dam.labdam2022.bdd;


import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.*;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.mdgz.dam.labdam2022.bdd.pojo.AlojamientoPojo;

import com.mdgz.dam.labdam2022.bdd.pojo.Favorito;
import com.mdgz.dam.labdam2022.bdd.pojo.Reserva;
import com.mdgz.dam.labdam2022.repo.AlojamientoRepository;

import java.util.concurrent.Executors;


@Database(entities = {
        Favorito.class, Reserva.class , AlojamientoPojo.class
   },version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public abstract FavoritoDAO favoritoDAO();

    public abstract ReservaDAO reservaDAO();


    public abstract AlojamientoDAO alojamientoDAO();


    public synchronized static AppDatabase getInstance(Context context){
        if(INSTANCE == null){

            INSTANCE = buildDatebase(context);

        }

        return INSTANCE;


    }

    private static AppDatabase buildDatebase(final Context context){

        return Room.databaseBuilder(context,AppDatabase.class,"moviles.db").addCallback(
                new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
//
                    }
                }
        ).build();

    };


}
