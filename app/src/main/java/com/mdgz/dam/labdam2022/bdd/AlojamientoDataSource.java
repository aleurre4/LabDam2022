package com.mdgz.dam.labdam2022.bdd;

import com.mdgz.dam.labdam2022.bdd.pojo.AlojamientoPojo;
import com.mdgz.dam.labdam2022.model.Alojamiento;

public class AlojamientoDataSource implements DataSource<AlojamientoPojo> {


    AlojamientoDAO dao;

    public AlojamientoDataSource(AlojamientoDAO dao) {

        this.dao = dao;


    }

    @Override
    public void guardarXYZ(AlojamientoPojo entidad, GuardarCallback callback) {

        dao.insert(entidad);

    }

    @Override
    public void recuperarXYZ(RecuperarCallback callback) {

        dao.loadAll();
    }
}