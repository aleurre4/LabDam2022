package com.mdgz.dam.labdam2022.bdd;

import com.mdgz.dam.labdam2022.bdd.pojo.Reserva;

public class ReservaDataSource implements DataSource<Reserva>{

    ReservaDAO dao;

    public ReservaDataSource(ReservaDAO dao){

        this.dao = dao;


    }

    @Override
    public void guardarXYZ(Reserva entidad, GuardarCallback callback) {

        dao.insert(entidad);

    }

    @Override
    public void recuperarXYZ(RecuperarCallback callback) {

        dao.loadAll();
    }
}
