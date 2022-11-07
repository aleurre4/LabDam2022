package com.mdgz.dam.labdam2022.bdd;




import androidx.room.*;

import com.mdgz.dam.labdam2022.bdd.pojo.Reserva;

import java.util.List;

@Dao
public interface ReservaDAO {

    @Update
    public void update(Reserva r);

    @Delete
    public void delete(Reserva r);

    @Insert
    public void insert(Reserva r);

    @Query("SELECT * FROM reservas")
    public List<Reserva> loadAll();

}
