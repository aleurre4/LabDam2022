package com.mdgz.dam.labdam2022.bdd;



import androidx.room.*;

import com.mdgz.dam.labdam2022.bdd.pojo.Favorito;

import java.util.List;

@Dao
public interface FavoritoDAO {

    @Update
    public void update(Favorito f);

    @Delete
    public void delete(Favorito f);

    @Insert
    public void insert(Favorito f);

    @Query("SELECT * FROM favoritos")
    public List<Favorito> loadAll();

}
