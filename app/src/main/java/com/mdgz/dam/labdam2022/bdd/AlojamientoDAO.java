package com.mdgz.dam.labdam2022.bdd;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mdgz.dam.labdam2022.bdd.pojo.AlojamientoPojo;
import com.mdgz.dam.labdam2022.model.Alojamiento;


import java.util.List;


@Dao
public interface AlojamientoDAO {

        @Update
        public void update(AlojamientoPojo a);

        @Delete
        public void delete(AlojamientoPojo a);

        @Insert
        public void insert(AlojamientoPojo a);

        @Query("SELECT * FROM alojamientos")
        public List<AlojamientoPojo> loadAll();





    }
